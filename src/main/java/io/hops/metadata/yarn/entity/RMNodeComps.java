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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RMNodeComps {
  private static final Log LOG = LogFactory.getLog(RMNodeComps.class);

  private  PendingEvent pendingEvent;
  private  RMNode rmNode;
  private  Resource resource;
  //hopUpdatedContainerInfo are grouped by updatedContainerInfoId
  private List<UpdatedContainerInfo> updatedContainerInfo
          = new ArrayList<>();
  private List<ContainerStatus> containersStatus
          = new ArrayList<>();
  private Map<String, ContainerStatus> containerStatusMap
          = new HashMap<>();
  private int set = 0;
  
  public RMNodeComps(){  
  }
  
  public RMNodeComps(RMNode hopRMNode,
          Resource hopResource,
          PendingEvent hopPendingEvent,
          List<UpdatedContainerInfo> hopUpdatedContainerInfo,
          List<ContainerStatus> hopContainersStatus) {
    this.rmNode = hopRMNode;
    this.resource = hopResource;
    this.pendingEvent = hopPendingEvent;
    this.updatedContainerInfo = hopUpdatedContainerInfo;
    this.containersStatus = hopContainersStatus;
  }

 public PendingEvent getPendingEvent() {
    return pendingEvent;
  }

  public Resource getHopResource() {
    return resource;
  }

  public List<UpdatedContainerInfo> getHopUpdatedContainerInfo() {
    return updatedContainerInfo;
  }

  public Map< String, ContainerStatus> getHopContainersStatusMap() {
    if (containerStatusMap.size()< containersStatus.size()) {
      for (ContainerStatus status : containersStatus) {
        containerStatusMap.put(status.getContainerid(), status);
      }
    }
    return containerStatusMap;
  }
  
  public List< ContainerStatus> getHopContainersStatus() {
    return containersStatus;
  }

  public RMNode getHopRMNode() {
    return rmNode;
  }

  public String getRMNodeId(){
    return pendingEvent.getId().getNodeId();
  }

  public void setPendingEvent(PendingEvent hopPendingEvent) {
    this.pendingEvent = hopPendingEvent;
    set++;
  }

  public void setRMNode(RMNode hopRMNode) {
    this.rmNode = hopRMNode;
    set++;
  }

  public void setResource(Resource hopResource) {
    this.resource = hopResource;
    
    set++;
  }

  public void addUpdatedContainerInfo(
          UpdatedContainerInfo updatedContainerInfo) {
    this.updatedContainerInfo.add(updatedContainerInfo);
    set++;
  }

  public void addContainersStatus(ContainerStatus containersStatus) {
    this.containersStatus.add(containersStatus);
    set++;
  }

  public boolean isComplet(){
    if(pendingEvent==null || pendingEvent.getContains()!=set){
      return false;
    }
    return true;
  }
  
}
