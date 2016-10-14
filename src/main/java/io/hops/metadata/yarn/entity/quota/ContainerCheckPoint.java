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

package io.hops.metadata.yarn.entity.quota;

public class ContainerCheckPoint {
  private final String containerId;
  private final long checkPoint;
  private final float multiplicator;

  public ContainerCheckPoint(String containerId){
    this(containerId, 0,0);
  }
  public ContainerCheckPoint(String containerId, long checkPoint, float price) {
    this.containerId = containerId;
    this.checkPoint = checkPoint;
    this.multiplicator = price;
  }

  public String getContainerId() {
    return containerId;
  }

  public long getCheckPoint() {
    return checkPoint;
  }
  
  public float getMultiplicator() {
    return multiplicator;
  }
}
