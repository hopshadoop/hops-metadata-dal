/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.entity;

public class PendingEventID implements Comparable<PendingEventID> {

  private final Integer eventId;
  private final String nodeId;

  public PendingEventID(Integer eventId, String nodeId) {
    this.eventId = eventId;
    this.nodeId = nodeId;
  }

  public Integer getEventId() {
    return eventId;
  }

  public String getNodeId() {
    return nodeId;
  }

  @Override
  public int compareTo(PendingEventID other) {
    int first = eventId.compareTo(other.eventId);
    if (first == 0) {
      return nodeId.compareTo(other.nodeId);
    }
    return first;
  }

  @Override
  public boolean equals(Object o) {
    if (o != null && getClass() == o.getClass()) {
      PendingEventID other = (PendingEventID) o;
      if (eventId.equals(other.eventId) && nodeId.equals(other.nodeId)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    return nodeId.hashCode() + eventId;
  }
  
  @Override
  public String toString(){
    return nodeId + " " + eventId;
  }
}
