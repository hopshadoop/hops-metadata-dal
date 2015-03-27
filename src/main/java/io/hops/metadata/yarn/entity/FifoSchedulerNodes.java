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
 * Pojo class for nodes ConcurrentMap in FifoScheduler.
 */
public class FifoSchedulerNodes {

  private final String nodeidID;
  private final String ficaSchedulerNodeID;

  public FifoSchedulerNodes(String nodeidID, String ficaSchedulerNodeID) {
    this.nodeidID = nodeidID;
    this.ficaSchedulerNodeID = ficaSchedulerNodeID;
  }

  public String getNodeidID() {
    return nodeidID;
  }

  public String getFicaSchedulerNodeID() {
    return ficaSchedulerNodeID;
  }

  @Override
  public String toString() {
    return "HopFifoSchedulerNodes{" + "nodeidID=" + nodeidID +
        ", ficaSchedulerNodeID=" + ficaSchedulerNodeID + '}';
  }
}
