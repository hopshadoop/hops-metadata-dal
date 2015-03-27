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
package io.hops.metadata.yarn.entity;

public class AppSchedulingInfo {
  private final String schedulerappId;
  private final String appId;
  private final String queuename;
  private final String user;
  private final int containeridcounter;
  private final boolean pending;
  private final boolean stoped;

  public AppSchedulingInfo(String schedulerappId, String appId,
      String queuename, String user, int containeridcounter, boolean pending,
      boolean stoped) {
    this.schedulerappId = schedulerappId;
    this.appId = appId;
    this.queuename = queuename;
    this.user = user;
    this.containeridcounter = containeridcounter;
    this.pending = pending;
    this.stoped = stoped;
  }

  public AppSchedulingInfo(String schedulerappId) {
    this.schedulerappId = schedulerappId;
    this.appId = null;
    this.queuename = null;
    this.user = null;
    this.containeridcounter = 0;
    this.pending = false;
    this.stoped = true;
  }

  public String getSchedulerAppId() {
    return schedulerappId;
  }

  public String getAppId() {
    return appId;
  }

  public String getQueuename() {
    return queuename;
  }

  public String getUser() {
    return user;
  }

  public int getContaineridcounter() {
    return containeridcounter;
  }

  public boolean isPending() {
    return pending;
  }

  public boolean isStoped() {
    return stoped;
  }
}
