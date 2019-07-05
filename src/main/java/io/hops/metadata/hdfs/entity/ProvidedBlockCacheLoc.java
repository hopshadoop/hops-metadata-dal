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

import java.util.Objects;

public class ProvidedBlockCacheLoc implements Comparable<ProvidedBlockCacheLoc> {

  private long blockID;
  private int storageID;

  public ProvidedBlockCacheLoc(long block_id, int storage_id) {
    this.blockID = block_id;
    this.storageID = storage_id;
  }

  public long getBlockID() {
    return blockID;
  }

  public void setBlockID(long blockID) {
    this.blockID = blockID;
  }

  public int getStorageID() {
    return storageID;
  }

  public void setStorageID(int storageID) {
    this.storageID = storageID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProvidedBlockCacheLoc that = (ProvidedBlockCacheLoc) o;
    return blockID == that.blockID &&
            storageID == that.storageID;
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockID, storageID);
  }

  @Override
  public int compareTo(ProvidedBlockCacheLoc o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
