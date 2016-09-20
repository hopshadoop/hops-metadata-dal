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

public class PendingEvent implements Comparable<PendingEvent> {

  private PendingEventID id;
  private final Type type;
  private final Status status;
  private int contains;
  
  public enum Type {
    NODE_UPDATED, NODE_REMOVED, NODE_ADDED
  }
  
  public enum Status {
    SCHEDULER_FINISHED_PROCESSING, SCHEDULER_NOT_FINISHED_PROCESSING, NEW
  }
  
  public PendingEvent(String rmnodeId, Type type, Status status, int id, 
          int contains) {
    this.type = type;
    this.status = status;
    this.id = new PendingEventID(id, rmnodeId);
    this.contains = contains;
  }

  public PendingEvent(PendingEvent pendingEvent) {
    this.type = pendingEvent.getType();
    this.status = pendingEvent.getStatus();
    this.id = new PendingEventID(pendingEvent.getId().getEventId(),
            pendingEvent.getId().getNodeId());
    this.contains = pendingEvent.getContains();
  }
  
  /**
   * Returns the globally unique id of the pending event.
   * <p/>
   *
   * @return
   */
  public PendingEventID getId() {
    return id;
  }

  /**
   * Returns the event type, for example NODE_ADDED.
   * <p/>
   *
   * @return
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the node status, either NEW, PENDING, COMPLETED.
   * <p/>
   *
   * @return
   */
  public Status getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "HopPendingEvent{" + "rmnodeId=" + id.getNodeId() + ", type=" + type +
        ", status=" + status + ", id=" + id.getEventId() + '}';
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + this.id.hashCode();
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final PendingEvent other = (PendingEvent) obj;
    if (!this.id.equals(other.id)) {
      return false;
    }
    return true;
  }


  @Override
  public int compareTo(PendingEvent o) {
    return this.id.compareTo(o.getId());
  }

  public int getContains(){
    return contains;
  }

  public void setContains(int contains) {
    this.contains=contains;
  }
}
