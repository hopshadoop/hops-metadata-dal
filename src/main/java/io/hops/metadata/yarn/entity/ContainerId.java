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
 * Pojo class for the RMNode.containersToClean set. Hostname, commandport point
 * to the RMNode primary key.
 */
public class ContainerId {

  private final String rmnodeid;
  private final String containerId;

  public ContainerId(String rmnodeid, String containerId) {
    this.rmnodeid = rmnodeid;
    this.containerId = containerId;
  }

  public String getRmnodeid() {
    return rmnodeid;
  }

  public String getContainerId() {
    return containerId;
  }

  @Override
  public String toString() {
    return "HopContainerId{" + "rmnodeid=" + rmnodeid + ", containerId=" +
        containerId + '}';
  }

}
