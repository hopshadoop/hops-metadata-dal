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

public class MetadataLogEntry {
  private final long datasetId;
  private final long inodeId;
  private final long inodePartitionId;
  private final long inodeParentId;
  private final String inodeName;
  private int logicalTime;
  private final Operation operation;

  public enum Operation {
    ADD,
    DELETE,
    UPDATE,
    RENAME,
    CHANGEDATASET
  }

  public MetadataLogEntry(long datasetId, long inodeId, long inodePartitionId,
      long inodeParentId, String inodeName, int logicalTime, Operation
      operation) {
    this.datasetId = datasetId;
    this.inodeId = inodeId;
    this.inodePartitionId = inodePartitionId;
    this.inodeParentId = inodeParentId;
    this.inodeName = inodeName;
    this.logicalTime = logicalTime;
    this.operation = operation;
  }

  public long getDatasetId() {
    return datasetId;
  }

  public long getInodeId() {
    return inodeId;
  }

  public int getLogicalTime() {
    return logicalTime;
  }

  public Operation getOperation() {
    return operation;
  }

  public short getOperationOrdinal() {
    return (short) operation.ordinal();
  }

  public long getInodePartitionId() {
    return inodePartitionId;
  }

  public long getInodeParentId() {
    return inodeParentId;
  }

  public String getInodeName() {
    return inodeName;
  }

  @Override
  public String toString() {
    return "MetadataLogEntry{" +
        "datasetId=" + datasetId +
        ", inodeId=" + inodeId +
        ", inodePartitionId=" + inodePartitionId +
        ", inodeParentId=" + inodeParentId +
        ", inodeName='" + inodeName + '\'' +
        ", logicalTime=" + logicalTime +
        ", operation=" + operation +
        '}';
  }
}
