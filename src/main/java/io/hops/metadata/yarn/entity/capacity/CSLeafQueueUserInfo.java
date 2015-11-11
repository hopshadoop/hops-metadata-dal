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
package io.hops.metadata.yarn.entity.capacity;

public class CSLeafQueueUserInfo {

  private final String userName;
  private final int consumedMemory;
  private final int consumedVCores;
  private final int pendingApplications;
  private final int activeApplications;

  public CSLeafQueueUserInfo(String userName, int consumedMemory,
          int consumedVCores, int pendingApplications, int activeApplications) {
    this.userName = userName;
    this.consumedMemory = consumedMemory;
    this.consumedVCores = consumedVCores;
    this.pendingApplications = pendingApplications;
    this.activeApplications = activeApplications;
  }

  public String getUserName() {
    return userName;
  }

  public int getConsumedMemory() {
    return consumedMemory;
  }

  public int getConsumedVCores() {
    return consumedVCores;
  }

  public int getPendingApplications() {
    return pendingApplications;
  }

  public int getActiveApplications() {
    return activeApplications;
  }

}
