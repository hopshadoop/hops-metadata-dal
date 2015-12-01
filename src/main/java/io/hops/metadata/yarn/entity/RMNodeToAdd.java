/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.entity;

import java.util.ArrayList;

public class RMNodeToAdd {

  Resource resources;
  Node nodesToAdd;
  RMNode rmNode;
  RMContextActiveNodes hopCtxNode;
  
  public void setRMNode(RMNode rmNode) {
    this.rmNode = rmNode;
  }

  public void setResources(Resource resources) {
    this.resources = resources;
  }

  public void setNodeToAdd(Node node) {
    this.nodesToAdd = node;
  }

  public void setHopCtxNode(RMContextActiveNodes hopCtxNode) {
    this.hopCtxNode = hopCtxNode;
  }

  public Resource getResources() {
    return resources;
  }

  public Node getNodesToAdd() {
    return nodesToAdd;
  }

  public RMNode getRmNode() {
    return rmNode;
  }

  public RMContextActiveNodes getHopCtxNode() {
    return hopCtxNode;
  }
  
}
