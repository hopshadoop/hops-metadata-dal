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

import io.hops.MultiZoneStorageConnector;
import io.hops.StorageConnector;
import io.hops.transaction.TransactionCluster;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Random;

import java.io.IOException;

public abstract class RequestHandler {
  private long waitTime;

  public interface OperationType {
    TransactionCluster getCluster();
  }

  protected static Log LOG = LogFactory.getLog(RequestHandler.class);
  protected Object[] params = null;
  // TODO These should be in a config file
  public static final int RETRY_COUNT = 5;
  public static final int BASE_WAIT_TIME = 2000;
  protected OperationType opType;
  protected static Random rand = new Random(System.currentTimeMillis());

  protected static MultiZoneStorageConnector zoneConnector;

  public static void setStorageConnector(MultiZoneStorageConnector c) {
    zoneConnector = c;
  }

  public RequestHandler(OperationType opType) {
    this.opType = opType;
  }

  public Object handle() throws IOException {
    return handle(null);
  }

  public Object handle(Object info) throws IOException {
    TransactionCluster cluster = this.opType.getCluster();
    waitTime = 0;
    return execute(cluster, info);
  }

  protected abstract Object execute(TransactionCluster cluster, Object info) throws IOException;

  public abstract Object performTask(StorageConnector connector) throws IOException;

  public RequestHandler setParams(Object... params) {
    this.params = params;
    return this;
  }

  public Object[] getParams() {
    return this.params;
  }

  protected long exponentialBackoff() {
    try {
      if (waitTime > 0) {
        if(LOG.isDebugEnabled()) {
          LOG.debug("TX is being retried. Waiting for " + waitTime +
                  " ms before retry. TX name " + opType);
        }
        Thread.sleep(waitTime);
      }
      if (waitTime == 0) {
        waitTime = rand.nextInt(BASE_WAIT_TIME);
      } else {
        waitTime = waitTime * 2;
      }
      return waitTime;
    } catch (InterruptedException ex) {
      LOG.warn(ex);
    }
    return 0;
  }

  protected void resetWaitTime() {
    waitTime = 0;
  }
}
