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

public class SubTreeOperation implements Comparable<SubTreeOperation> {

  public static enum StoOperationType {
    RENAME_STO, //STO = Sub Tree Operation
    DELETE_STO,
    CONTENT_SUMMARY,
    QUOTA_STO,
    SET_PERMISSION_STO,
    SET_OWNER_STO,
    META_ENABLE,
    NA;
  }
  public static enum Finder implements FinderType<SubTreeOperation> {
    ByPathPrefix;

    @Override
    public Class getType() {
      return SubTreeOperation.class;
    }

    @Override
    public Annotation getAnnotated() {
      switch (this) {
        case ByPathPrefix:
          return Annotation.IndexScan;
        default:
          throw new IllegalStateException();
      }
    }

  }

  private long nameNodeId;
  private String path;
  private StoOperationType opType;

  public SubTreeOperation(String path){
    this.path = path;
    this.nameNodeId = -1;
    this.opType = opType.NA; 
  }
          
  public SubTreeOperation(String path, long nameNodeId, StoOperationType opType) {
    this.path = path;
    this.nameNodeId = nameNodeId;
    this.opType = opType; 
  }

  /**
   * @return the name node id
   */
  public long getNameNodeId() {
    return nameNodeId;
  }

  /**
   * @param name node id
   *     set the name node id
   */
  public void setHolderId(long nameNodeId) {
    this.nameNodeId = nameNodeId;
  }

  /**
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * @param path
   *     the path to set
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * 
   * @return returns the operation type
   */
  public StoOperationType getOpType() {
    return opType;
  }

  /**
   * 
   * @param opType  set the operation type
   */
  public void setOpType(StoOperationType opType) {
    this.opType = opType;
  }
  

  @Override
  public int compareTo(SubTreeOperation t) {
    return this.path.compareTo(t.getPath());
  }

  @Override
  public boolean equals(Object obj) {
    SubTreeOperation other = (SubTreeOperation) obj;
    return (this.path.equals(other.getPath()) 
            && this.nameNodeId == other.getNameNodeId() && 
            this.opType == other.opType
            );
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + (this.path != null ? this.path.hashCode() : 0);
    hash = 37 * hash + (new Long(nameNodeId)).hashCode();
    return hash;
  }

  @Override
  public String toString() {
    return this.path;
  }
}
