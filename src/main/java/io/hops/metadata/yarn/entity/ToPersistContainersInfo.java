/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.entity;

public class ToPersistContainersInfo {
RMContainer rMContainer;
FiCaSchedulerAppContainer fiCaSchedulerAppContainer;
Container container;

  public ToPersistContainersInfo(RMContainer rMContainer,
          FiCaSchedulerAppContainer fiCaSchedulerAppNewlyAllocatedContainer,
          Container container) {
    this.rMContainer = rMContainer;
    this.fiCaSchedulerAppContainer
            = fiCaSchedulerAppNewlyAllocatedContainer;
    this.container = container;
  }

  public RMContainer getrMContainer() {
    return rMContainer;
  }

  public FiCaSchedulerAppContainer getFiCaSchedulerAppContainer() {
    return fiCaSchedulerAppContainer;
  }

  public Container getContainer() {
    return container;
  }


}
