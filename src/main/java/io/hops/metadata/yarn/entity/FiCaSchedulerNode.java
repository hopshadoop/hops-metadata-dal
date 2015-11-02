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
 * Pojo class representing FicaSchedulerNode
 */
public class FiCaSchedulerNode {

  private String rmnodeId;
  private String nodeName;
  private int numOfContainers;
  private String reservedContainerId;
    
  public FiCaSchedulerNode(String rmnodeId){
    this(rmnodeId, null, 0, null);
  }
  
  public FiCaSchedulerNode(String rmnodeId, String nodeName,
      int numOfContainers, String reservedContainerId) {
    this.rmnodeId = rmnodeId;
    this.nodeName = nodeName;
    this.numOfContainers = numOfContainers;
    this.reservedContainerId = reservedContainerId;
  }

  public String getRmnodeId() {
    return rmnodeId;
  }

  public String getNodeName() {
    return nodeName;
  }

  public int getNumOfContainers() {
    return numOfContainers;
  }
    
  public String getReservedContainerId() {
    return reservedContainerId;
  }
}
