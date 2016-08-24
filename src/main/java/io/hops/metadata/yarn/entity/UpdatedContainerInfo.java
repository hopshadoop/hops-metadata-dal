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

public class UpdatedContainerInfo implements Comparable<UpdatedContainerInfo> {

  private final String rmnodeid;
  private final String containerId;
  private final Integer updatedContainerInfoId;
  private final int pendingEventId;

  public UpdatedContainerInfo(String rmnodeid, String containerId,
          int updatedContainerInfoId, int pendingId) {
    this.rmnodeid = rmnodeid;
    this.containerId = containerId;
    this.updatedContainerInfoId = updatedContainerInfoId;
    this.pendingEventId = pendingId;
  }
  
  public UpdatedContainerInfo(String rmnodeid, String containerId,
          int updatedContainerInfoId) {
    this.rmnodeid = rmnodeid;
    this.containerId = containerId;
    this.updatedContainerInfoId = updatedContainerInfoId;
    this.pendingEventId = -1;
  }

  public int getPendingEventId() {
    return pendingEventId;
  }

  public String getRmnodeid() {
    return rmnodeid;
  }

  public String getContainerId() {
    return containerId;
  }

  public Integer getUpdatedContainerInfoId() {
    return updatedContainerInfoId;
  }

  @Override
  public String toString() {
    return "HopUpdatedContainerInfo{" + "rmnodeid=" + rmnodeid +
        ", containerId=" +
        containerId + ", updatedContainerInfoId=" + updatedContainerInfoId +
        '}';
  }

  @Override
  public int hashCode() {
    return updatedContainerInfoId.hashCode() + containerId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UpdatedContainerInfo)) {
      return false;
    }

    return updatedContainerInfoId
        .equals(((UpdatedContainerInfo) o).getUpdatedContainerInfoId()) && 
            containerId.equals(((UpdatedContainerInfo) o).getContainerId());
  }

  @Override
  public int compareTo(UpdatedContainerInfo other) {
    if (this.equals(other)) {
      return 0;
    }
    if(updatedContainerInfoId.compareTo(other.getUpdatedContainerInfoId())!=0){
      return updatedContainerInfoId.compareTo(other.getUpdatedContainerInfoId());
    }else{
      return containerId.compareTo(other.getContainerId());
    }

  }

}
