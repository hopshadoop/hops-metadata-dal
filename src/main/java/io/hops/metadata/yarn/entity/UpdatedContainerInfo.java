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

public class UpdatedContainerInfo {

  private final String rmnodeid;
  private final String containerId;
  private final int updatedContainerInfoId;

  public UpdatedContainerInfo(String rmnodeid, String containerId,
      int updatedContainerInfoId) {
    this.rmnodeid = rmnodeid;
    this.containerId = containerId;
    this.updatedContainerInfoId = updatedContainerInfoId;
  }

  public String getRmnodeid() {
    return rmnodeid;
  }

  public String getContainerId() {
    return containerId;
  }

  public int getUpdatedContainerInfoId() {
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
    int hash = 3;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final UpdatedContainerInfo other = (UpdatedContainerInfo) obj;
    if ((this.rmnodeid == null) ? (other.rmnodeid != null) :
        !this.rmnodeid.equals(other.rmnodeid)) {
      return false;
    }
    if ((this.containerId == null) ? (other.containerId != null) :
        !this.containerId.equals(other.containerId)) {
      return false;
    }
    if (this.updatedContainerInfoId != other.updatedContainerInfoId) {
      return false;
    }
    return true;
  }
  
}
