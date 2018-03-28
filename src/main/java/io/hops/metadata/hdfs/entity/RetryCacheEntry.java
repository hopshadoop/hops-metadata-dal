/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.hops.metadata.hdfs.entity;

import io.hops.exception.StorageException;
import io.hops.metadata.common.FinderType;
import io.hops.metadata.hdfs.dal.RetryCacheEntryDataAccess;
import io.hops.transaction.handler.LightWeightRequestHandler;
import java.util.Arrays;


public class RetryCacheEntry {
   public enum Finder implements FinderType<RetryCacheEntry> {
    ByClientIdAndCallId;
  
    @Override
    public Class getType() {
      return RetryCacheEntry.class;
    }
  
    @Override
    public Annotation getAnnotated() {
      switch (this){
        case ByClientIdAndCallId:
          return Annotation.PrimaryKey;
        default:
          throw new IllegalStateException();
      }
    }
  }
  
  private byte[] clientId;
  private int callId;
  private byte[] payload;
  private long expirationTime;
  private byte state;
  
  public RetryCacheEntry(byte[] clientId, int callId) {
    this.clientId = clientId;
    this.callId = callId;
    this.payload = null;
    this.expirationTime = 0;
    this.state = 0;
  }
  
  public RetryCacheEntry(byte[] clientId, int callId, byte[] payload, long expirationTime, byte state) {
    this.clientId = clientId;
    this.callId = callId;
    this.payload = payload;
    this.expirationTime = expirationTime;
    this.state = state;
  }

  public byte[] getClientId() {
    return clientId;
  }

  public int getCallId() {
    return callId;
  }

  public byte[] getPayload() {
    return payload;
  }

  public long getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(long expirationTime) {
    this.expirationTime = expirationTime;
  }

  public byte getState() {
    return state;
  }
  
  public static class PrimaryKey {
    private byte[] clientId;
    private int callId;
    
    public PrimaryKey(byte[] clientId, int callId) {
      this.clientId = clientId;
      this.callId = callId;
    }

    public byte[] getClientId() {
      return clientId;
    }

    public int getCallId() {
      return callId;
    }
    
    @Override
    public boolean equals(Object o) {
      if (o instanceof PrimaryKey) {
        PrimaryKey otherPK = (PrimaryKey) o;
        return (clientId == otherPK.getClientId()&&
            callId == otherPK.getCallId());
      }
      return false;
    }
  
    @Override
    public int hashCode() {
      //TODO: Do we need to implement stronger hash code?
      //Collisions not dangerous, only used for HashMap key.
      return Arrays.hashCode(clientId) * callId;
    }
  }
}
