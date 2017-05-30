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

public class Resource implements Comparable<Resource>{

  
  private final String id;
  private int memory;
  private int virtualcores;
  private int gpus;
  private int pendingEventId;
  
  public Resource(String id) {
    this.id = id;
  }
  
  public Resource(String id, int memory,
          int virtualcores, int gpus, int pendingId) {
    this.id = id;
    this.memory = memory;
    this.virtualcores = virtualcores;
    this.pendingEventId = pendingId;
    this.gpus = gpus;
  }
  
  public int getPendingEventId() {
    return pendingEventId;
  }
  
  public String getId() {
    return id;
  }
    
  public int getMemory() {
    return memory;
  }
  
  public int getVirtualCores() {
    return virtualcores;
  }

  public int getGPUs() {
    return gpus;
  }
  
  @Override
  public String toString() {
    return "HopResource{" + "id=" + id + '}';
  }
  
  @Override
  public int compareTo(Resource r){
    if(this.id.compareTo(r.id)!=0){
      return this.id.compareTo(r.id);
    }
    return 0;
  }
  
  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Resource)) {
      return false;
    }
    Resource other = (Resource) obj;
    return (id.equals(other.id));
  }

}
