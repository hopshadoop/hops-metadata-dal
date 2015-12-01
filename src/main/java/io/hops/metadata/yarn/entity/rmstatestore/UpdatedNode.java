/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.entity.rmstatestore;

public class UpdatedNode {
  private String applicationId;
  private String nodeId;

  public UpdatedNode(String applicationId, String nodeId) {
    this.applicationId = applicationId;
    this.nodeId = nodeId;
  }

  
  public String getApplicationId() {
    return applicationId;
  }

  public String getNodeId() {
    return nodeId;
  }
  
  
}
