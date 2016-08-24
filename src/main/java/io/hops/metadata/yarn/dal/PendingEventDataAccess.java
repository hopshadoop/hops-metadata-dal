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
import io.hops.metadata.yarn.entity.PendingEvent;

import java.util.Collection;
import java.util.List;

/**
 * @param <T>
 */
public interface PendingEventDataAccess<T> extends EntityDataAccess {

  /**
   * Retrieve all pending events.
   * <p/>
   *
   * @return
   * @throws io.hops.exception.StorageException
   */
  List<T> getAll() throws StorageException;
  
  /**
   * Retrieve all pending events with the given status.
   * <p/>
   *
   * @param status
   * @return
   * @throws StorageException
   */
  List<T> getAll(int status) throws StorageException;

  /**
   * @param pendingEvent
   * @throws StorageException
   */
  void createPendingEvent(T pendingEvent) throws StorageException;

  /**
   * @param pendingEvent
   * @throws StorageException
   */
  void removePendingEvent(T pendingEvent) throws StorageException;

  void addAll(Collection<T> toUpdate) throws StorageException;
  
  void add(T toAdd) throws StorageException;

  void removeAll(Collection<T> toRemove) throws StorageException;
}
