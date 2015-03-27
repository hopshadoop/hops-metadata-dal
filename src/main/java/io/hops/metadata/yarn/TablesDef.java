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
package io.hops.metadata.yarn;

public class TablesDef {
  public static interface AppSchedulingInfoBlacklistTableDef {
    public static final String TABLE_NAME = "yarn_appschedulinginfo_blacklist";
    public static final String APPSCHEDULINGINFO_ID = "applicationattemptid";
    public static final String BLACKLISTED = "blacklisted";
  }

  public static interface AppSchedulingInfoTableDef {
    public static final String TABLE_NAME = "yarn_appschedulinginfo";
    public static final String SCHEDULERAPP_ID = "applicationattemptid";
    public static final String APPID = "appid";
    public static final String QUEUENAME = "queuename";
    public static final String USER = "user";
    public static final String CONTAINERIDCOUNTER = "containeridcounter";
    public static final String PENDING = "pending";
    public static final String STOPED = "stoped";
  }

  public static interface ContainerIdToCleanTableDef {

    public static final String TABLE_NAME = "yarn_containerid_toclean";
    public static final String CONTAINERID = "containerid";
    public static final String RMNODEID = "rmnodeid";
  }

  public static interface ContainerStatusTableDef {

    public static final String TABLE_NAME = "yarn_containerstatus";
    public static final String CONTAINERID = "containerid";
    public static final String STATE = "state";
    public static final String DIAGNOSTICS = "diagnostics";
    public static final String EXIT_STATUS = "exitstatus";
    public static final String RMNODEID = "rmnodeid";
    //State values
    public static final String STATE_RUNNING = "RUNNING";
    public static final String STATE_COMPLETED = "COMPLETE";
  }

  public static interface ContainerTableDef {

    public static final String TABLE_NAME = "yarn_container";
    public static final String CONTAINERID_ID = "containerid_id";
    public static final String CONTAINERSTATE = "containerstate";
  }

  public static interface FiCaSchedulerAppLiveContainersTableDef {
    public static final String TABLE_NAME = "yarn_schedulerapp_livecontainers";
    public static final String SCHEDULERAPP_ID = "applicationattemptid";
    public static final String RMCONTAINER_ID = "rmcontainer_id";
  }

  public static interface FiCaSchedulerAppNewlyAllocatedContainersTableDef {
    public static final String TABLE_NAME =
        "yarn_schedulerapp_newlyallocatedcontainers";
    public static final String SCHEDULERAPP_ID = "applicationattemptid";
    public static final String RMCONTAINER_ID = "rmcontainer_id";
  }

  public static interface FiCaSchedulerNodeTableDef {

    public static final String TABLE_NAME = "yarn_ficascheduler_node";
    public static final String NUMCONTAINERS = "numcontainers";
    public static final String RMNODEID = "rmnodeid";
    public static final String NODENAME = "nodename";
  }

  public static interface FifoSchedulerAppsTableDef {
    public static final String TABLE_NAME = "yarn_fifoscheduler_apps";
    public static final String APPID = "appid";
    public static final String SCHEDULERAPPLICATION_ID =
        "schedulerapplication_id";
  }

  public static interface FinishedApplicationsTableDef {

    public static final String TABLE_NAME = "yarn_rmnode_finishedapplications";
    public static final String RMNODEID = "rmnodeid";
    public static final String APPLICATIONID = "applicationid";
  }

  public static interface JustLaunchedContainersTableDef {

    public static final String TABLE_NAME = "yarn_justlaunchedcontainers";
    public static final String CONTAINERID = "containerid_id";
    public static final String RMNODEID = "rmnodeid";
  }

  public static interface LaunchedContainersTableDef {

    public static final String TABLE_NAME = "yarn_launchedcontainers";
    public static final String SCHEDULERNODE_ID = "rmnodeid";
    public static final String CONTAINERID_ID = "containerid_id";
    public static final String RMCONTAINER_ID = "rmcontainer_id";
  }

  /**
   * Defines table structure for SchedulerEvents persisted by the
   * Distributed ResourceTrackerService.
   */
  public static interface NextHeartbeatTableDef {

    public static final String TABLE_NAME = "yarn_nextheartbeat";
    public static final String RMNODEID = "rmnodeid";
    public static final String NEXTHEARTBEAT = "nextheartbeat";

    //Field that denotes the integer value of the nextheartbeat field if is true
    public static final int NEXTHEARTBEAT_TRUE = 1;
    public static final int NEXTHEARTBEAT_FALSE = 0;
  }

  public static interface NodeHBResponseTableDef {

    public static final String TABLE_NAME = "yarn_latestnodehbresponse";
    public static final String RMNODEID = "rmnodeid";
    public static final String RESPONSE = "response";
  }

  /**
   * Defines table structure for hayarn_node table.
   */
  public static interface NodeTableDef {
    public static final String TABLE_NAME = "yarn_node";
    public static final String NODEID = "nodeid";
    public static final String NAME = "name";
    public static final String LOCATION = "location";
    public static final String LEVEL = "level";
    public static final String PARENT = "parent";
  }

  /**
   * Defines table structure for SchedulerEvents persisted by the
   * Distributed ResourceTrackerService.
   */
  public static interface PendingEventTableDef {

    public static final String TABLE_NAME = "yarn_pendingevents";
    public static final String RMNODEID = "rmnodeid";
    public static final String TYPE = "type";
    public static final String STATUS = "status";
    public static final String ID = "id";

    //Event Type
    public static final byte NODE_ADDED = 1;
    public static final byte NODE_REMOVED = 2;
    public static final byte NODE_UPDATED = 3;

    //Event status
    public static final byte NEW = 1;
    public static final byte PENDING = 2;
    public static final byte COMPLETED = 3;

    //Event transactionstate action
    public static final int PERSISTEDEVENT_ADD = 1;
    public static final int PERSISTEDEVENT_REMOVE = 2;
  }

  public static interface QueueMetricsTableDef {
    public static final String TABLE_NAME = "yarn_queuemetrics";
    public static final String ID = "id";
    public static final String APPS_SUBMITTED = "apps_submitted";
    public static final String APPS_RUNNING = "apps_running";
    public static final String APPS_PENDING = "apps_pending";
    public static final String APPS_COMPLETED = "apps_completed";
    public static final String APPS_KILLED = "apps_killed";
    public static final String APPS_FAILED = "apps_failed";
    public static final String ALLOCATED_MB = "allocated_mb";
    public static final String ALLOCATED_VCORES = "allocated_vcores";
    public static final String ALLOCATED_CONTAINERS = "allocated_containers";
    public static final String AGGREGATE_CONTAINERS_ALLOCATED =
        "aggregate_containers_allocated";
    public static final String AGGREGATE_CONTAINERS_RELEASED =
        "aggregate_containers_released";
    public static final String AVAILABLE_MB = "available_mb";
    public static final String AVAILABLE_VCORES = "available_vcores";
    public static final String PENDING_CONTAINERS = "pending_containers";
    public static final String PENDING_MB = "pending_mb";
    public static final String PENDING_VCORES = "pending_vcores";
    public static final String RESERVED_MB = "reserved_mb";
    public static final String RESERVED_VCORES = "reserved_vcores";
    public static final String RESERVED_CONTAINERS = "reserved_containers";
    public static final String ACTIVE_USERS = "active_users";
    public static final String ACTIVE_APPLICATIONS = "active_applications";
    public static final String PARENT_ID = "parent_id";
    public static final String QUEUE_NAME = "queue_name";

  }

  public static interface ResourceRequestTableDef {
    public static final String TABLE_NAME = "yarn_resourcerequest";
    public static final String APPSCHEDULINGINFO_ID = "applicationattemptid";
    public static final String PRIORITY = "priority";
    public static final String NAME = "name";
    public static final String RESOURCEREQUESTSTATE = "resourcerequeststate";
  }

  public static interface ResourceTableDef {

    public static final String TABLE_NAME = "yarn_resource";
    public static final String ID = "id";
    public static final String TYPE = "type";
    public static final String PARENT = "parent";
    public static final String MEMORY = "memory";
    public static final String VIRTUAL_CORES = "virtualcores";
  }

  public static interface RMContainerTableDef {

    public static final String TABLE_NAME = "yarn_rmcontainer";
    public static final String CONTAINERID_ID = "containerid_id";
    public static final String APPLICATIONATTEMPTID_ID = "appattemptid_id";
    public static final String NODEID_ID = "nodeid_id";
    public static final String USER = "user";
    //  public static final String RESERVED_NODEID_ID = "reservednodeid_id";
    //  public static final String RESERVED_PRIORITY_ID = "reservedpriority_id";
    public static final String STARTTIME = "starttime";
    public static final String FINISHTIME = "finishtime";
    public static final String STATE = "state";
    public static final String FINISHEDSTATUSSTATE = "finishedstatusstate";
    public static final String EXITSTATUS = "exitstatus";
  }

  public static interface RMContextActiveNodesTableDef {

    public static final String TABLE_NAME = "yarn_rmctx_activenodes";
    public static final String RMNODEID = "rmnodeid";
  }

  public static interface RMContextInactiveNodesTableDef {

    public static final String TABLE_NAME = "yarn_rmctx_inactivenodes";
    public static final String RMNODEID = "rmnodeid";
  }

  public static interface RMLoadTableDef {
    public static final String TABLE_NAME = "yarn_rms_load";
    public static final String RMHOSTNAME = "rmhostname";
    public static final String LOAD = "load";
  }

  /**
   * Defines table structure for RMNodeImpl class.
   */
  public static interface RMNodeTableDef {

    public static final String TABLE_NAME = "yarn_rmnode";
    public static final String NODEID = "rmnodeid";
    public static final String HOST_NAME = "hostname";
    public static final String COMMAND_PORT = "commandport";
    public static final String HTTP_PORT = "httpport";
    public static final String NODE_ADDRESS = "nodeaddress";
    public static final String HTTP_ADDRESS = "httpaddress";
    public static final String NEXT_HEARTBEAT = "nextheartbeat";
    public static final String RESOURCE_ID = "resourceid";
    public static final String HEALTH_REPORT = "healthreport";
    public static final String RMCONTEXT_ID = "rmcontextid";
    public static final String LAST_HEALTH_REPORT_TIME = "lasthealthreporttime";
    public static final String NODEHBRESPONSE_ID = "lastnodehbresponse_id";
    public static final String CURRENT_STATE = "currentstate";
    public static final String OVERCOMMIT_TIMEOUT = "overcommittimeout";
    public static final String NODEMANAGER_VERSION = "nodemanager_version";
    public static final String UCI_ID = "uci_id";
  }

  public static interface SchedulerApplicationTableDef {
    public static final String TABLE_NAME = "yarn_schedulerapplication";
    public static final String APPID = "appid";
    public static final String USER = "user";
    public static final String QUEUENAME = "queuename";
  }

  public static interface UpdatedContainerInfoTableDef {

    public static final String TABLE_NAME = "yarn_updatedcontainerinfo";
    public static final String CONTAINERID = "containerid";
    public static final String RMNODEID = "rmnodeid";
    public static final String UPDATEDCONTAINERINFOID = "updatedcontainerinfoid";
  }

  public static interface YarnVariablesTableDef {

    public static final String TABLE_NAME = "yarn_variables";
    public static final String ID = "id";
    public static final String VALUE = "value";

    //Used in previous implementation with single row in table.
    public static final String LAST_UPDATEDCONTAINERINFO_ID =
        "last_updatedcontainerinfo_id";
    public static final String LAST_NODEID_ID = "last_nodeid_id";
    public static final String LAST_NODE_ID = "last_node_id";
    public static final String LAST_RESOURCE_ID = "last_resource_id";
    public static final String LAST_LIST_ID = "last_list_id";
    public static final String LAST_NODEHBRESPONSE_ID = "last_nodehbresponse_id";
    public static final String LAST_RMCONTEXT_ID = "last_rmcontext_id";
    public static final String LAST_CONTAINERSTATUS_ID =
        "last_containerstatus_id";
    public static final String LAST_CONTAINERID_ID = "last_containerid_id";
    public static final String LAST_APPATTEMPTID_ID = "last_appattemptid_id";
    public static final String LAST_APPLICATIONID_ID = "last_applicationid_id";
    public static final int idVal = 0;
  }

  /*
    AppMasterRPC
   */

  public static interface RPCTableDef {

    public static final String TABLE_NAME = "yarn_appmaster_rpc";
    public static final String ID = "id";
    public static final String TYPE = "type";
    public static final String RPC = "rpc";
    public static final String USERID = "userid";
  }

  /*
    Capacity
   */

  public static interface FiCaSchedulerAppLastScheduledContainerTableDef {
    public static final String TABLE_NAME =
        "yarn_schedulerapp_lastscheduledcontainer";
    public static final String SCHEDULERAPP_ID = "schedulerapp_id";
    public static final String PRIORITY_ID = "priority_id";
    public static final String TIME = "time";
  }

  public static interface FiCaSchedulerAppReservationsTableDef {
    public static final String TABLE_NAME = "yarn_schedulerapp_reservations";
    public static final String SCHEDULERAPP_ID = "schedulerapp_id";
    public static final String PRIORITY_ID = "priority_id";

  }

  public static interface FiCaSchedulerAppReservedContainersTableDef {
    public static final String TABLE_NAME = "yarn_schedulerapp_reservedcontainers";
    public static final String SCHEDULERAPP_ID = "schedulerapp_id";
    public static final String PRIORITY_ID = "priority_id";
    public static final String NODEID = "nodeid";
    public static final String RMCONTAINER_ID = "rmcontainer_id";
  }

  public static interface FiCaSchedulerAppSchedulingOpportunitiesTableDef {
    public static final String TABLE_NAME =
        "yarn_schedulerapp_schedulingopportunities";
    public static final String SCHEDULERAPP_ID = "schedulerapp_id";
    public static final String PRIORITY_ID = "priority_id";
  }

  /*
    Fair
   */

  public static interface FSSchedulerNodeTableDef {
    public static final String TABLE_NAME = "yarn_fsscheduler_node";
    public static final String RMNODEID = "rmnodeid";
    public static final String NUMCONTAINERS = "numcontainers";
    public static final String RESERVEDCONTAINER_ID = "reservedcontainer_id";
    public static final String RESERVEDAPPSCHEDULABLE_ID =
        "reservedappschedulable_id";
  }

  /*
  RMStateStore
   */

  public static interface AllocateResponseTableDef {
    public static final String TABLE_NAME = "yarn_allocate_response";
    public static final String APPLICATIONATTEMPTID = "applicationattemptid";
    public static final String ALLOCATERESPONSE = "allocate_response";
  }

  public static interface ApplicationAttemptStateTableDef {
    public static final String TABLE_NAME = "yarn_applicationattemptstate";
    public static final String APPLICATIONID = "applicationid";
    public static final String APPLICATIONATTEMPTID = "applicationattemptid";
    public static final String APPLICATIONATTEMPTSTATE =
        "applicationattemptstate";
    public static final String HOST = "applicationattempthost";
    public static final String RPCPORT = "applicationattemptrpcport";
    public static final String TOKENS = "applicationattempttokens";
    public static final String TRAKINGURL = "applicationattempttrakingurl";
  }

  public static interface ApplicationStateTableDef {
    public static final String TABLE_NAME = "yarn_applicationstate";
    public static final String APPLICATIONID = "applicationid";
    public static final String APPSTATE = "appstate";
    public static final String USER = "appuser";
    public static final String NAME = "appname";
    public static final String SMSTATE = "appsmstate";
  }

  public static interface DelegationKeyTableDef {
    public static final String TABLE_NAME = "yarn_delegation_key";
    public static final String KEY = "key";
    public static final String DELEGATIONKEY = "delegationkey";
  }

  public static interface DelegationTokenTableDef {
    public static final String TABLE_NAME = "yarn_delegation_token";
    public static final String SEQ_NUMBER = "seq_number";
    public static final String RMDT_IDENTIFIER = "rmdt_identifier";
  }

  public static interface RMStateVersionTableDef {

    public static final String TABLE_NAME = "yarn_version";
    public static final String ID = "id";
    public static final String VERSION = "version";
  }

  public static interface SecretMamagerKeysTableDef {
    public static final String TABLE_NAME = "yarn_secret_manager_keys";
    public static final String KEYID = "id";
    public static final String KEY = "key";
  }

  public static interface SequenceNumberTableDef {
    public static final String TABLE_NAME = "yarn_sequence_number";
    public static final String ID = "id";
    public static final String SEQUENCE_NUMBER = "sequence_number";
  }
}
