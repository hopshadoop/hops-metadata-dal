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
package io.hops.metadata.yarn.entity.fair;

public class RunnableApps {

  private final String queuename;
  private final String schedulerapp_id;
  private final boolean isrunnable;

  public RunnableApps(String queuename, String schedulerapp_id,
          boolean isrunnable) {
    this.queuename = queuename;
    this.schedulerapp_id = schedulerapp_id;
    this.isrunnable = isrunnable;
  }

  public String getQueuename() {
    return queuename;
  }

  public String getSchedulerapp_id() {
    return schedulerapp_id;
  }

  public boolean isIsrunnable() {
    return isrunnable;
  }
}
