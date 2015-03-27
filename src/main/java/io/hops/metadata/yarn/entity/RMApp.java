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

public class RMApp {
  private final int id;
  private final int applicationidid;
  private final int rmcontextid;
  private final String user;
  private final String name;
  private final int appsubmissionctxid;
  private final int schedulerid;
  private final int appmasterserviceid;
  private final String diagnostics;
  private final int maxappattempts;
  private final long submittime;
  private final String applicationtype;
  private final long starttime;
  private final long finishtime;
  private final int currentattemptid;
  private final boolean isappremovalrequestsent;

  public RMApp(int id, int applicationidid, int rmcontextid, String user,
      String name, int appsubmissionctxid, int schedulerid,
      int appmasterserviceid, String diagnostics, int maxappattempts,
      long submittime, String applicationtype, long starttime, long finishtime,
      int currentattemptid, boolean isappremovalrequestsent) {
    this.id = id;
    this.applicationidid = applicationidid;
    this.rmcontextid = rmcontextid;
    this.user = user;
    this.name = name;
    this.appsubmissionctxid = appsubmissionctxid;
    this.schedulerid = schedulerid;
    this.appmasterserviceid = appmasterserviceid;
    this.diagnostics = diagnostics;
    this.maxappattempts = maxappattempts;
    this.submittime = submittime;
    this.applicationtype = applicationtype;
    this.starttime = starttime;
    this.finishtime = finishtime;
    this.currentattemptid = currentattemptid;
    this.isappremovalrequestsent = isappremovalrequestsent;
  }

  public int getId() {
    return id;
  }

  public int getApplicationidid() {
    return applicationidid;
  }

  public int getRmcontextid() {
    return rmcontextid;
  }

  public String getUser() {
    return user;
  }

  public String getName() {
    return name;
  }

  public int getAppsubmissionctxid() {
    return appsubmissionctxid;
  }

  public int getSchedulerid() {
    return schedulerid;
  }

  public int getAppmasterserviceid() {
    return appmasterserviceid;
  }

  public String getDiagnostics() {
    return diagnostics;
  }

  public int getMaxappattempts() {
    return maxappattempts;
  }

  public long getSubmittime() {
    return submittime;
  }

  public String getApplicationtype() {
    return applicationtype;
  }

  public long getStarttime() {
    return starttime;
  }

  public long getFinishtime() {
    return finishtime;
  }

  public int getCurrentattemptid() {
    return currentattemptid;
  }

  public boolean isIsappremovalrequestsent() {
    return isappremovalrequestsent;
  }


}
