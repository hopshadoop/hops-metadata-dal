/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import io.hops.metadata.yarn.entity.ResourceRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author misdess
 */
public interface ResourceRequestOfContainerDataAccess<T> extends EntityDataAccess {

  Map<String, List<ResourceRequest>> getAll() throws StorageException;

  void addAll(Collection<T> toAdd) throws StorageException;

  void removeAll(Collection<T> toRemove) throws StorageException;
}
