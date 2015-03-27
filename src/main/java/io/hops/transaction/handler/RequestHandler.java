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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public abstract class RequestHandler {
  private long waitTime;

  public interface OperationType {
  }

  protected static Log log = LogFactory.getLog(RequestHandler.class);
  protected Object[] params = null;
  // TODO These should be in a config file
  public static final int RETRY_COUNT = 5;
  public static final long BASE_WAIT_TIME = 500;
  protected OperationType opType;
  protected static StorageConnector connector;

  public static void setStorageConnector(StorageConnector c) {
    connector = c;
  }

  public RequestHandler(OperationType opType) {
    this.opType = opType;
  }

  public Object handle() throws IOException {
    return handle(null);
  }

  public Object handle(Object info) throws IOException {
    waitTime = 0;
    return execute(info);
  }

  protected abstract Object execute(Object info) throws IOException;

  public abstract Object performTask() throws IOException;

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
        log.debug("TX is being retried. Waiting for " + waitTime +
            " ms before retry. TX name " + opType);
        Thread.sleep(waitTime);
      }
      waitTime = waitTime == 0 ? BASE_WAIT_TIME : waitTime * 2;
      return waitTime;
    } catch (InterruptedException ex) {
      log.warn(ex);
    }
    return 0;
  }
}
