/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.entity;

import java.util.ArrayList;
import java.util.List;

public class UpdatedContainerInfoToAdd implements Comparable<UpdatedContainerInfoToAdd>{
  UpdatedContainerInfo uci;
  ContainerStatus containerStatus;

  public UpdatedContainerInfoToAdd(UpdatedContainerInfo uci,
          ContainerStatus containerStatus) {
    this.uci = uci;
    this.containerStatus = containerStatus;
  }

  public UpdatedContainerInfo getUci() {
    return uci;
  }

  public ContainerStatus getContainerStatus() {
    return containerStatus;
  }
  
  @Override
  public int hashCode() {
    return uci.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UpdatedContainerInfoToAdd)) {
      return false;
    }

    return uci.equals(((UpdatedContainerInfoToAdd) o).getUci());
  }

  @Override
  public int compareTo(UpdatedContainerInfoToAdd other) {
    if (this.equals(other)) {
      return 0;
    }
    return uci.compareTo(other.getUci());
    
  }
}
