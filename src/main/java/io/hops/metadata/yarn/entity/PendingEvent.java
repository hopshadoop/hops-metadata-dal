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

  private final String rmnodeId;
  private final int type;
  private final int status;
  //Used to order the events when retrieved by scheduler
  private final int id;

  public PendingEvent(String rmnodeId, int type, int status, int id) {
    this.rmnodeId = rmnodeId;
    this.type = type;
    this.status = status;
    this.id = id;
  }

  /**
   * Returns the globally unique id of the pending event.
   * <p/>
   *
   * @return
   */
  public int getId() {
    return id;
  }

  /**
   * Returns the RMNode id for which the event will be triggered.
   * <p/>
   *
   * @return
   */
  public String getRmnodeId() {
    return rmnodeId;
  }

  /**
   * Returns the event type, for example NODE_ADDED.
   * <p/>
   *
   * @return
   */
  public int getType() {
    return type;
  }

  /**
   * Returns the node status, either NEW, PENDING, COMPLETED.
   * <p/>
   *
   * @return
   */
  public int getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "HopPendingEvent{" + "rmnodeId=" + rmnodeId + ", type=" + type +
        ", status=" + status + ", id=" + id + '}';
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + this.id;
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
    if (this.id != other.id) {
      return false;
    }
    return true;
  }


  @Override
  public int compareTo(PendingEvent o) {
    if (o == null) {
      throw new NullPointerException("HopPendingEvent was null");
    }
    return this.id - o.getId();
  }

}
