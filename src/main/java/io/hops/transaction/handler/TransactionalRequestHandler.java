/*
 * Copyright (C) 2015 hops.io.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.hops.transaction.handler;

import io.hops.exception.LockUpgradeException;
import io.hops.exception.StorageException;
import io.hops.exception.TransientStorageException;
import io.hops.log.NDCWrapper;
import io.hops.transaction.EntityManager;
import io.hops.transaction.TransactionInfo;
import io.hops.transaction.context.TransactionsStats;
import io.hops.transaction.lock.Lock;
import io.hops.transaction.lock.TransactionLockAcquirer;
import io.hops.transaction.lock.TransactionLocks;

import java.io.IOException;

public abstract class TransactionalRequestHandler extends RequestHandler {

  public TransactionalRequestHandler(OperationType opType) {
    super(opType);
  }

  @Override
  protected Object execute(Object info) throws IOException {
    boolean committed = false;
    int tryCount = 0;
    IOException ignoredException;
    Object txRetValue = null;

    while (tryCount <= RETRY_COUNT) {
      long expWaitTime = exponentialBackoff();
      long txStartTime = System.currentTimeMillis();
      long oldTime = System.currentTimeMillis();

      long setupTime = -1;
      long beginTxTime = -1;
      long acquireLockTime = -1;
      long inMemoryProcessingTime = -1;
      long commitTime = -1;
      long totalTime = -1;
      TransactionLockAcquirer locksAcquirer = null;

      tryCount++;
      ignoredException = null;
      committed = false;
      
      EntityManager.preventStorageCall(false);
      try {
        setNDC(info);
        if(requestHandlerLOG.isTraceEnabled()) {
          requestHandlerLOG.trace("Pretransaction phase started");
        }
        preTransactionSetup();
        //sometimes in setup we call light weight request handler that messes up with the NDC
        removeNDC();
        setNDC(info);
        setupTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        if(requestHandlerLOG.isTraceEnabled()) {
          requestHandlerLOG.trace("Pretransaction phase finished. Time " + setupTime + " ms");
        }
        setRandomPartitioningKey();
        EntityManager.begin();
        if(requestHandlerLOG.isTraceEnabled()) {
          requestHandlerLOG.trace("TX Started");
        }
        beginTxTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        
        locksAcquirer = newLockAcquirer();
        acquireLock(locksAcquirer.getLocks());

        locksAcquirer.acquire();

        acquireLockTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        if(requestHandlerLOG.isTraceEnabled()){
          requestHandlerLOG.trace("All Locks Acquired. Time " + acquireLockTime + " ms");
        }
        //sometimes in setup we call light weight request handler that messes up with the NDC
        removeNDC();
        setNDC(info);
        EntityManager.preventStorageCall(true);
        try {
          txRetValue = performTask();
        } catch (IOException e) {
          if (shouldAbort(e)) {
            throw e;
          } else {
            ignoredException = e;
          }
        }
        inMemoryProcessingTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        if(requestHandlerLOG.isTraceEnabled()) {
          requestHandlerLOG.trace("In Memory Processing Finished. Time " + inMemoryProcessingTime + " ms");
        }

        TransactionsStats.TransactionStat stat = TransactionsStats.getInstance()
            .collectStats(opType,
            ignoredException);

        EntityManager.commit(locksAcquirer.getLocks());
        committed = true;
        commitTime = (System.currentTimeMillis() - oldTime);
        if(stat != null){
          stat.setTimes(acquireLockTime, inMemoryProcessingTime, commitTime);
        }

        if(requestHandlerLOG.isTraceEnabled()) {
          requestHandlerLOG.trace("TX committed. Time " + commitTime + " ms");
        }
        totalTime = (System.currentTimeMillis() - txStartTime);
        if(requestHandlerLOG.isTraceEnabled()) {
          String opName = !NDCWrapper.NDCEnabled()?opType+" ":"";
          requestHandlerLOG.trace(opName+"TX Finished. TX Stats: Try Count: " + tryCount +
                  " Stepup: " + setupTime + " ms, Begin Tx:" +
                  beginTxTime + " ms, Acquire Locks: " + acquireLockTime +
                  "ms, In Memory Processing: " + inMemoryProcessingTime +
                  "ms, Commit Time: " + commitTime + "ms, Total Time: " + totalTime +
                  "ms. "+ getINodeLockInfo(locksAcquirer.getLocks()));
        }
        //post TX phase
        //any error in this phase will not re-start the tx
        //TODO: XXX handle failures in post tx phase
        if (info != null && info instanceof TransactionInfo) {
          ((TransactionInfo) info).performPostTransactionAction();
        }
        return txRetValue;
      } catch (Throwable t) {
        String opName = !NDCWrapper.NDCEnabled() ? opType + " " : "";
        if (!(opName.equals("GET_BLOCK_LOCATIONS") && t instanceof LockUpgradeException)) {
          requestHandlerLOG.error(opName + "TX Failed. total tx time " + (System.currentTimeMillis() - txStartTime)
              + " msec. TotalRetryCount(" + RETRY_COUNT + ") RemainingRetries(" + (RETRY_COUNT - tryCount)
              + ") TX Stats: Setup: " + setupTime + "ms Acquire Locks: " + acquireLockTime
              + "ms, In Memory Processing: " + inMemoryProcessingTime + "ms, Commit Time: " + commitTime
              + "ms, Total Time: " + totalTime + "ms. ", t);
        }
        if (!(t instanceof TransientStorageException) ||  tryCount > RETRY_COUNT) {
          throw t;
        }
      } finally {
        removeNDC();
        if (!committed && locksAcquirer!=null) {
          try {
            requestHandlerLOG.error("Rollback the TX");
            EntityManager.rollback(locksAcquirer.getLocks());
          } catch (Exception e) {
            requestHandlerLOG.warn("Could not rollback transaction", e);
          }
        }
        //make sure that the context has been removed
        EntityManager.removeContext();
        // If the code is about to return but the exception was caught
        if (ignoredException != null) {
          throw ignoredException;
        }
      }
    }
    throw new RuntimeException("TransactionalRequestHandler did not execute");
  }

  private String getINodeLockInfo(TransactionLocks locks){
    String inodeLockMsg = "";
    try {
      if(locks != null) {
        Lock ilock = locks.getLock(Lock.Type.INode);
        if (ilock != null) {
          inodeLockMsg = ilock.toString();
        }
      }
    }catch (TransactionLocks.LockNotAddedException e){
    }
    return inodeLockMsg;
  }

  protected abstract void preTransactionSetup() throws IOException;
  
  public abstract void acquireLock(TransactionLocks locks) throws IOException;
  
  protected abstract TransactionLockAcquirer newLockAcquirer();

  @Override
  public TransactionalRequestHandler setParams(Object... params) {
    this.params = params;
    return this;
  }

  private void setNDC(Object info) {
    // Defines a context for every operation to track them in the logs easily.
    if (info != null && info instanceof TransactionInfo) {
      NDCWrapper.push(((TransactionInfo) info).getContextName(opType));
    } else {
      NDCWrapper.push(opType.toString());
    }
  }
  
  private void removeNDC() {
    NDCWrapper.clear();
    NDCWrapper.remove();
  }

  private void setRandomPartitioningKey()
      throws StorageException, StorageException {
    //      Random rand =new Random(System.currentTimeMillis());
    //      Integer partKey = new Integer(rand.nextInt());
    //      //set partitioning key
    //      Object[] pk = new Object[2];
    //      pk[0] = partKey;
    //      pk[1] = Integer.toString(partKey);
    //
    //      EntityManager.setPartitionKey(INodeDataAccess.class, pk);
    //
    ////      EntityManager.readCommited();
    ////      EntityManager.find(INode.Finder.ByPK_NameAndParentId, "", partKey);
    
  }

  protected abstract boolean shouldAbort(Exception e);
}
