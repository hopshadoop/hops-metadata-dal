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

/**
 * Pojo for RMNode.finishedApplications list.
 */
public class RMNodeApplication implements Comparable<RMNodeApplication>{

  public enum RMNodeApplicationStatus{
    FINISHED, RUNNING;
  }
  
  private final String rmnodeid;
  private final String applicationId;
  private final RMNodeApplicationStatus status;
  
  public RMNodeApplication(String rmnodeid, String applicationId, RMNodeApplicationStatus status) {
    this.rmnodeid = rmnodeid;
    this.applicationId = applicationId;
    this.status = status;
  }

  public String getRMNodeID() {
    return rmnodeid;
  }

  public String getApplicationId() {
    return applicationId;
  }

  public RMNodeApplicationStatus getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "HopFinishedApplications{" + "rmnodeid=" + rmnodeid +
        ", applicationId=" + applicationId + ", status=" + status +'}';
  }

  public int compareTo(RMNodeApplication f) {
    if (this.rmnodeid.compareTo(f.rmnodeid) != 0) {
      return this.rmnodeid.compareTo(f.rmnodeid);
    } else if (this.applicationId.compareTo(f.applicationId) != 0) {
      return this.applicationId.compareTo(f.applicationId);
    } else {
      return this.status.compareTo(f.status);
    }
  }

  @Override
  public int hashCode() {
    return rmnodeid.hashCode() + 100 * applicationId.hashCode() + status.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof RMNodeApplication)) {
      return false;
    }
    RMNodeApplication other = (RMNodeApplication) obj;
    return (applicationId.equals(other.applicationId) && rmnodeid.equals(
            other.rmnodeid) && status.equals(other.status));
  }
}
