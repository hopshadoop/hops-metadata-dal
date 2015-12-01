/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.entity;

import io.hops.metadata.yarn.entity.capacity.FiCaSchedulerAppReservedContainers;

public class FiCaSchedulerAppReservedContainerInfo {
FiCaSchedulerAppReservedContainers fiCaContainer;
RMContainer hopRMContainer;
Container hopContainer;

  public FiCaSchedulerAppReservedContainerInfo(
          FiCaSchedulerAppReservedContainers fiCaContainer,
          RMContainer hopRMContainer, Container hopContainer) {
    this.fiCaContainer = fiCaContainer;
    this.hopRMContainer = hopRMContainer;
    this.hopContainer = hopContainer;
  }

  public FiCaSchedulerAppReservedContainers getFiCaContainer() {
    return fiCaContainer;
  }

  public RMContainer getHopRMContainer() {
    return hopRMContainer;
  }

  public Container getHopContainer() {
    return hopContainer;
  }


}
