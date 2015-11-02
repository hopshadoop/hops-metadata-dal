/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.entity.rmstatestore;

public class RanNode implements Comparable<RanNode>{
  private final String applicationAttemptId;
  private final String nodeId;

  public RanNode(String applicationAttemptId, String nodeId) {
    this.applicationAttemptId = applicationAttemptId;
    this.nodeId = nodeId;
  }

  public String getApplicationAttemptId() {
    return applicationAttemptId;
  }

  public String getNodeId() {
    return nodeId;
  }
  
  public int compareTo(RanNode node){
    if(this.applicationAttemptId.compareTo(node.getApplicationAttemptId())!=0){
      return this.applicationAttemptId.compareTo(node.getApplicationAttemptId());
}
    if(this.nodeId.compareTo(node.getNodeId())!=0){
      return this.nodeId.compareTo(node.getNodeId());
    }
    return 0;
  }

  @Override
  public int hashCode() {
    return applicationAttemptId.hashCode() + 100 * nodeId.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof RanNode)) {
      return false;
    }
    RanNode other = (RanNode) obj;
    return (applicationAttemptId.equals(other.applicationAttemptId) && nodeId.
            equals(other.nodeId));
  }
}
