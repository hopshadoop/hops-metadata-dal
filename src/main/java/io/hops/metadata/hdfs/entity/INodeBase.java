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

public class INodeBase {

  protected int id;
  protected int parentId;
  protected String name;
  protected byte[] userID;
  protected byte[] groupID;
  protected String userName;
  protected String groupName;
  protected short permission;
  protected long header;
  protected boolean dirWithQuota;
  protected boolean underConstruction;
  protected boolean subtreeLocked;
  protected long subtreeLockOwner;
  protected long fileSize;

  public INodeBase(){
  }

  public INodeBase(int id, int parentId, String name, byte[] userID,
      byte[] groupID, short permission, long header, boolean dirWithQuota,
      boolean underConstruction, boolean subtreeLocked, long subtreeLockOwner, long fileSize) {
    this.id = id;
    this.parentId = parentId;
    this.name = name;
    this.userID = userID;
    this.groupID = groupID;
    this.permission = permission;
    this.header = header;
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

  public byte[] getUserID() {
    return userID;
  }

  public void setUserID(byte[] userID) {
    this.userID = userID;
  }

  public byte[] getGroupID() {
    return groupID;
  }

  public void setGroupID(byte[] groupID) {
    this.groupID = groupID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName.isEmpty() ? null : userName;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public short getPermission() {
    return permission;
  }

  public void setPermission(short permission) {
    this.permission = permission;
  }

  public long getHeader() {
    return header;
  }

  public void setHeader(long header) {
    this.header = header;
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

  public void setFileSize(long fileSize) {
    this.fileSize = fileSize;
  }
}
