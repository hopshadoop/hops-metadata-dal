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

import com.google.common.primitives.SignedBytes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class INode implements Comparable<INode> {

  private int id;
  private String name;
  private int parentId;
  private boolean dirWithQuota;
  private long modificationTime;
  private long accessTime;
  private byte[] permission;
  private boolean underConstruction;
  private String clientName;
  private String clientMachine;
  private String clientNode;
  private int generationStamp;
  private long header;
  private String symlink;
  private boolean subtreeLocked;
  private long subtreeLockOwner;

  public INode() {
  }

  public INode(int id, String name, int parentId, boolean dirWithQuota,
      long modificationTime, long accessTime, byte[] permission,
      boolean underConstruction, String clientName, String clientMachine,
      String clientNode, int generationStamp, long header, String symlink,
      boolean subtreeLocked, long subtreeLockOwner) {

    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.dirWithQuota = dirWithQuota;
    this.modificationTime = modificationTime;
    this.accessTime = accessTime;
    this.permission = permission;
    this.underConstruction = underConstruction;
    this.clientName = clientName;
    this.clientMachine = clientMachine;
    this.clientNode = clientNode;
    this.generationStamp = generationStamp;
    this.header = header;
    this.symlink = symlink;
    this.subtreeLocked = subtreeLocked;
    this.subtreeLockOwner = subtreeLockOwner;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public boolean isDir() {
    return header == 0 && symlink == null;
  }

  public boolean isDirWithQuota() {
    return dirWithQuota;
  }

  public void setDirWithQuota(boolean dirWithQuota) {
    this.dirWithQuota = dirWithQuota;
  }

  public long getModificationTime() {
    return modificationTime;
  }

  public void setModificationTime(long modificationTime) {
    this.modificationTime = modificationTime;
  }

  public long getAccessTime() {
    return accessTime;
  }

  public void setAccessTime(long accessTime) {
    this.accessTime = accessTime;
  }

  public byte[] getPermission() {
    return permission;
  }

  public void setPermission(byte[] permission) {
    this.permission = permission;
  }

  public boolean isUnderConstruction() {
    return underConstruction;
  }

  public void setUnderConstruction(boolean underConstruction) {
    this.underConstruction = underConstruction;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getClientMachine() {
    return clientMachine;
  }

  public void setClientMachine(String clientMachine) {
    this.clientMachine = clientMachine;
  }

  public String getClientNode() {
    return clientNode;
  }

  public void setClientNode(String clientNode) {
    this.clientNode = clientNode;
  }

  public int getGenerationStamp() {
    return generationStamp;
  }

  public void setGenerationStamp(int generationStamp) {
    this.generationStamp = generationStamp;
  }

  public long getHeader() {
    return header;
  }

  public void setHeader(long header) {
    this.header = header;
  }

  public String getSymlink() {
    return symlink;
  }

  public void setSymlink(String symlink) {
    this.symlink = symlink;
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

  @Override
  public final int compareTo(INode other) {
    String left = name == null ? "" : name;
    String right = other.name == null ? "" : other.name;
    return SignedBytes.lexicographicalComparator()
        .compare(left.getBytes(), right.getBytes());
  }

  @Override
  public final boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null || !(that instanceof INode)) {
      return false;
    }
    if (name.equals(((INode) that).name) && this.id == ((INode) that).id &&
        this.parentId == ((INode) that).parentId) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Arrays.hashCode(this.name.getBytes());
  }

  public static enum Order implements Comparator<INode> {

    ByName() {
      @Override
      public int compare(INode o1, INode o2) {
        // TODO - JIM why not compare by ID - more efficient?
        return o1.compareTo(o2);
      }
    };

    @Override
    public abstract int compare(INode o1, INode o2);

    public Comparator acsending() {
      return this;
    }

    public Comparator descending() {
      return Collections.reverseOrder(this);
    }
  }
}
