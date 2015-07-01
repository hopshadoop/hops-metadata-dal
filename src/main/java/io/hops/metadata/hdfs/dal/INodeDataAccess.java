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
package io.hops.metadata.hdfs.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import io.hops.metadata.hdfs.entity.INodeIdentifier;
import io.hops.metadata.hdfs.entity.ProjectedINode;

import java.util.Collection;
import java.util.List;

public interface INodeDataAccess<T> extends EntityDataAccess {
  
  T indexScanfindInodeById(int inodeId) throws StorageException;

  List<T> indexScanFindInodesByParentId(int parentId) throws StorageException;

  List<ProjectedINode> findInodesForSubtreeOperationsWithReadLock(int parentId)
      throws StorageException;

  T pkLookUpFindInodeByNameAndParentId(String name, int parentId)
      throws StorageException;

  List<T> getINodesPkBatched(String[] names, int[] parentIds)
      throws StorageException;

  List<INodeIdentifier> getAllINodeFiles(long startId, long endId)
      throws StorageException;
  
  boolean haveFilesWithIdsGreaterThan(long id) throws StorageException;
  
  boolean haveFilesWithIdsBetween(long startId, long endId)
      throws StorageException;
  
  long getMinFileId() throws StorageException;
  
  long getMaxFileId() throws StorageException;
  
  int countAllFiles() throws StorageException;
  
  void prepare(Collection<T> removed, Collection<T> newed,
      Collection<T> modified) throws StorageException;

  int countAll() throws StorageException;
  
  boolean hasChildren(int parentId) throws StorageException;
  
  List<T> allINodes() throws StorageException; // only for testing
}
