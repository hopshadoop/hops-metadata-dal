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

public class RPC implements Comparable<RPC>{

  private final Integer rpcId;
  private final Type type;
  private final byte[] rpc;
  private final String userId;

  public RPC(int rpcId) {
    this(rpcId, null, null, null);
  }

  public RPC(int rpcId, Type type, byte[] rpc, String userId) {
    this.rpcId = rpcId;
    this.type = type;
    this.rpc = rpc;
    this.userId = userId;
  }

  public int getRPCId() {
    return rpcId;
  }

  public Type getType() {
    return type;
  }

  public byte[] getRpc() {
    return rpc;
  }

  public String getUserId() {
    return userId;
  }

  
  public enum Type {

    RegisterApplicationMaster,
    FinishApplicationMaster,
    Allocate,
    SubmitApplication,
    ForceKillApplication,
    RegisterNM,
    NodeHeartbeat,
    NodeAddedSchedulerEvent;
  }

  @Override
  public String toString() {
    return "HopRPC{rpcId=" + rpcId + ", type=" + type + ", userId=" + userId +
        '}';
  }

  @Override
  public int compareTo(RPC other){
    return this.rpcId.compareTo(other.rpcId);
  }
}
