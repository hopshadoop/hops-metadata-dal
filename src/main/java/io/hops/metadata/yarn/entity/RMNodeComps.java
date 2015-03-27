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

import java.util.List;
import java.util.Map;

public class RMNodeComps {

  private final RMNode hopRMNode;
  private final NextHeartbeat hopNextHeartbeat;
  private final Node hopNode;
  private final NodeHBResponse hopNodeHBResponse;
  private final Resource hopResource;
  private final List<JustLaunchedContainers> hopJustLaunchedContainers;
  //hopUpdatedContainerInfo are grouped by updatedContainerInfoId
  private final Map<Integer, List<UpdatedContainerInfo>>
      hopUpdatedContainerInfo;
  private final List<ContainerId> hopContainerIdsToClean;
  private final List<FinishedApplications> hopFinishedApplications;
  private final Map<String, ContainerStatus> hopContainersStatus;

  public RMNodeComps(RMNode hopRMNode, NextHeartbeat hopNextHeartbeat,
      Node hopNode, NodeHBResponse hopNodeHBResponse, Resource hopResource,
      List<JustLaunchedContainers> hopJustLaunchedContainers,
      Map<Integer, List<UpdatedContainerInfo>> hopUpdatedContainerInfo,
      List<ContainerId> hopContainerIdsToClean,
      List<FinishedApplications> hopFinishedApplications,
      Map<String, ContainerStatus> hopContainersStatus) {
    this.hopRMNode = hopRMNode;
    this.hopNextHeartbeat = hopNextHeartbeat;
    this.hopNode = hopNode;
    this.hopNodeHBResponse = hopNodeHBResponse;
    this.hopResource = hopResource;
    this.hopJustLaunchedContainers = hopJustLaunchedContainers;
    this.hopUpdatedContainerInfo = hopUpdatedContainerInfo;
    this.hopContainerIdsToClean = hopContainerIdsToClean;
    this.hopFinishedApplications = hopFinishedApplications;
    this.hopContainersStatus = hopContainersStatus;
  }

  public Resource getHopResource() {
    return hopResource;
  }

  public List<JustLaunchedContainers> getHopJustLaunchedContainers() {
    return hopJustLaunchedContainers;
  }

  public Map<Integer, List<UpdatedContainerInfo>> getHopUpdatedContainerInfo() {
    return hopUpdatedContainerInfo;
  }

  public List<ContainerId> getHopContainerIdsToClean() {
    return hopContainerIdsToClean;
  }

  public List<FinishedApplications> getHopFinishedApplications() {
    return hopFinishedApplications;
  }

  public Map<String, ContainerStatus> getHopContainersStatus() {
    return hopContainersStatus;
  }

  public RMNode getHopRMNode() {
    return hopRMNode;
  }

  public NextHeartbeat getHopNextHeartbeat() {
    return hopNextHeartbeat;
  }

  public Node getHopNode() {
    return hopNode;
  }

  public NodeHBResponse getHopNodeHBResponse() {
    return hopNodeHBResponse;
  }

}
