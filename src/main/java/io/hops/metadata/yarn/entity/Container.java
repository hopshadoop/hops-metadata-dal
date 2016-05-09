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

public class Container implements Comparable<Container>{

  private final String containerId;
  private final byte[] containerstate;

  public Container(String containerId) {
    this.containerId = containerId;
    this.containerstate = null;
  }
  
  public Container(String containerId, byte[] containerstate) {
    this.containerId = containerId;
    this.containerstate = containerstate;
  }

  public String getContainerId() {
    return containerId;
  }

  public byte[] getContainerState() {
    return containerstate;
  }
  
  public int compareTo(Container c){
    return containerId.compareTo(c.containerId);
  }

  @Override
  public int hashCode() {

    return containerId.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Container)) {
      return false;
    }
    Container other = (Container) obj;
    return containerId.equals(other.containerId);
  }
}
