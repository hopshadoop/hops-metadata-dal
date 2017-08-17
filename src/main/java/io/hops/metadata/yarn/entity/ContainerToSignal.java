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
 * Pojo class for the RMNode.containersToSignal set.
 */
public class ContainerToSignal {

  private final String rmnodeid;
  private final String containerId;
  private final String command;

  public ContainerToSignal(String rmnodeid, String containerId, String command) {
    this.rmnodeid = rmnodeid;
    this.containerId = containerId;
    this.command = command;
  }

  public String getRmnodeid() {
    return rmnodeid;
  }

  public String getContainerId() {
    return containerId;
  }

  public String getCommand() {
    return command;
  }
  

  @Override
  public String toString() {
    return "HopContainerId{" + "rmnodeid=" + rmnodeid + ", containerId=" +
        containerId + ", command=" + command + '}';
  }

}
