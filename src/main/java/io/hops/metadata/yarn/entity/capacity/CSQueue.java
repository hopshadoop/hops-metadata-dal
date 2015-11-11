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
package io.hops.metadata.yarn.entity.capacity;

public class CSQueue {

  private final String name;
  private final String path;
  private final float usedCapacity;
  private final float absoluteUsedCapacity;
  private final int usedResourceMemory;
  private final int usedResourceVCores;
  private final boolean isParent;
  private final int numContainers;

  public CSQueue(String name, String path, float usedcapacity,
          int usedresourcememory, int usedresourcevcores,
          float absoluteusedcapacity,
          boolean isparent, int numcontainers) {
    this.name = name;
    this.path = path;
    this.usedCapacity = usedcapacity;
    this.usedResourceMemory = usedresourcememory;
    this.usedResourceVCores = usedresourcevcores;
    this.absoluteUsedCapacity = absoluteusedcapacity;
    this.isParent = isparent;
    this.numContainers = numcontainers;
  }

  public String getName() {
    return name;
  }

  public String getPath() {
    return path;
  }

  public float getUsedCapacity() {
    return usedCapacity;
  }

  public int getUsedResourceMemory() {
    return usedResourceMemory;
  }

  public int getUsedResourceVCores() {
    return usedResourceVCores;
  }

  public float getAbsoluteUsedCapacity() {
    return absoluteUsedCapacity;
  }

  public boolean isParent() {
    return isParent;
  }

  public int getNumContainers() {
    return numContainers;
  }

}
