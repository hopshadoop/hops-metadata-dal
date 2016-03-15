/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.dal.rmstatestore;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UpdatedNodeDataAccess<T> extends EntityDataAccess {
  void addAll(Collection<T> toAdd) throws StorageException;
  
  void removeAll(Collection<T> toRemove) throws StorageException;
  
  Map<String,List<T>> getAll() throws StorageException;
}
