/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.entity;

import java.util.ArrayList;
import java.util.List;

public class FiCaSchedulerNodeInfos {

  FiCaSchedulerNode fiCaSchedulerNode;
  Resource totalResource;
  Resource availableResource;
  Resource usedResource;
  List<LaunchedContainers> launchedContainers
          = new ArrayList<LaunchedContainers>();

  public FiCaSchedulerNode getFiCaSchedulerNode() {
    return fiCaSchedulerNode;
  }

  public void setFiCaSchedulerNode(FiCaSchedulerNode fiCaSchedulerNode) {
    this.fiCaSchedulerNode = fiCaSchedulerNode;
  }

  public Resource getTotalResource() {
    return totalResource;
  }

  public void setTotalResource(Resource totalResource) {
    this.totalResource = totalResource;
  }

  public Resource getAvailableResource() {
    return availableResource;
  }

  public void setAvailableResource(Resource availableResource) {
    this.availableResource = availableResource;
  }

  public Resource getUsedResource() {
    return usedResource;
  }

  public void setUsedResource(Resource usedResource) {
    this.usedResource = usedResource;
  }
  
  public void addLaunchedContainer(LaunchedContainers container){
    launchedContainers.add(container);
  }

  public List<LaunchedContainers> getLaunchedContainers() {
    return launchedContainers;
  }
  
  
}
