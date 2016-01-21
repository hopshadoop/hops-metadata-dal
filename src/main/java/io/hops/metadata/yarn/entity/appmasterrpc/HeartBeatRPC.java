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
package io.hops.metadata.yarn.entity.appmasterrpc;

import java.util.List;
import java.util.Map;

public class HeartBeatRPC {

  //NodeStatus

  private final String nodeId;
  private final int responseId;
  private final Map<String, byte[]> containersStatuses;
  private final List<String> keepAliveApplications;
  private final byte[] nodeHealthStatus;

  //keys
  private final byte[] lastKnownContainerTokenMasterKey;
  private final byte[] LastKnownNMTokenMasterKey;

  //RPC
  private final int rpcId;

  public HeartBeatRPC(String nodeId, int responseId,
          Map<String, byte[]> containersStatuses,
          List<String> keepAliveApplications,
          byte[] nodeHealthStatus, byte[] lastKnownContainerTokenMasterKey,
          byte[] LastKnownNMTokenMasterKey, int rpcId) {
    this.nodeId = nodeId;
    this.responseId = responseId;
    this.containersStatuses = containersStatuses;
    this.keepAliveApplications = keepAliveApplications;
    this.nodeHealthStatus = nodeHealthStatus;
    this.lastKnownContainerTokenMasterKey = lastKnownContainerTokenMasterKey;
    this.LastKnownNMTokenMasterKey = LastKnownNMTokenMasterKey;
    this.rpcId = rpcId;
  }

  public String getNodeId() {
    return nodeId;
  }

  public int getResponseId() {
    return responseId;
  }

  public Map<String, byte[]> getContainersStatuses() {
    return containersStatuses;
  }

  public List<String> getKeepAliveApplications() {
    return keepAliveApplications;
  }

  public byte[] getNodeHealthStatus() {
    return nodeHealthStatus;
  }

  public byte[] getLastKnownContainerTokenMasterKey() {
    return lastKnownContainerTokenMasterKey;
  }

  public byte[] getLastKnownNMTokenMasterKey() {
    return LastKnownNMTokenMasterKey;
  }

  public int getRpcId() {
    return rpcId;
  }

}
