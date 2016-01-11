/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import io.hops.metadata.yarn.entity.ContainersLogs;

import java.util.Collection;
import java.util.Map;

public interface ContainersLogsDataAccess<T> extends EntityDataAccess {

  Map<String, ContainersLogs> getAll() throws StorageException;

  Map<String, ContainersLogs> getByExitStatus(int exitstatus) throws
          StorageException;

  void addAll(Collection<T> ContainersLogs) throws StorageException;
}
