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
package io.hops.metadata.hdfs;

public class TablesDef {
  public static interface BlockLookUpTableDef {

    public static final String TABLE_NAME = "hdfs_block_lookup_table";
    public static final String BLOCK_ID = "block_id";
    public static final String INODE_ID = "inode_id";
  }

  public static interface StoragesTableDef {
    public static final String TABLE_NAME="hdfs_storages";
    public static final String STORAGE_ID="storage_id";
    public static final String HOST_ID="host_id";
    public static final String STORAGE_TYPE="storage_type";
  }

  public static interface INodeTableDef {
    // INode Table Columns
    public static final String TABLE_NAME = "hdfs_inodes";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PARENT_ID = "parent_id";
    public static final String MODIFICATION_TIME = "modification_time";
    public static final String ACCESS_TIME = "access_time";
    public static final String USER_ID = "user_id";
    public static final String GROUP_ID = "group_id";
    public static final String PERMISSION = "permission";
    public static final String CLIENT_NAME = "client_name";
    public static final String CLIENT_MACHINE = "client_machine";
    public static final String CLIENT_NODE = "client_node";
    public static final String GENERATION_STAMP = "generation_stamp";
    public static final String HEADER = "header";
    public static final String SYMLINK = "symlink";
    public static final String QUOTA_ENABLED = "quota_enabled";
    public static final String UNDER_CONSTRUCTION = "under_construction";
    public static final String SUBTREE_LOCKED = "subtree_locked";
    public static final String SUBTREE_LOCK_OWNER = "subtree_lock_owner";
    public static final String META_ENABLED = "meta_enabled";
    public static final String SIZE = "size";
    public static final String STORAGE_POLICY = "storage_policy";
  }

  public static interface UsersTableDef {
    public static final String TABLE_NAME = "hdfs_users";
    public static final String ID = "id";
    public static final String NAME = "name";
  }

  public static interface GroupsTableDef {
    public static final String TABLE_NAME = "hdfs_groups";
    public static final String ID = "id";
    public static final String NAME = "name";
  }

  public static interface UsersGroupsTableDef {
    public static final String TABLE_NAME = "hdfs_users_groups";
    public static final String USER_ID = "user_id";
    public static final String GROUP_ID = "group_id";
  }

  public static interface BlockChecksumTableDef {
    public static final String TABLE_NAME = "hdfs_block_checksum";
    public static final String INODE_ID = "inode_id";
    public static final String BLOCK_INDEX = "block_index";
    public static final String CHECKSUM = "checksum";
  }

  public static interface CorruptReplicaTableDef {
    public static final String TABLE_NAME = "hdfs_corrupt_replicas";
    public static final String BLOCK_ID = "block_id";
    public static final String INODE_ID = "inode_id";
    public static final String STORAGE_ID = "storage_id";
    public static final String TIMESTAMP = "timestamp";
  }

  public static interface INodeAttributesTableDef {
    public static final String TABLE_NAME = "hdfs_inode_attributes";
    public static final String ID = "inodeId";
    public static final String NSQUOTA = "nsquota";
    public static final String DSQUOTA = "dsquota";
    public static final String NSCOUNT = "nscount";
    public static final String DISKSPACE = "diskspace";
  }

  public static interface ExcessReplicaTableDef {
    public static final String TABLE_NAME = "hdfs_excess_replicas";
    public static final String BLOCK_ID = "block_id";
    public static final String INODE_ID = "inode_id";
    public static final String PART_KEY = "part_key";
    public static final String STORAGE_ID = "storage_id";
    public static final String STORAGE_IDX = "storage_idx";
  }

  public static interface BlockInfoTableDef {
    public static final String TABLE_NAME = "hdfs_block_infos";
    public static final String BLOCK_ID = "block_id";
    public static final String BLOCK_INDEX = "block_index";
    public static final String INODE_ID = "inode_id";
    public static final String NUM_BYTES = "num_bytes";
    public static final String GENERATION_STAMP = "generation_stamp";
    public static final String BLOCK_UNDER_CONSTRUCTION_STATE =
        "block_under_construction_state";
    public static final String TIME_STAMP = "time_stamp";
    public static final String PRIMARY_NODE_INDEX = "primary_node_index";
    public static final String BLOCK_RECOVERY_ID = "block_recovery_id";
  }

  public static interface EncodingStatusTableDef {
    public static final String TABLE_NAME = "hdfs_encoding_status";

    // Erasure coding table columns
    public static final String INODE_ID = "inode_id";
    public static final String PARITY_INODE_ID = "parity_inode_id";
    public static final String STATUS = "status";
    public static final String PARITY_STATUS = "parity_status";
    public static final String CODEC = "codec";
    public static final String TARGET_REPLICATION = "target_replication";
    public static final String STATUS_MODIFICATION_TIME =
        "status_modification_time";
    public static final String PARITY_STATUS_MODIFICATION_TIME =
        "parity_status_modification_time";
    public static final String PARITY_FILE_NAME = "parity_file_name";
    public static final String LOST_BLOCKS = "lost_blocks";
    public static final String LOST_PARITY_BLOCKS = "lost_parity_blocks";
    public static final String LOST_BLOCK_SUM = "lost_block_sum";
    public static final String REVOKED = "revoked";
  }

  public static interface LeaseTableDef {
    public static final String TABLE_NAME = "hdfs_leases";
    public static final String HOLDER = "holder";
    public static final String LAST_UPDATE = "last_update";
    public static final String HOLDER_ID = "holder_id";
  }

  public static interface LeasePathTableDef {
    public static final String TABLE_NAME = "hdfs_lease_paths";
    public static final String HOLDER_ID = "holder_id";
    public static final String PATH = "path";
  }

  public static interface InvalidatedBlockTableDef {
    public static final String TABLE_NAME = "hdfs_invalidated_blocks";
    public static final String INODE_ID = "inode_id";
    public static final String BLOCK_ID = "block_id";
    public static final String STORAGE_ID = "storage_id";
    public static final String STORAGE_IDX = "storage_idx";
    public static final String GENERATION_STAMP = "generation_stamp";
    public static final String NUM_BYTES = "num_bytes";
  }

  public static interface MisReplicatedRangeQueueTableDef {
    public static final String TABLE_NAME = "hdfs_misreplicated_range_queue";
    public static final String RANGE = "range";
  }

  public static interface PendingBlockTableDef {

    public static final String TABLE_NAME = "hdfs_pending_blocks";
    public static final String BLOCK_ID = "block_id";
    public static final String INODE_ID = "inode_id";
    public static final String TIME_STAMP = "time_stamp";
    public static final String NUM_REPLICAS_IN_PROGRESS =
        "num_replicas_in_progress";
  }

  public static interface ReplicaTableDef {

    public static final String TABLE_NAME = "hdfs_replicas";
    public static final String BLOCK_ID = "block_id";
    public static final String STORAGE_ID = "storage_id";
    public static final String INODE_ID = "inode_id";
    public static final String REPLICA_INDEX = "replica_index";
  }

  public static interface QuotaUpdateTableDef {

    public static final String TABLE_NAME = "hdfs_quota_update";
    public static final String ID = "id";
    public static final String INODE_ID = "inode_id";
    public static final String NAMESPACE_DELTA = "namespace_delta";
    public static final String DISKSPACE_DELTA = "diskspace_delta";
  }

  public static interface ReplicaUnderConstructionTableDef {

    public static final String TABLE_NAME = "hdfs_replica_under_constructions";
    public static final String BLOCK_ID = "block_id";
    public static final String STORAGE_ID = "storage_id";
    public static final String INODE_ID = "inode_id";
    public static final String STATE = "state";
    public static final String REPLICA_INDEX = "replica_index";
  }

  public static interface SafeBlocksTableDef {

    public static final String TABLE_NAME = "hdfs_safe_blocks";
    public static final String ID = "id";
  }

  public static interface StorageIdMapTableDef {
    public static final String TABLE_NAME = "hdfs_storage_id_map";
    public static final String STORAGE_ID = "storage_id";
    public static final String SID = "sid";
  }

  public static interface UnderReplicatedBlockTableDef {

    public static final String TABLE_NAME = "hdfs_under_replicated_blocks";
    public static final String BLOCK_ID = "block_id";
    public static final String INODE_ID = "inode_id";
    public static final String LEVEL = "level";
    public static final String TIMESTAMP = "timestamp";
  }

  public static interface VariableTableDef {

    public static final String TABLE_NAME = "hdfs_variables";
    public static final String ID = "id";
    public static final String VARIABLE_VALUE = "value";
    public static final Integer MAX_VARIABLE_SIZE = 500;
  }

  public static interface MetadataLogTableDef {

    public static final String TABLE_NAME = "hdfs_metadata_log";
    public static final String LOOKUP_TABLE_NAME = "hdfs_inode_dataset_lookup";
    public static final String DATASET_ID = "dataset_id";
    public static final String INODE_ID = "inode_id";
    public static final String TIMESTAMP = "timestamp";
    public static final String INODE_PID = "inode_pid";
    public static final String INODE_NAME = "inode_name";
    public static final String OPERATION = "operation";
  }

  public static interface AccessTimeLogTableDef {

    public static final String TABLE_NAME = "hdfs_access_log";
    public static final String INODE_ID = "inode_id";
    public static final String USER_ID = "user_id";
    public static final String ACCESS_TIME = "access_time";
  }

  public static interface SizeLogTableDef {

    public static final String TABLE_NAME = "hdfs_size_log";
    public static final String INODE_ID = "inode_id";
    public static final String SIZE = "size";
  }

  public static interface EncodingJobsTableDef {

    public static final String TABLE_NAME = "hdfs_encoding_jobs";
    public static final String JT_IDENTIFIER = "jt_identifier";
    public static final String JOB_ID = "job_id";
    public static final String PATH = "path";
    public static final String JOB_DIR = "job_dir";
  }

  public static interface RepairJobsTableDef {

    public static final String TABLE_NAME = "hdfs_repair_jobs";
    public static final String JT_IDENTIFIER = "jt_identifier";
    public static final String JOB_ID = "job_id";
    public static final String PATH = "path";
    public static final String IN_DIR = "in_dir";
    public static final String OUT_DIR = "out_dir";
  }

  public static interface OnGoingSubTreeOpsDef {

    public static final String TABLE_NAME = "hdfs_on_going_sub_tree_ops";
    public static final String PATH = "path";
    public static final String NAME_NODE_ID = "namenode_id";
    public static final String OP_NAME = "op_name";
    public static final int LIMIT = 5;
  } 
}
