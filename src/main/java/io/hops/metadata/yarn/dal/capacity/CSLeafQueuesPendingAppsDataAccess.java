/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.dal.capacity;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface CSLeafQueuesPendingAppsDataAccess<T extends Object> extends EntityDataAccess {

  Map<String, Set<String>> getAll() throws StorageException, IOException;

  public void addAll(Collection<T> clctn) throws StorageException;

  public void removeAll(Collection<T> clctn) throws StorageException;
}
