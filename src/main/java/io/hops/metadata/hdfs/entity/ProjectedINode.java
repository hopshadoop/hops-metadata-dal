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

public class ProjectedINode extends INodeBase implements
    Comparable<ProjectedINode> {
  private boolean symlink;

  public ProjectedINode(int id, int parentId, String name, short permission,
      byte[] userID, byte[] groupID, long header, boolean symlink, boolean dirWithQuota, boolean
      underConstruction, boolean subtreeLocked, long subtreeLockOwner, long fileSize) {
    super(id, parentId, name, userID, groupID, permission, header,
        dirWithQuota, underConstruction, subtreeLocked, subtreeLockOwner, fileSize);
    this.symlink = symlink;
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
