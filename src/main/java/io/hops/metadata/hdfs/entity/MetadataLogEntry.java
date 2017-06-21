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
  private final int datasetId;
  private final int inodeId;
  private final int inodePartitionId;
  private final int inodeParentId;
  private final String inodeName;
  private long timestamp;
  private final Operation operation;

  public enum Operation {
    ADD,
    DELETE
  }

  public MetadataLogEntry(int datasetId, int inodeId, int inodePartitionId,
      int inodeParentId, String inodeName, Operation
      operation) {
    this(datasetId, inodeId, inodePartitionId, inodeParentId, inodeName, 0,
        operation);
    this.timestamp = System.currentTimeMillis();
  }

  public MetadataLogEntry(int datasetId, int inodeId, int inodePartitionId,
      int inodeParentId, String inodeName, long timestamp, Operation
      operation) {
    this.datasetId = datasetId;
    this.inodeId = inodeId;
    this.inodePartitionId = inodePartitionId;
    this.inodeParentId = inodeParentId;
    this.inodeName = inodeName;
    this.timestamp = timestamp;
    this.operation = operation;
  }

  public int getDatasetId() {
    return datasetId;
  }

  public int getInodeId() {
    return inodeId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public long updateTimestamp() {
    return ++timestamp;
  }

  public Operation getOperation() {
    return operation;
  }

  public short getOperationOrdinal() {
    return (short) operation.ordinal();
  }

  public int getInodePartitionId() {
    return inodePartitionId;
  }

  public int getInodeParentId() {
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
        ", timestamp=" + timestamp +
        ", operation=" + operation +
        '}';
  }
}
