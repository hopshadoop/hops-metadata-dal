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

public class Resource {

  /**
   * Used in resource primary key, to know by which class the particular
   * resource is used.
   */
  public static final int FICASCHEDULERNODE = 1;
  public static final int RMNODE = 2;
  public static final int SCHEDULERAPPLICATIONATTEMPT = 3;
  public static final int CLUSTER = 4;
  /**
   * Resource types, useful when an entity has more than one resources.
   */
  public static final int TOTAL_CAPABILITY = 1;
  public static final int USED = 2;
  public static final int AVAILABLE = 3;
  public static final int CURRENTRESERVATION = 4;
  public static final int RESOURCELIMIT = 5;
  public static final int CURRENTCONSUMPTION = 6;

  private final String id;
  private final int type;
  private final int parent;
  private int memory;
  private int virtualcores;

  public Resource(String id, int type, int parent) {
    this.id = id;
    this.type = type;
    this.parent = parent;
  }

  public Resource(String id, int type, int parent, int memory,
      int virtualcores) {
    this.id = id;
    this.type = type;
    this.parent = parent;
    this.memory = memory;
    this.virtualcores = virtualcores;
  }

  public String getId() {
    return id;
  }

  public int getType() {
    return type;
  }

  public int getParent() {
    return parent;
  }

  public int getMemory() {
    return memory;
  }

  public int getVirtualCores() {
    return virtualcores;
  }

  @Override
  public String toString() {
    return "HopResource{" + "id=" + id + ", type=" + type + ", parent=" +
        parent + '}';
  }

}
