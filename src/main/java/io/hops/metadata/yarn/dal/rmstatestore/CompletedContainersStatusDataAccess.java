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

public interface CompletedContainersStatusDataAccess<T> extends EntityDataAccess {
  public void update(Collection<T> entry) throws StorageException;
  
  public Map<String, List<byte[]>> getAll() throws StorageException;
}
