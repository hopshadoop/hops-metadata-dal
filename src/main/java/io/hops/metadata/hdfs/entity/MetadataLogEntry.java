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

public class MetadataLogEntry {
  private int datasetId;
  private int inodeId;
  private int logicalTime;
  private Operation operation;

  public enum Operation {
    ADD,
    DELETE
  }

  public enum Finder implements FinderType<MetadataLogEntry> {
    ALL_CACHED,
    FETCH_EXISTING;

    @Override
    public Class getType() {
      return MetadataLogEntry.class;
    }

    @Override
    public Annotation getAnnotated() {
      switch (this) {
        case ALL_CACHED:
          return Annotation.CacheOnly;
        case FETCH_EXISTING:
          return Annotation.Batched;
        default:
          throw new IllegalStateException();
      }
    }
  }

  public MetadataLogEntry(int datasetId, int inodeId, Operation operation) {
    this(datasetId, inodeId, 0, operation);
  }

  public MetadataLogEntry(int datasetId, int inodeId, int logicalTime,
      Operation operation) {
    this.datasetId = datasetId;
    this.inodeId = inodeId;
    this.logicalTime = logicalTime;
    this.operation = operation;
  }

  public int getDatasetId() {
    return datasetId;
  }

  public void setDatasetId(int datasetId) {
    this.datasetId = datasetId;
  }

  public int getInodeId() {
    return inodeId;
  }

  public void setInodeId(int inodeId) {
    this.inodeId = inodeId;
  }

  public int getLogicalTime() {
    return logicalTime;
  }

  public void setLogicalTime(int logicalTime) {
    this.logicalTime = logicalTime;
  }

  public void incrementLogicalTime() {
    this.logicalTime++;
  }

  public Operation getOperation() {
    return operation;
  }

  public short getOperationOrdinal() {
    return (short) operation.ordinal();
  }

  public void setOperation(
      Operation operation) {
    this.operation = operation;
  }
}
