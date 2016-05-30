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
package io.hops.metadata.hdfs.entity;

public abstract class ReplicaBase implements Comparable<ReplicaBase> {

  protected int storageId;
  protected long blockId;
  private int inodeId;

  public ReplicaBase(int storageId, long blockId, int inodeId) {
    this.storageId = storageId;
    this.blockId = blockId;
    this.inodeId = inodeId;
  }

  /**
   * @return the storageId
   */
  public int getStorageId() {
    return storageId;
  }

  /**
   * @param storageId
   *     the storageId to set
   */
  public void setStorageId(int storageId) {
    this.storageId = storageId;
  }

  /**
   * @return the blockId
   */
  public long getBlockId() {
    return blockId;
  }

  /**
   * @param blockId
   *     the blockId to set
   */
  public void setBlockId(long blockId) {
    this.blockId = blockId;
  }

  public int getInodeId() {
    return inodeId;
  }

  public void setInodeId(int inodeId) {
    this.inodeId = inodeId;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + this.storageId;
    hash = 59 * hash + (int) (this.blockId ^ (this.blockId >>> 32));
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
    final ReplicaBase other = (ReplicaBase) obj;
    if (this.storageId != other.storageId) {
      return false;
    }
    if (this.blockId != other.blockId) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(ReplicaBase t) {
    if (this.equals(t)) {
      return 0;
    }

    if (t == null) {
      return 1;
    }
    
    if (this.getStorageId() == t.getStorageId()) {
      if (this.getBlockId() > t.getBlockId()) {
        return 1;
      } else {
        return -1;
      }
    } else {
      if (this.getStorageId() > t.getStorageId()) {
        return 1;
      } else {
        return -1;
      }
    }
  }

  @Override
  public String toString() {
    return "ReplicaBase{" +
        "storageId=" + storageId +
        ", blockId=" + blockId +
        ", inodeId=" + inodeId +
        '}';
  }
}
