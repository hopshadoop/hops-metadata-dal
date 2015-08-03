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

public class ProjectedINode implements Comparable<ProjectedINode> {
  private int id;
  private int parentId;
  private String name;
  private byte[] permission;
  private long header;
  private boolean symlink;
  private boolean dirWithQuota;
  private boolean underConstruction;
  private boolean subtreeLocked;
  private long subtreeLockOwner;
  private long fileSize;

  public ProjectedINode(int id, int parentId, String name, byte[] permission,
      long header, boolean symlink, boolean dirWithQuota,
      boolean underConstruction, boolean subtreeLocked, long subtreeLockOwner,
      long fileSize) {
    this.id = id;
    this.parentId = parentId;
    this.name = name;
    this.permission = permission;
    this.header = header;
    this.symlink = symlink;
    this.dirWithQuota = dirWithQuota;
    this.underConstruction = underConstruction;
    this.subtreeLocked = subtreeLocked;
    this.subtreeLockOwner = subtreeLockOwner;
    this.fileSize = fileSize;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public byte[] getPermission() {
    return permission;
  }

  public void setPermission(byte[] permission) {
    this.permission = permission;
  }

  public long getHeader() {
    return header;
  }

  public void setHeader(long header) {
    this.header = header;
  }

  public boolean isSymlink() {
    return symlink;
  }

  public void setSymlink(boolean symlink) {
    this.symlink = symlink;
  }

  public boolean isDirectory() {
    return header == 0 && !symlink;
  }

  public boolean isDirWithQuota() {
    return dirWithQuota;
  }

  public void setDirWithQuota(boolean dirWithQuota) {
    this.dirWithQuota = dirWithQuota;
  }

  public boolean isUnderConstruction() {
    return underConstruction;
  }

  public void setUnderConstruction(boolean underConstruction) {
    this.underConstruction = underConstruction;
  }

  public boolean isSubtreeLocked() {
    return subtreeLocked;
  }

  public void setSubtreeLocked(boolean subtreeLocked) {
    this.subtreeLocked = subtreeLocked;
  }

  public long getSubtreeLockOwner() {
    return subtreeLockOwner;
  }

  public void setSubtreeLockOwner(long subtreeLockOwner) {
    this.subtreeLockOwner = subtreeLockOwner;
  }

  public long getFileSize() {
    return fileSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ProjectedINode that = (ProjectedINode) o;

    if (id != that.id) {
      return false;
    }
    if (parentId != that.parentId) {
      return false;
    }
    if (!name.equals(that.name)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + parentId;
    result = 31 * result + name.hashCode();
    return result;
  }

  @Override
  public int compareTo(ProjectedINode other) {
    if (id < other.getId()) {
      return -1;
    }
    if (id > other.getId()) {
      return 1;
    }
    return 0;
  }
}
