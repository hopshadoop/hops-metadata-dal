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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMNodeComps {

  private final PendingEvent hopPendingEvent;
  private final RMNode hopRMNode;
  private final NextHeartbeat hopNextHeartbeat;
  private final Node hopNode;
  private final NodeHBResponse hopNodeHBResponse;
  private final Resource hopResource;
  //hopUpdatedContainerInfo are grouped by updatedContainerInfoId
  private final List<UpdatedContainerInfo> hopUpdatedContainerInfo;
  private final List<ContainerId> hopContainerIdsToClean;
  private final List<FinishedApplications> hopFinishedApplications;
  private final List<ContainerStatus> hopContainersStatus;
  private Map<String, ContainerStatus> hopContainerStatusMap;
  private final String rmNodeId;

  public RMNodeComps(RMNode hopRMNode, NextHeartbeat hopNextHeartbeat,
          Node hopNode,
          NodeHBResponse hopNodeHBResponse, Resource hopResource,
          PendingEvent hopPendingEvent,
          List<UpdatedContainerInfo> hopUpdatedContainerInfo,
          List<ContainerId> hopContainerIdsToClean,
          List<FinishedApplications> hopFinishedApplications,
          List<ContainerStatus> hopContainersStatus, String rmNodeId) {
    this.hopRMNode = hopRMNode;
    this.hopNextHeartbeat = hopNextHeartbeat;
    this.hopNode = hopNode;
    this.hopNodeHBResponse = hopNodeHBResponse;
    this.hopResource = hopResource;
    this.hopPendingEvent = hopPendingEvent;
    this.hopUpdatedContainerInfo = hopUpdatedContainerInfo;
    this.hopContainerIdsToClean = hopContainerIdsToClean;
    this.hopFinishedApplications = hopFinishedApplications;
    this.hopContainersStatus = hopContainersStatus;
    this.rmNodeId = rmNodeId;
  }

//  public RMNodeComps(RMNode hopRMNode, NextHeartbeat hopNextHeartbeat,
//          Node hopNode,
//          NodeHBResponse hopNodeHBResponse, Resource hopResource,
//          List<JustLaunchedContainers> hopJustLaunchedContainers,
//          List<UpdatedContainerInfo> hopUpdatedContainerInfo,
//          List<ContainerId> hopContainerIdsToClean,
//          List<FinishedApplications> hopFinishedApplications,
//          List<ContainerStatus> hopContainersStatus) {
//    this(hopRMNode, hopNextHeartbeat, hopNode, hopNodeHBResponse, hopResource,
//            null, hopJustLaunchedContainers, hopUpdatedContainerInfo,
//            hopContainerIdsToClean, hopFinishedApplications, hopContainersStatus);
//  }

  public PendingEvent getPendingEvent() {
    return hopPendingEvent;
  }

  public Resource getHopResource() {
    return hopResource;
  }

  public List<UpdatedContainerInfo> getHopUpdatedContainerInfo() {
    return hopUpdatedContainerInfo;
  }

  public List<ContainerId> getHopContainerIdsToClean() {
    return hopContainerIdsToClean;
  }

  public List<FinishedApplications> getHopFinishedApplications() {
    return hopFinishedApplications;
  }

  public List< ContainerStatus> getHopContainersStatus() {
    return hopContainersStatus;
  }

  public Map< String, ContainerStatus> getHopContainersStatusMap() {
    if (hopContainerStatusMap == null) {
      hopContainerStatusMap = new HashMap<String, ContainerStatus>(
              hopContainersStatus.size());
    }
    for (ContainerStatus status : hopContainersStatus) {
      hopContainerStatusMap.put(status.getContainerid(), status);
    }
    return hopContainerStatusMap;
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

  public String getRMNodeId(){
    return rmNodeId;
  }
}
