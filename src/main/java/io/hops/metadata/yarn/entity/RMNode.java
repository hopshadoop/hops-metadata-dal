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

public class RMNode implements Comparable<RMNode> {

  private final String nodeId;
  private final String hostName;
  private final int commandPort;
  private final int httpPort;
  private final String healthReport;
  private final long lastHealthReportTime;
  private final String currentState;
  private final String nodemanagerVersion;
  private final int pendingEventId;

  public RMNode(String nodeId) {
    this.nodeId = nodeId;
    this.hostName = null;
    this.commandPort = -1;
    this.httpPort = -1;
    this.healthReport = null;
    this.lastHealthReportTime = -1;
    this.currentState = null;
    this.nodemanagerVersion = null;
    this.pendingEventId = 0;
  }

  public RMNode(String nodeId, String hostName, int commandPort, int httpPort,
           String healthReport, long lastHealthReportTime, String currentState,
          String nodemanagerVersion, int pendingId) {
    this.nodeId = nodeId;
    this.hostName = hostName;
    this.commandPort = commandPort;
    this.httpPort = httpPort;
    this.healthReport = healthReport;
    this.lastHealthReportTime = lastHealthReportTime;
    this.currentState = currentState;
    this.nodemanagerVersion = nodemanagerVersion;
    this.pendingEventId = pendingId;
  }

  public String getNodemanagerVersion() {
    return nodemanagerVersion;
  }

  public String getNodeId() {
    return nodeId;
  }

  public String getHostName() {
    return hostName;
  }

  public int getCommandPort() {
    return commandPort;
  }

  public int getHttpPort() {
    return httpPort;
  }

  public String getHealthReport() {
    return healthReport;
  }

  public long getLastHealthReportTime() {
    return lastHealthReportTime;
  }

  public String getCurrentState() {
    return currentState;
  }

  public int getPendingEventId() {
    return pendingEventId;
  }

  @Override
  public int compareTo(RMNode o) {
    if (o == null) {
      throw new NullPointerException("HOP :: HopRMNode was null");
    }
    return this.nodeId.compareTo(o.nodeId);
    
  }

  @Override
  public String toString() {
    return "HopRMNode{" + "nodeId=" + nodeId + '}';
  }

  @Override
  public int hashCode() {

    return nodeId.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof RMNode)) {
      return false;
    }
    RMNode other = (RMNode) obj;
    return nodeId.equals(other.nodeId);
  }

}
