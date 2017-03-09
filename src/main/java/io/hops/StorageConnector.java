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
package io.hops;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;

import java.util.Properties;

public interface StorageConnector {

  void setConfiguration(Properties conf) throws StorageException;

  <T> T obtainSession() throws StorageException;

  void beginTransaction() throws StorageException;

  void commit() throws StorageException;

  void rollback() throws StorageException;

  boolean formatAllStorageNonTransactional() throws StorageException;

  boolean formatYarnStorageNonTransactional() throws StorageException;

  boolean formatHDFSStorageNonTransactional() throws StorageException;

  boolean formatStorage() throws StorageException;

  boolean formatYarnStorage() throws StorageException;

  boolean formatHDFSStorage() throws StorageException;

  boolean formatStorage(Class<? extends EntityDataAccess>... das)
      throws StorageException;

  boolean isTransactionActive() throws StorageException;

  void stopStorage() throws StorageException;

  void readLock() throws StorageException;

  void writeLock() throws StorageException;

  void readCommitted() throws StorageException;

  void setPartitionKey(Class className, Object key)
      throws StorageException;

  void dropAndRecreateDB() throws StorageException;

  void flush() throws StorageException;

  String getClusterConnectString();

  String getDatabaseName();
}
