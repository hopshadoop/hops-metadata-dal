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

public class AppSchedulable {

  private final String schedulerAppId;
  private final long starttime;
  private final String queuename;

  public AppSchedulable(String schedulerAppId, long starttime,
          String queuename) {
    this.schedulerAppId = schedulerAppId;
    this.starttime = starttime;
    this.queuename = queuename;
  }

  public String getSchedulerAppId() {
    return schedulerAppId;
  }

  public long getStarttime() {
    return starttime;
  }

  public String getQueuename() {
    return queuename;
  }
}
