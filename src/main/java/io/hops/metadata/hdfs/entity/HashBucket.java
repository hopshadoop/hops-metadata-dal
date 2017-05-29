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

import io.hops.metadata.common.FinderType;

public class HashBucket {
  
  public enum Finder implements FinderType<HashBucket> {
    ByBucketIdAndStorageId;
  
    @Override
    public Class getType() {
      return HashBucket.class;
    }
  
    @Override
    public Annotation getAnnotated() {
      switch (this){
        case ByBucketIdAndStorageId:
          return Annotation.PrimaryKey;
        default:
          throw new IllegalStateException();
      }
    }
  }
  
  private int bucketId;
  private int storageId;
  private long hash;
  
  public HashBucket(int bucketId, int storageId, long hash) {
    this.bucketId = bucketId;
    this.storageId = storageId;
    this.hash = hash;
  }
  
  public int getBucketId() {
    return bucketId;
  }
  
  public int getStorageId() {
    return storageId;
  }
  
  public long getHash() {
    return hash;
  }
  
  public void setHash(long hash) {
    this.hash = hash;
  }
  
  public static class PrimaryKey {
    private int bucketId;
    private int storageId;
    
    public PrimaryKey(int bucketId, int storageId) {
      this.bucketId = bucketId;
      this.storageId = storageId;
    }
    
    public int getBucketId() {
      return bucketId;
    }
    
    public int getStorageId() {
      return storageId;
    }
    
    @Override
    public boolean equals(Object o) {
      if (o instanceof PrimaryKey) {
        PrimaryKey otherPK = (PrimaryKey) o;
        return (bucketId == otherPK.getBucketId() &&
            storageId == otherPK.getStorageId());
      }
      return false;
    }
  
    @Override
    public int hashCode() {
      //TODO: Do we need to implement stronger hash code?
      //Collisions not dangerous, only used for HashMap key.
      return bucketId * storageId;
    }
  }
}
