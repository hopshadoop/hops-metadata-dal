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

import io.hops.StorageConnector;
import io.hops.exception.StorageException;
import io.hops.exception.TransactionContextException;
import io.hops.exception.TransientStorageException;
import io.hops.exception.TupleAlreadyExistedException;
import io.hops.log.NDCWrapper;
import io.hops.metadata.hdfs.entity.MetadataLogEntry;
import io.hops.transaction.EntityManager;
import io.hops.transaction.TransactionInfo;
import io.hops.transaction.context.TransactionsStats;
import io.hops.transaction.lock.TransactionLockAcquirer;
import io.hops.transaction.lock.TransactionLocks;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public abstract class TransactionalRequestHandler extends RequestHandler {

  private Collection<MetadataLogEntry> previousLogEntries =
      Collections.emptyList();

  public TransactionalRequestHandler(OperationType opType) {
    super(opType);
  }

  @Override
  protected Object execute(StorageConnector connector, Object info) throws IOException {
    boolean rollback;
    boolean committed;
    int tryCount = 0;
    IOException ignoredException;
    TransactionLocks locks = null;
    Object txRetValue = null;

    while (tryCount <= RETRY_COUNT) {
      EntityManager.initTransaction(connector);
      long expWaitTime = exponentialBackoff();
      long txStartTime = System.currentTimeMillis();
      long oldTime = System.currentTimeMillis();

      long setupTime = -1;
      long beginTxTime = -1;
      long acquireLockTime = -1;
      long inMemoryProcessingTime = -1;
      long commitTime = -1;
      long totalTime = -1;

      rollback = false;
      tryCount++;
      ignoredException = null;
      committed = false;

      EntityManager.preventStorageCall(false);
      try {
        setNDC(info);
        if(LOG.isDebugEnabled()) {
          LOG.debug("Pretransaction phase started");
        }
        preTransactionSetup(connector);
        //sometimes in setup we call light weight request handler that messes up with the NDC
        removeNDC();
        setNDC(info);
        setupTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        if(LOG.isDebugEnabled()) {
          LOG.debug("Pretransaction phase finished. Time " + setupTime + " ms");
        }
        EntityManager.begin();
        if(LOG.isDebugEnabled()) {
          LOG.debug("TX Started");
        }
        beginTxTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        
        TransactionLockAcquirer locksAcquirer = newLockAcquirer();
        acquireLock(locksAcquirer.getLocks());

        locksAcquirer.acquire();

        if(LOG.isDebugEnabled()) {
          LOG.debug("Update timestamp phase started");
        }
        updatedTimestamp();
        
        acquireLockTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        if(LOG.isDebugEnabled()){
          LOG.debug("All Locks Acquired. Time " + acquireLockTime + " ms");
        }
        //sometimes in setup we call light weight request handler that messes up with the NDC
        removeNDC();
        setNDC(info);
        EntityManager.preventStorageCall(true);
        try {
          txRetValue = performTask(connector);
        } catch (IOException e) {
          if (shouldAbort(e)) {
            throw e;
          } else {
            ignoredException = e;
          }
        }
        inMemoryProcessingTime = (System.currentTimeMillis() - oldTime);
        oldTime = System.currentTimeMillis();
        if(LOG.isDebugEnabled()) {
          LOG.debug("In Memory Processing Finished. Time " + inMemoryProcessingTime + " ms");
        }

        TransactionsStats.TransactionStat stat = TransactionsStats.getInstance()
            .collectStats(opType, ignoredException);

        EntityManager.commit(locksAcquirer.getLocks());
        committed = true;
        commitTime = (System.currentTimeMillis() - oldTime);
        if(stat != null){
          stat.setTimes(acquireLockTime, inMemoryProcessingTime, commitTime);
        }

        if(LOG.isDebugEnabled()) {
          LOG.debug("TX committed. Time " + commitTime + " ms");
        }
        totalTime = (System.currentTimeMillis() - txStartTime);
        if(LOG.isInfoEnabled()) {
          LOG.info(opType+" TX Finished. TX Stats: Try Count: " + tryCount +
                  " Wait Before Next Retry:" +
                  expWaitTime + " Stepup: " + setupTime + " ms, Begin Tx:" +
                  beginTxTime + " ms, Acquire Locks: " + acquireLockTime +
                  "ms, In Memory Processing: " + inMemoryProcessingTime +
                  "ms, Commit Time: " + commitTime + "ms, Total Time: " + totalTime +
                  "ms");
        }
        //post TX phase
        //any error in this phase will not re-start the tx
        //TODO: XXX handle failures in post tx phase
        if (info != null && info instanceof TransactionInfo) {
          ((TransactionInfo) info).performPostTransactionAction();
        }
        return txRetValue;
      } catch (TransientStorageException e) {
        rollback = true;
        if (tryCount <= RETRY_COUNT) {
          LOG.error(opType+" TX Failed. total tx time " +
              (System.currentTimeMillis() - txStartTime) +
              " msec. TotalRetryCount(" + RETRY_COUNT +
              ") RemainingRetries(" + (RETRY_COUNT - tryCount) +
              ") TX Stats: Setup: " + setupTime + "ms Acquire Locks: " +
              acquireLockTime +
              "ms, In Memory Processing: " + inMemoryProcessingTime +
              "ms, Commit Time: " + commitTime +
              "ms, Total Time: " + totalTime + "ms", e);
        } else {
          if(LOG.isDebugEnabled()) {
            LOG.debug("Transaction failed after " + RETRY_COUNT + " retries.", e);
          }
          throw e;
        }
      } catch (TupleAlreadyExistedException e) {
        rollback = true;
        if (tryCount <= RETRY_COUNT) {
          previousLogEntries = EntityManager.findList(MetadataLogEntry.Finder.ALL_CACHED);
          if (previousLogEntries.isEmpty()) {
            LOG.error("Transaction failed", e);
            throw e;
          } else {
            LOG.error("Tx Failed. total tx time " +
                (System.currentTimeMillis() - txStartTime) +
                " msec. TotalRetryCount(" + RETRY_COUNT +
                ") RemainingRetries(" + (RETRY_COUNT - tryCount) +
                ") TX Stats: Setup: " + setupTime + "ms Acquire Locks: " +
                acquireLockTime +
                "ms, In Memory Processing: " + inMemoryProcessingTime +
                "ms, Commit Time: " + commitTime +
                "ms, Total Time: " + totalTime + "ms", e);
            resetWaitTime(); // Not an overloading error
          }
        } else {
          if(LOG.isDebugEnabled()) {
            LOG.debug("Transaction failed after " + RETRY_COUNT + " retries.", e);
          }
          throw e;
        }
      } catch (IOException e) {
        rollback = true;
        if (committed) {
          LOG.error("Exception in Post Tx Stage.", e);
        } else {
          LOG.error("Transaction failed", e);
        }
        throw e;
      } catch (RuntimeException e) {
        rollback = true;
        LOG.error("Transaction handler received a runtime exception", e);
        throw e;
      } catch (Error e) {
        rollback = true;
        LOG.error("Transaction handler received an error", e);
        throw e;
      } finally {
        removeNDC();
        if (rollback) {
          try {
            LOG.error("Rollback the TX");
            EntityManager.rollback(locks);
          } catch (Exception e) {
            LOG.warn("Could not rollback transaction", e);
          }
        }
        // If the code is about to return but the exception was caught
        if (ignoredException != null) {
          throw ignoredException;
        }
      }
    }
    throw new RuntimeException("TransactionalRequestHandler did not execute");
  }

  private void updatedTimestamp()
      throws TransactionContextException, StorageException {
    if (!previousLogEntries.isEmpty()) {
      EntityManager.findList(MetadataLogEntry.Finder.FETCH_EXISTING, previousLogEntries);
    }
  }

  protected abstract void preTransactionSetup(StorageConnector connector) throws IOException;
  
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

  protected abstract boolean shouldAbort(Exception e);
}
