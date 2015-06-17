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
package io.hops.metadata.yarn.dal.fair;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import io.hops.metadata.yarn.entity.fair.PreemptionMap;

public interface PreemptionMapDataAccess<T> extends EntityDataAccess {

  List<T> findById(String id) throws StorageException;

  void addAll(Collection<T> modified) throws StorageException;

  void removeAll(Collection<T> removed) throws StorageException;

  Map<String, List<PreemptionMap>> getAll() throws IOException;
}
