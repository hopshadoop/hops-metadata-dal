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
public class ContainerStatus {

  private final String containerid;
  private final String state;
  private final String diagnostics;
  private final int exitstatus;
  private final String rMNodeId;

  public ContainerStatus(String containerid, String state, String diagnostics,
      int exitstatus, String rMNodeId) {
    this.containerid = containerid;
    this.state = state;
    this.diagnostics = diagnostics;
    this.exitstatus = exitstatus;
    this.rMNodeId = rMNodeId;
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
        '}';
  }

}
