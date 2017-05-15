package io.hops;

import io.hops.exception.StorageException;
import io.hops.transaction.TransactionCluster;

import java.util.Properties;

/**
 * MultiZoneStorageConnector holds one or more storage connectors that connect to (up to) two clusters.
 */
public interface MultiZoneStorageConnector {
  /**
   * connectorFor returns a StorageConnector for the appropriate cluster.
   * Note that if the configuration supplied to setConfiguration only configures
   * one cluster, that will be returned, regardless of the value of the cluster parameter.
   * @param cluster whether to connect to the local or primary cluster. Not that they may be the same
   * @return the appropriate storage zoneConnector
   */
  StorageConnector connectorFor(TransactionCluster cluster);
}
