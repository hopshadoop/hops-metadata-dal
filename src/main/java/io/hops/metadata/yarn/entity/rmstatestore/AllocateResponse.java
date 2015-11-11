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
package io.hops.metadata.yarn.entity.rmstatestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllocateResponse implements Comparable<AllocateResponse>{

  private final String applicationattemptid;
  private final Integer responseId;
  private final byte[] allocateResponse;
  private final List<String> allocatedContainers;
  private final Map<String, byte[]> completedContainerStatus;
  
  public AllocateResponse(String applicationattemptid,
      byte[] allocateResponse, List<String> allocatedContainers,
      int responseId, Map<String, byte[]> completedContainersStatus) {
    this.applicationattemptid = applicationattemptid;
    this.allocateResponse = allocateResponse;
    this.responseId = responseId;
    if(allocatedContainers!=null){
      this.allocatedContainers = allocatedContainers;
    }else{
      this.allocatedContainers = new ArrayList<String>();
    }
    this.completedContainerStatus = completedContainersStatus;
  }

  public AllocateResponse(String applicationattemptid,  byte[] allocateResponse,
          int responseId) {
    this(applicationattemptid, allocateResponse, null, responseId, null);
  }
    
  public AllocateResponse(String applicationattemptid, int responseId) {
    this(applicationattemptid, null, null, responseId, null);
  }
  
  public String getApplicationattemptid() {
    return applicationattemptid;
  }

  public byte[] getAllocateResponse() {
    return allocateResponse;
  }

  public List<String> getAllocatedContainers() {
    return allocatedContainers;
  }

  public Map<String, byte[]> getCompletedContainersStatus(){
    return completedContainerStatus;
  }
  
  public int getResponseId() {
    return responseId;
  }
  
  public int compareTo(AllocateResponse a){
    if(applicationattemptid.compareTo(a.applicationattemptid)!=0){
      return applicationattemptid.compareTo(a.applicationattemptid);
    }
    if(responseId.compareTo(a.responseId)!=0){
      return responseId.compareTo(a.responseId);
    }
    return 0;
  }

  @Override
  public int hashCode() {
    return applicationattemptid.hashCode() + 100 * responseId.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AllocateResponse)) {
      return false;
    }
    AllocateResponse other = (AllocateResponse) obj;
    return (applicationattemptid.equals(other.applicationattemptid)
            && responseId.equals(other.responseId));
  }
}
