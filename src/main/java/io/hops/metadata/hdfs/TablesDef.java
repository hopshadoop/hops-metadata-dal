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
  public interface BlockLookUpTableDef {

    String TABLE_NAME = "hdfs_block_lookup_table";
    String BLOCK_ID = "block_id";
    String INODE_ID = "inode_id";
  }

  public interface StoragesTableDef {
    String TABLE_NAME="hdfs_storages";
    String STORAGE_ID="storage_id";
    String HOST_ID="host_id";
    String STORAGE_TYPE="storage_type";
  }
  
  public interface INodeTableDef {
    // INode Table Columns
    String TABLE_NAME = "hdfs_inodes";
    String ID = "id";
    String NAME = "name";
    String PARENT_ID = "parent_id";
    String PARTITION_ID = "partition_id";
    String IS_DIR = "is_dir";
    String MODIFICATION_TIME = "modification_time";
    String ACCESS_TIME = "access_time";
    String USER_ID = "user_id";
    String GROUP_ID = "group_id";
    String PERMISSION = "permission";
    String CLIENT_NAME = "client_name";
    String CLIENT_MACHINE = "client_machine";
    String CLIENT_NODE = "client_node";
    String GENERATION_STAMP = "generation_stamp";
    String HEADER = "header";
    String SYMLINK = "symlink";
    String QUOTA_ENABLED = "quota_enabled";
    String UNDER_CONSTRUCTION = "under_construction";
    String SUBTREE_LOCKED = "subtree_locked";
    String SUBTREE_LOCK_OWNER = "subtree_lock_owner";
    String META_ENABLED = "meta_enabled";
    String SIZE = "size";
    String FILE_STORED_IN_DB = "file_stored_in_db";
    String LOGICAL_TIME = "logical_time";
    String STORAGE_POLICY = "storage_policy";
    String CHILDREN_NUM = "children_num";
  }

  public interface FileInodeInMemoryData {
    String TABLE_NAME = "hdfs_inmemory_file_inode_data";
    String ID = "inode_id";
    String DATA = "data";
  }

  public interface FileInodeSmallDiskData {
    String TABLE_NAME = "hdfs_ondisk_small_file_inode_data";
    String ID = "inode_id";
    String DATA = "data";
  }

  public interface FileInodeMediumlDiskData {
    String TABLE_NAME = "hdfs_ondisk_medium_file_inode_data";
    String ID = "inode_id";
    String DATA = "data";
  }

  public interface FileInodeLargeDiskData {
    String TABLE_NAME = "hdfs_ondisk_large_file_inode_data";
    String ID = "inode_id";
    String INDEX = "dindex";
    String DATA = "data";
  }

  public interface UsersTableDef {
    String TABLE_NAME = "hdfs_users";
    String ID = "id";
    String NAME = "name";
  }

  public interface GroupsTableDef {
    String TABLE_NAME = "hdfs_groups";
    String ID = "id";
    String NAME = "name";
  }

  public interface UsersGroupsTableDef {
    String TABLE_NAME = "hdfs_users_groups";
    String USER_ID = "user_id";
    String GROUP_ID = "group_id";
  }

  public interface BlockChecksumTableDef {
    String TABLE_NAME = "hdfs_block_checksum";

    String INODE_ID = "inode_id";
    String BLOCK_INDEX = "block_index";
    String CHECKSUM = "checksum";
  }

  public interface CorruptReplicaTableDef {

    String TABLE_NAME = "hdfs_corrupt_replicas";
    String BLOCK_ID = "block_id";
    String INODE_ID = "inode_id";
    String STORAGE_ID = "storage_id";
    String TIMESTAMP = "timestamp";
  }

  public interface INodeAttributesTableDef {

    String TABLE_NAME = "hdfs_inode_attributes";
    String ID = "inodeId";
    String NSQUOTA = "nsquota";
    String DSQUOTA = "dsquota";
    String NSCOUNT = "nscount";
    String DISKSPACE = "diskspace";
  }

  public interface ExcessReplicaTableDef {

    String TABLE_NAME = "hdfs_excess_replicas";
    String BLOCK_ID = "block_id";
    String INODE_ID = "inode_id";
    String PART_KEY = "part_key";
    String STORAGE_ID = "storage_id";
    String STORAGE_IDX = "storage_idx";
  }

  public interface BlockInfoTableDef {

    String TABLE_NAME = "hdfs_block_infos";
    String BLOCK_ID = "block_id";
    String BLOCK_INDEX = "block_index";
    String INODE_ID = "inode_id";
    String NUM_BYTES = "num_bytes";
    String GENERATION_STAMP = "generation_stamp";
    String BLOCK_UNDER_CONSTRUCTION_STATE =
        "block_under_construction_state";
    String TIME_STAMP = "time_stamp";
    String PRIMARY_NODE_INDEX = "primary_node_index";
    String BLOCK_RECOVERY_ID = "block_recovery_id";
  }

  public interface EncodingStatusTableDef {
    String TABLE_NAME = "hdfs_encoding_status";

    // Erasure coding table columns
    String INODE_ID = "inode_id";
    String PARITY_INODE_ID = "parity_inode_id";
    String STATUS = "status";
    String PARITY_STATUS = "parity_status";
    String CODEC = "codec";
    String TARGET_REPLICATION = "target_replication";
    String STATUS_MODIFICATION_TIME =
        "status_modification_time";
    String PARITY_STATUS_MODIFICATION_TIME =
        "parity_status_modification_time";
    String PARITY_FILE_NAME = "parity_file_name";
    String LOST_BLOCKS = "lost_blocks";
    String LOST_PARITY_BLOCKS = "lost_parity_blocks";
    String LOST_BLOCK_SUM = "lost_block_sum";
    String REVOKED = "revoked";
  }

  public interface LeaseTableDef {
    String TABLE_NAME = "hdfs_leases";
    String HOLDER = "holder";
    String LAST_UPDATE = "last_update";
    String HOLDER_ID = "holder_id";
  }

  public interface LeasePathTableDef {
    String TABLE_NAME = "hdfs_lease_paths";
    String HOLDER_ID = "holder_id";
    String PATH = "path";
    String LAST_BLOCK_ID = "last_block_id";
    String PENULTIMATE_BLOCK_ID = "penultimate_block_id";
  }

  public interface InvalidatedBlockTableDef {

    String TABLE_NAME = "hdfs_invalidated_blocks";
    String BLOCK_ID = "block_id";
    String STORAGE_ID = "storage_id";
    String STORAGE_IDX = "storage_idx";
    String INODE_ID = "inode_id";
    String GENERATION_STAMP = "generation_stamp";
    String NUM_BYTES = "num_bytes";
  }

  public interface MisReplicatedRangeQueueTableDef {

    String TABLE_NAME = "hdfs_misreplicated_range_queue";
    String RANGE = "range";
  }

  public interface PendingBlockTableDef {

    String TABLE_NAME = "hdfs_pending_blocks";
    String BLOCK_ID = "block_id";
    String INODE_ID = "inode_id";
    String TIME_STAMP = "time_stamp";
    String NUM_REPLICAS_IN_PROGRESS =
        "num_replicas_in_progress";
  }

  public interface ReplicaTableDef {

    String TABLE_NAME = "hdfs_replicas";
    String BLOCK_ID = "block_id";
    String STORAGE_ID = "storage_id";
    String INODE_ID = "inode_id";
    String REPLICA_INDEX = "replica_index";
    String HASH_BUCKET = "bucket_id";
  }

  public interface QuotaUpdateTableDef {

    String TABLE_NAME = "hdfs_quota_update";
    String ID = "id";
    String INODE_ID = "inode_id";
    String NAMESPACE_DELTA = "namespace_delta";
    String DISKSPACE_DELTA = "diskspace_delta";
  }

  public interface ReplicaUnderConstructionTableDef {

    String TABLE_NAME = "hdfs_replica_under_constructions";
    String BLOCK_ID = "block_id";
    String STORAGE_ID = "storage_id";
    String INODE_ID = "inode_id";
    String STATE = "state";
    String REPLICA_INDEX = "replica_index";
    String HASH_BUCKET = "bucket_id";
    String CHOSEN_AS_PRIMARY = "chosen_as_primary";
  }

  public interface SafeBlocksTableDef {

    String TABLE_NAME = "hdfs_safe_blocks";
    String ID = "id";
  }

  public interface StorageIdMapTableDef {
    String TABLE_NAME = "hdfs_storage_id_map";
    String STORAGE_ID = "storage_id";
    String SID = "sid";
  }

  public interface UnderReplicatedBlockTableDef {

    String TABLE_NAME = "hdfs_under_replicated_blocks";
    String BLOCK_ID = "block_id";
    String INODE_ID = "inode_id";
    String LEVEL = "level";
    String TIMESTAMP = "timestamp";
  }

  public interface VariableTableDef {

    String TABLE_NAME = "hdfs_variables";
    String ID = "id";
    String VARIABLE_VALUE = "value";
    Integer MAX_VARIABLE_SIZE = 500;
  }

  public interface MetadataLogTableDef {

    String TABLE_NAME = "hdfs_metadata_log";
    String LOOKUP_TABLE_NAME = "hdfs_inode_dataset_lookup";
    String DATASET_ID = "dataset_id";
    String INODE_ID = "inode_id";
    String Logical_TIME = "logical_time";
    String INODE_PARTITION_ID = "inode_partition_id";
    String INODE_PARENT_ID = "inode_parent_id";
    String INODE_NAME = "inode_name";
    String OPERATION = "operation";
  }


  public interface EncodingJobsTableDef {
    String TABLE_NAME = "hdfs_encoding_jobs";
    String JT_IDENTIFIER = "jt_identifier";
    String JOB_ID = "job_id";
    String PATH = "path";
    String JOB_DIR = "job_dir";
  }
  public interface RepairJobsTableDef {
    String TABLE_NAME = "hdfs_repair_jobs";
    String JT_IDENTIFIER = "jt_identifier";
    String JOB_ID = "job_id";
    String PATH = "path";
    String IN_DIR = "in_dir";
    String OUT_DIR = "out_dir";
  }
  
  public interface OnGoingSubTreeOpsDef {
    String TABLE_NAME = "hdfs_on_going_sub_tree_ops";
    String PATH = "path";
    String NAME_NODE_ID = "namenode_id";
    String OP_NAME = "op_name";
    String PARTITION_ID = "partition_id";
    int LIMIT = 2;
  }

  public interface HashBucketsTableDef {
    String TABLE_NAME = "hdfs_hash_buckets";
    String BUCKET_ID = "bucket_id";
    String STORAGE_ID = "storage_id";
    String HASH = "hash";
  }
}
