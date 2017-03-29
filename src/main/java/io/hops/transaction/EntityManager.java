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
package io.hops.transaction;

import io.hops.StorageConnector;
import io.hops.exception.StorageException;
import io.hops.exception.TransactionContextException;
import io.hops.metadata.common.CounterType;
import io.hops.metadata.common.FinderType;
import io.hops.transaction.context.ContextInitializer;
import io.hops.transaction.context.EntityContext;
import io.hops.transaction.context.EntityContextStat;
import io.hops.transaction.context.TransactionContext;
import io.hops.transaction.context.TransactionContextMaintenanceCmds;
import io.hops.transaction.handler.RequestHandler;
import io.hops.transaction.lock.TransactionLocks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * EntityManager needs a call to {@link EntityManager:transaction}
 * to setup variables for the local thread before doing anything
 *
 */
public class EntityManager {

  private EntityManager() {
  }

  private static class Context {
    // connector to use during transaction
    StorageConnector connector;
    // transaction context
    TransactionContext txContext;

    public Context(StorageConnector connector, TransactionContext txContext) {
      this.connector = connector;
      this.txContext = txContext;
    }
  }

  private static ThreadLocal<Context> context = new ThreadLocal<>();
  private static CopyOnWriteArrayList<ContextInitializer> contextInitializers =
      new CopyOnWriteArrayList<>();

  private static boolean initialized = false;

  public static void addContextInitializer(ContextInitializer ci) {
    contextInitializers.add(ci);
    if (!initialized) {
      initialized = true;
      RequestHandler.setStorageConnector(ci.getMultiZoneConnector());
    }
  }

  /**
   * @returns the {@link StorageConnector} bound to this transaction
   */
  public static StorageConnector transactionConnector() throws StorageException{
    return context().connector;
  }

  /**
   * This initializes all the thread-local data for the transaction using the provided {@link StorageConnector}.
   * In a {@link RequestHandler} the {@link StorageConnector} can be obtained by using {@link RequestHandler#zoneConnector}.
   * This should not be initialized more than once.
   * Initialization must happen on the first invocation on a new thread or any invocation
   * after a {@link #commit(TransactionLocks)} or {@link #rollback(TransactionLocks)}.
   *
   * @param connector the connector to use for this transaction
   */
  public static void initTransaction(StorageConnector connector) {
    Context ctx = context.get();
    if(ctx != null) {
      throw new RuntimeException("transaction was not committed or rolled back");
      // return ctx.connector;
    }
    ctx = new EntityManager.Context(connector, createContext(connector));
    context.set(ctx);
  }

  private static Context context() {
    Context ctx = context.get();
    if (ctx == null) {
      throw new RuntimeException("context was not initialized");
    }
    return ctx;
  }

  public static void begin() throws StorageException {
    context().txContext.begin();
  }

  public static void preventStorageCall(boolean val) {
    context().txContext.preventStorageCall(val);
  }

  public static void commit(TransactionLocks tlm)
      throws TransactionContextException, StorageException {
    context().txContext.commit(tlm);
    removeContext();
  }

  public static void rollback(TransactionLocks tlm)
      throws StorageException, TransactionContextException {
    context().txContext.rollback();
    removeContext();
  }

  public static <T> void remove(T obj)
      throws StorageException, TransactionContextException {
    context().txContext.remove(obj);
  }

  public static void removeAll(Class type)
      throws StorageException, TransactionContextException {
    context().txContext.removeAll(type);
  }

  public static <T> Collection<T> findList(
      FinderType<T> finder, Object... params)
      throws TransactionContextException, StorageException {
    return context().txContext.findList(finder, params);
  }

  public static <T> T find(
      FinderType<T> finder, Object... params)
      throws TransactionContextException, StorageException {
    return context().txContext.find(finder, params);
  }

  public static int count(
      CounterType counter, Object... params)
      throws TransactionContextException, StorageException {
    return context().txContext.count(counter, params);
  }

  public static <T> void update(T entity)
      throws TransactionContextException, StorageException {
    context().txContext.update(entity);
  }

  public static <T> void add(T entity)
      throws TransactionContextException, StorageException {
    context().txContext.add(entity);
  }
  
  public static <T> void snapshotMaintenance(
      TransactionContextMaintenanceCmds cmds, Object... params)
      throws TransactionContextException {
    context().txContext.snapshotMaintenance(cmds, params);
  }

  public static void writeLock() throws StorageException {
    // this sets the lock mode in a thread-local object.
    EntityContext.setLockMode(EntityContext.LockMode.WRITE_LOCK);
    context().connector.writeLock();
  }

  public static void readLock() throws StorageException {
    // this sets the lock mode in a thread-local object.
    EntityContext.setLockMode(EntityContext.LockMode.READ_LOCK);
    context().connector.readLock();
  }

  public static void readCommited() throws StorageException {
    // this sets the lock mode in a thread-local object.
    EntityContext.setLockMode(EntityContext.LockMode.READ_COMMITTED);
    context().connector.readCommitted();
  }

  public static void setPartitionKey(Class name, Object key)
      throws StorageException {
    context().connector.setPartitionKey(name, key);
  }
  
  public static Collection<EntityContextStat> collectSnapshotStat()
      throws TransactionContextException {
    return context().txContext.collectSnapshotStat();
  }

  private static TransactionContext createContext(StorageConnector connector) {
    Map<Class, EntityContext> storageMap = new HashMap<>();
    for (ContextInitializer initializer : contextInitializers) {
      Map<Class, EntityContext> tmp = initializer.createEntityContexts(connector);
      for (Class clzz : tmp.keySet()) {
        storageMap.put(clzz, tmp.get(clzz));
      }
    }
    return new TransactionContext(connector, storageMap);
  }
  
  private static void removeContext() {
    context.remove();
  }
}
