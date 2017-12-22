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
  public static interface ContainerIdToCleanTableDef {

    public static final String TABLE_NAME = "yarn_containerid_toclean";
    public static final String CONTAINERID = "containerid";
    public static final String RMNODEID = "rmnodeid";
  }

  public static interface ContainerToSignalTableDef {

    public static final String TABLE_NAME = "yarn_container_to_signal";
    public static final String CONTAINERID = "containerid";
    public static final String RMNODEID = "rmnodeid";
    public static final String COMMAND = "command";
  }
  
  public static interface ContainerToDecreaseTableDef {

    public static final String TABLE_NAME = "yarn_container_to_decrease";
    public static final String CONTAINERID = "containerid";
    public static final String RMNODEID = "rmnodeid";
    public static final String HTTPADDRESS = "http_address";
    public static final String PRIORITY = "priority";
    public static final String MEMSIZE = "memory_size";
    public static final String VIRTUALCORES = "virtual_cores";
    public static final String GPUS = "gpus";
    public static final String VERSION = "version";
  }
  
  public static interface ContainerStatusTableDef {

    public static final String TABLE_NAME = "yarn_containerstatus";
    public static final String CONTAINERID = "containerid";
    public static final String STATE = "state";
    public static final String DIAGNOSTICS = "diagnostics";
    public static final String EXIT_STATUS = "exitstatus";
    public static final String PENDING_EVENT_ID = "pendingeventid";
    public static final String RMNODEID = "rmnodeid";
    public static final String TYPE = "type";
    public static final String UCI_ID = "uciid";
    //State values
    public static final String STATE_RUNNING = "RUNNING";
    public static final String STATE_COMPLETED = "COMPLETE";
  }

  public static interface FinishedApplicationsTableDef {

    public static final String TABLE_NAME = "yarn_rmnode_applications";
    public static final String RMNODEID = "rmnodeid";
    public static final String APPLICATIONID = "applicationid";
    public static final String STATUS = "status";
  }

  public static interface NextHeartbeatTableDef {

    public static final String TABLE_NAME = "yarn_nextheartbeat";
    public static final String RMNODEID = "rmnodeid";
    public static final String NEXTHEARTBEAT = "nextheartbeat";

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
    public static final String CONTAINS = "contains";
  }

  public static interface ResourceTableDef {

    public static final String TABLE_NAME = "yarn_resource";
    public static final String ID = "id";
    public static final String MEMORY = "memory";
    public static final String VIRTUAL_CORES = "virtualcores";
    public static final String GPUS = "gpus";
    public static final String PENDING_EVENT_ID = "pendingeventid";
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
    public static final String NEXT_HEARTBEAT = "nextheartbeat";
    public static final String RESOURCE_ID = "resourceid";
    public static final String HEALTH_REPORT = "healthreport";
    public static final String RMCONTEXT_ID = "rmcontextid";
    public static final String LAST_HEALTH_REPORT_TIME = "lasthealthreporttime";
    public static final String NODEHBRESPONSE_ID = "lastnodehbresponse_id";
    public static final String CURRENT_STATE = "currentstate";
    public static final String NODEMANAGER_VERSION = "nodemanager_version";
    public static final String PENDING_EVENT_ID = "pendingeventid";
  }

  public static interface UpdatedContainerInfoTableDef {

    public static final String TABLE_NAME = "yarn_updatedcontainerinfo";
    public static final String CONTAINERID = "containerid";
    public static final String RMNODEID = "rmnodeid";
    public static final String UPDATEDCONTAINERINFOID = "updatedcontainerinfoid";
    public static final String PENDING_EVENT_ID = "pendingeventid";
  }
  
  public static interface ApplicationAttemptStateTableDef {
    public static final String TABLE_NAME = "yarn_applicationattemptstate";
    public static final String APPLICATIONID = "applicationid";
    public static final String APPLICATIONATTEMPTID = "applicationattemptid";
    public static final String APPLICATIONATTEMPTSTATE =
        "applicationattemptstate";
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

  public static interface ProjectQuotaTableDef {

    public static final String TABLE_NAME = "yarn_projects_quota";
    public static final String PROJECTID = "projectname";
    public static final String REMAINING_QUOTA = "quota_remaining";
    public static final String TOTAL_USED_QUOTA = "total";
  }

  public static interface ContainersLogsTableDef {

    public static final String TABLE_NAME = "yarn_containers_logs";
    public static final String CONTAINERID = "container_id";
    public static final String START = "start";
    public static final String STOP = "stop";
    public static final String EXITSTATUS = "exit_status";
    public static final String PRICE = "price";
    public static final String GPUS = "gpus";
    public static final String VCORES = "vcores";
    public static final String MB = "mb";
  }

  public static interface ContainersCheckPointsTableDef {

    public static final String TABLE_NAME = "yarn_containers_checkpoint";
    public static final String CONTAINERID = "container_id";
    public static final String CHECKPOINT = "checkpoint";
    public static final String MULTIPLICATOR = "multiplicator";
  }

  public static interface ProjectsDailyCostTableDef {

    public static final String TABLE_NAME = "yarn_projects_daily_cost";
    public static final String PROJECTNAME = "projectname";
    public static final String USER = "user";
    public static final String DAY = "day";
    public static final String CREDITS_USED = "credits_used";
    public static final String APP_IDS = "app_ids";
  }

  public static interface PriceMultiplicatorTableDef {

    public static final String TABLE_NAME = "yarn_price_multiplicator";
    public static final String ID = "id";
    public static final String MULTIPLICATOR = "multiplicator";
  }
  
   public static interface ReservationStateTableDef {

    public static final String TABLE_NAME = "yarn_reservation_state";
    public static final String PLANNAME = "plan_name";
    public static final String RESERVATIONIDNAME = "reservation_id_name";
    public static final String RESERVATIONSTATE = "state";
  }
}
