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

import io.hops.metadata.common.FinderType;

public class QuotaUpdate {
  private int id;
  private int inodeId;
  private long namespaceDelta;
  private long diskspaceDelta;

  public static enum Finder implements FinderType<QuotaUpdate> {
    ByINodeId;

    @Override
    public Class getType() {
      return QuotaUpdate.class;
    }

    @Override
    public Annotation getAnnotated() {
      return Annotation.PrunedIndexScan;
    }
  }

  public QuotaUpdate(int id, int inodeId, long namespaceDelta,
      long diskspaceDelta) {
    this.id = id;
    this.inodeId = inodeId;
    this.namespaceDelta = namespaceDelta;
    this.diskspaceDelta = diskspaceDelta;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getInodeId() {
    return inodeId;
  }

  public void setInodeId(int inodeId) {
    this.inodeId = inodeId;
  }

  public long getNamespaceDelta() {
    return namespaceDelta;
  }

  public void setNamespaceDelta(int namespaceDelta) {
    this.namespaceDelta = namespaceDelta;
  }

  public long getDiskspaceDelta() {
    return diskspaceDelta;
  }

  public void setDiskspaceDelta(long diskspaceDelta) {
    this.diskspaceDelta = diskspaceDelta;
  }

  @Override
  public String toString() {
    return "QuotaUpdate{" +
        "id=" + id +
        ", inodeId=" + inodeId +
        ", namespaceDelta=" + namespaceDelta +
        ", diskspaceDelta=" + diskspaceDelta +
        '}';
  }
}
