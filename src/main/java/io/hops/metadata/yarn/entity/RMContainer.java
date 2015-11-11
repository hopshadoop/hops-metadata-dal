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
package io.hops.metadata.yarn.entity;

import com.google.common.base.Splitter;
import java.util.Iterator;

/**
 * Pojo representing RMContainer class.
 */
public class RMContainer {

  private final String containerIdID;
  private final String applicationAttemptIdID;
  private final String nodeIdID;
  private final String user;
  private final String reservedNodeIdID;
  private final int reservedPriorityID;
  private final int reservedMemory;
  private final int reservedVCores;
  private final long starttime;
  private final long finishtime;
  private final String state;
  private final String finishedStatusState;
  private final int exitStatus;

  public RMContainer(String containerIdID){
    this(containerIdID, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0);
  }
  
  public RMContainer(String containerIdID, String applicationAttemptIdID, 
      String nodeIdID, String user, String reservedNodeIdID, 
      int reservedPriorityID, int reservedMemory, int reservedVCores, 
      long starttime, long finishtime, String state,
      String finishedStatusState, Integer exitStatus) {
    this.containerIdID = containerIdID;
    this.applicationAttemptIdID = applicationAttemptIdID;
    this.nodeIdID = nodeIdID;
    this.user = user;
    this.reservedNodeIdID = reservedNodeIdID;
    this.reservedPriorityID = reservedPriorityID;
    this.reservedMemory = reservedMemory;
    this.reservedVCores = reservedVCores;
    this.starttime = starttime;
    this.finishtime = finishtime;
    this.state = state;
    this.finishedStatusState = finishedStatusState;
    this.exitStatus = exitStatus;
  }

  public String getContainerIdID() {
    return containerIdID;
  }

  public String getApplicationAttemptIdID() {
    return applicationAttemptIdID;
  }

  public String getNodeIdID() {
    return nodeIdID;
  }

  public String getUser() {
    return user;
  }

  public String getReservedNodeIdID() {
    return reservedNodeIdID;
  }

  public String getReservedNodeHost() {
    Iterator<String> it = Splitter.on(':').trimResults().split(reservedNodeIdID).iterator();
    it.next();
    return(it.next());
  }

  public int getReservedNodePort(){
    Iterator<String> it = Splitter.on(':').trimResults().split(reservedNodeIdID).iterator();
    it.next();
    it.next();
    return new Integer(it.next());
  }
    
  public int getReservedPriorityID() {
    return reservedPriorityID;
  }
    
  public int getReservedMemory() {
    return reservedMemory;
  }
    
  public int getReservedVCores() {
    return reservedVCores;
  }

  public long getStarttime() {
    return starttime;
  }

  public long getFinishtime() {
    return finishtime;
  }

  public String getState() {
    return state;
  }

  public String getFinishedStatusState() {
    return finishedStatusState;
  }

  public int getExitStatus() {
    return exitStatus;
  }

}
