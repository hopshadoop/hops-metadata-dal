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

public class ResourceRequest implements Comparable<ResourceRequest> {
  private final String id;
  private final int priority;
  private final String name;
  private final byte[] resourcerequeststate;
  private final String containerId;
 
  public ResourceRequest(String id, int priority, String name,
      byte[] resourcerequeststate) {
    this.id = id;
    this.priority = priority;
    this.name = name;
    this.resourcerequeststate = resourcerequeststate; 
    this.containerId=null;
  }
  
  public ResourceRequest( String containerId, String name,
      byte[] resourcerequeststate) {
    this.id = null;
    this.priority = 0;
    this.name = name;
    this.resourcerequeststate = resourcerequeststate;
    this.containerId=containerId;
  }

  public String getId() {
    return id;
  }

  public int getPriority() {
    return priority;
  }

  public String getName() {
    return name;
  }

  public byte[] getResourcerequeststate() {
    return resourcerequeststate;
  }
  
  public String getContainerId() {
        return containerId;
  }

  @Override
  public int hashCode() {
      int hashValue=100 * priority + 200 * name.hashCode();
      if(!(containerId == null)){
          hashValue+=300*containerId.hashCode();
      }
      if(!(id == null)){
          hashValue+=id.hashCode();
      }
      return hashValue;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ResourceRequest)) {
      return false;
    }
    ResourceRequest other = (ResourceRequest) obj;
    boolean isEqual= priority == other.priority
                && name.equals(other.name);  
    if(!(id ==  null)){
        isEqual=isEqual && id.equals(other.id);
    } else if (other.id!=null ) {
        return false;
    }
    if(!(containerId ==null)){
        isEqual = isEqual && containerId.equals(other.getContainerId());
    }else if(other.containerId !=null){
        return false;
    }
    return isEqual;
  }

  @Override
  public int compareTo(ResourceRequest other) {
      if (other == null) return 1;
      
      if(id==null && !(other.id==null)){
        return 1;
      }
      if(!(id==null) && other.id==null){
        return -1; 
      }
      if (!(id==null || other.id == null) && id.compareTo(other.id) != 0) {
        return id.compareTo(other.id);
      }
      if (priority != other.priority) {
        return priority - other.priority;
      }
      if(containerId==null && !(other.containerId==null)){
        return 1;
      }
      if(!(containerId==null) && other.containerId==null){
        return -1; 
      }
      
     if(!(containerId==null || other.containerId ==null) 
            && containerId.compareTo(other.containerId)!=0){
        return containerId.compareTo(other.containerId);
    }
    
    return name.compareTo(other.name);
    
  } 
}
