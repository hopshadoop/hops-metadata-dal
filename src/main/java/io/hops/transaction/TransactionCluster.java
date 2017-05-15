package io.hops.transaction;

/**
 * TransactionCluster indicates which MySQL Cluster cluster to connect to.
 * Note that PRIMARY and LOCAL are the same cluster if either:
 * 1) No secondary cluster is configured.
 * 2) The MySQL Cluster cluster localized in the same Availability Zone
 *    is the primary cluster.
 */
public enum TransactionCluster {
  /**
   * Connect to the PRIMARY database cluster.
   * Transactions commited on the primary database are permanent and will not be rolled back.
   */
  PRIMARY,

  /**
   * Connect to the LOCAL database cluster.
   * If the local database cluster happens to be the secondary, then committed transactions
   * may be rolled back if they are in conflict with the primary.
   */
  LOCAL
}
