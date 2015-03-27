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
 * Represents a row in the ha_invokerequests table that stores requests to be
 * sent from secondary RMs to the scheduler.
 */
public class InvokeRequest {

  private int nodeid;
  private int type;
  private int status;

  public InvokeRequest(int nodeid, int type, int status) {
    this.nodeid = nodeid;
    this.type = type;
    this.status = status;
  }

  public int getNodeid() {
    return nodeid;
  }

  public void setNodeid(int nodeid) {
    this.nodeid = nodeid;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "InvokeRequest{" + "nodeid=" + nodeid + ", type=" + type +
        ", status=" + status + '}';
  }
}
