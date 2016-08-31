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

import io.hops.exception.TransientStorageException;
import io.hops.log.NDCWrapper;

import java.io.IOException;

public abstract class LightWeightRequestHandler extends RequestHandler {

  public LightWeightRequestHandler(OperationType opType) {
    super(opType);
  }

  @Override
  protected Object execute(Object info) throws IOException {
    int tryCount = 0;
    long totalTime = 0;

    while (tryCount <= RETRY_COUNT) {
      boolean rollback = false;
      exponentialBackoff();
      tryCount++;
      try {
        NDCWrapper.push(opType
            .toString()); // Defines a context for every operation to track them in the logs easily.

        //In a tx if the lock level is set to write, does
        //it mean that all the operations after seting the lock will use write lcok?
        //Light weight tx handler is sometimes called inside a bigger tx.
        //If in the outer tx lock level was set to some thing other than read-commited
        //then we will end up taking un necessary locks.
        //To make sure that we done have this problem I explicitly set the locks to read-commited.
        connector.readCommitted();
        totalTime = System.currentTimeMillis();
        Object ret = performTask();
        totalTime = System.currentTimeMillis() - totalTime;
        log.debug("Total time taken. Time " + totalTime + " ms");
        return ret;
      } catch (TransientStorageException e) {
        rollback = true;
        if (tryCount <= RETRY_COUNT) {
          totalTime = System.currentTimeMillis() - totalTime;
          log.error(
              "Tx Failed. total tx time " + " TotalRetryCount(" + RETRY_COUNT +
                  ") RemainingRetries(" + (RETRY_COUNT - tryCount) +
                  ") TX Stats: ms, Total Time: " + totalTime + "ms", e);
        } else {
          log.error("Transaction failed after " + RETRY_COUNT + " retries.", e);
          throw e;
        }
      } catch (IOException e) {
        rollback = true;
        log.error("Transaction failed.", e);
        throw e;
      } catch (RuntimeException e) {
        rollback = true;
        log.error("Transaction failed.", e);
        throw e;
      } catch (Error e) {
        rollback = true;
        log.error("Transaction failed.", e);
        throw e;
      } finally {
        if (rollback && connector.isTransactionActive()) {
          log.error("Transaction rollback. retries:" + RETRY_COUNT);
          connector.rollback();
        }
        NDCWrapper.pop();
        NDCWrapper.remove();
        if (rollback) {
          try {
            log.error("Rollback the TX");
            connector.rollback();
          } catch (Exception e) {
            log.error("Could not rollback transaction", e);
          }
        }
      }
    }

    throw new RuntimeException("LightWeightRequestHandler did not execute");
  }
}
