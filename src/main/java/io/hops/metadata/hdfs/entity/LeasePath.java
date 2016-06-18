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

public class LeasePath implements Comparable<LeasePath> {

  public static enum Finder implements FinderType<LeasePath> {

    ByHolderId,
    ByPath,
    ByPrefix;

    @Override
    public Class getType() {
      return LeasePath.class;
    }

    @Override
    public Annotation getAnnotated() {
      switch (this) {
        case ByHolderId:
          return Annotation.PrunedIndexScan;
        case ByPath:
          return Annotation.FullTableScan;
        case ByPrefix:
          return Annotation.FullTableScan;
        default:
          throw new IllegalStateException();
      }
    }

  }

  private int holderId;
  private String path;

  public LeasePath(String path, int holderId) {
    this.holderId = holderId;
    this.path = path;
  }

  /**
   * @return the holderId
   */
  public int getHolderId() {
    return holderId;
  }

  /**
   * @param holderId
   *     the holderId to set
   */
  public void setHolderId(int holderId) {
    this.holderId = holderId;
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

  @Override
  public int compareTo(LeasePath t) {
    return this.path.compareTo(t.getPath());
  }

  @Override
  public boolean equals(Object obj) {
    LeasePath other = (LeasePath) obj;
    return (this.path.equals(other.getPath()) &&
        this.holderId == other.getHolderId());
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + (this.path != null ? this.path.hashCode() : 0);
    return hash;
  }

  @Override
  public String toString() {
    return this.path;
  }
}
