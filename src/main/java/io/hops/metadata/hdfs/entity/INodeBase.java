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
  protected int partitionId;
  protected int userID;
  protected int groupID;
  protected String userName;
  protected String groupName;
  protected short permission;
  protected long header;
  protected boolean dirWithQuota;
  protected boolean underConstruction;
  protected boolean subtreeLocked;
  protected long subtreeLockOwner;
  protected long fileSize;
  protected boolean isDir;
  protected int logicalTime;
  protected byte storagePolicy;

  public INodeBase(){}

  public INodeBase(int id, int parentId, String name, int partitionId, boolean isDir, int userID,
      int groupID, short permission, long header, boolean dirWithQuota,
      boolean underConstruction, boolean subtreeLocked, long
      subtreeLockOwner, long fileSize, int logicalTime, byte storagePolicy) {
    this.id = id;
    this.parentId = parentId;
    this.isDir = isDir;
    this.name = name;
    this.partitionId = partitionId;
    this.userID = userID;
    this.groupID = groupID;
    this.permission = permission;
    this.header = header;
    this.dirWithQuota = dirWithQuota;
    this.underConstruction = underConstruction;
    this.subtreeLocked = subtreeLocked;
    this.subtreeLockOwner = subtreeLockOwner;
    this.fileSize = fileSize;
    this.logicalTime = logicalTime;
    this.storagePolicy = storagePolicy;
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

  public boolean isDirectory(){
    return this.isDir;
  }

  public void setIsDir(boolean isDir){
    this.isDir = isDir;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPartitionId(){
    return partitionId;
  }

  public void setPartitionId(int partitionId){
    this.partitionId = partitionId;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public int getGroupID() {
    return groupID;
  }

  public void setGroupID(int groupID) {
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

  public int getLogicalTime() {
    return logicalTime;
  }

  public void setLogicalTime(int logicalTime) {
    this.logicalTime = logicalTime;
  }

  public byte getStoragePolicy() {
    return storagePolicy;
  }

  public void setStoragePolicy(byte storagePolicy) {
    this.storagePolicy = storagePolicy;
  }
}
