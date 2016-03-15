/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import io.hops.metadata.yarn.entity.YarnRunningPrice;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author rizvi
 */
public interface YarnRunningPriceDataAccess<T> extends EntityDataAccess {

  //T findEntry(String projectId) throws StorageException;

  Map<Integer, YarnRunningPrice> getAll() throws StorageException;

  void add(T YarnRunningPrice) throws StorageException;

}