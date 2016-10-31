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
 * HOP representation of ContainerStatus yarn object.
 */
public class ContainerStatus implements Comparable<ContainerStatus> {

  private final String containerid;
  private final String state;
  private final String diagnostics;
  private final int exitstatus;
  private final String rMNodeId;
  private final Integer uciId;
  private final int pendingEventId;
  
  public ContainerStatus(String containerid, String state, String diagnostics,
          int exitstatus, String rMNodeId) {
    this(containerid, state, diagnostics, exitstatus, rMNodeId, -1, -1);
  }
  
  public ContainerStatus(String containerid, String state, String diagnostics,
          int exitstatus, String rMNodeId, int pendingId, int uciId) {
    this.containerid = containerid;
    this.state = state;
    this.diagnostics = diagnostics.substring(0, Math.min(500, diagnostics.
            length()));
    this.exitstatus = exitstatus;
    this.rMNodeId = rMNodeId;
    this.pendingEventId = pendingId;
    this.uciId = uciId;
  }

  public ContainerStatus(String containerid, String rMNodeId, int uciId) {
    this.containerid = containerid;
    this.state = "";
    this.diagnostics = "";
    this.exitstatus = 0;
    this.rMNodeId = rMNodeId;
    this.pendingEventId = -1;
    this.uciId = uciId;
  }

  public int getUciId() {
    return uciId;
  }

  public int getPendingEventId() {
    return pendingEventId;
  }

  public String getContainerid() {
    return containerid;
  }

  public String getState() {
    return state;
  }

  public String getDiagnostics() {
    return diagnostics;
  }

  public int getExitstatus() {
    return exitstatus;
  }

  public String getRMNodeId() {
    return rMNodeId;
  }


  
  @Override
  public String toString() {
    return "HopContainerStatus{" + "containerid=" + containerid + ", state=" +
        state + ", diagnostics=" + diagnostics + ", exitstatus=" + exitstatus +
        "uciId= " + uciId + '}';
  }

  @Override
  public int hashCode() {
    return containerid.hashCode() + 100 * uciId.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ContainerStatus)) {
      return false;
    }

    return containerid
            .equals(((ContainerStatus) o).getContainerid());
  }

  @Override
  public int compareTo(ContainerStatus other) {
    if (this.equals(other)) {
      return 0;
    }
    if(containerid.compareTo(other.getContainerid())!=0){
        return containerid.compareTo(other.getContainerid());
    }else{
        return uciId.compareTo(other.getUciId());
    }
  }

}
