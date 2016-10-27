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
package io.hops.metadata.yarn.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import io.hops.metadata.yarn.entity.NextHeartbeat;
import java.util.Collection;

import java.util.Map;

/**
 * DataAccess Interface for the table storing the RMNode.nextheartbeat field.
 * <p/>
 *
 * @param <T>
 */
public interface NextHeartbeatDataAccess<T> extends EntityDataAccess {

  /**
   * @param rmnodeId
   * @return
   * @throws io.hops.exception.StorageException
   */
  boolean findEntry(String rmnodeId) throws StorageException;

  /**
   * @param rmnodeid
   * @param nextHeartbeat
   * @throws StorageException
   */
  void updateAll(Collection<NextHeartbeat> toUpdate)
          throws StorageException;

  void update(NextHeartbeat toUpdate)
          throws StorageException;

  Map<String, Boolean> getAll() throws StorageException;

}
