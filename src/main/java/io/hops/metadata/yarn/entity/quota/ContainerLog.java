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

public class ContainerLog implements Comparable<ContainerLog> {

  private final String containerId;
  private final long start;
  private long stop;
  private int exitStatus;
  private float multiplicator;
  private final int nbVcores;
  private final long memoryUsed;
  private final int gpuUsed;

  public ContainerLog(String containerId, long start, int exitStatus,
          float multiplicator, int nbVcores, long memoryUsed, int gpuUsed) {
    this(containerId, start, 0, exitStatus, multiplicator, nbVcores,
            memoryUsed, gpuUsed);
  }
  
  public ContainerLog(String containerId, long start, long stop, int exitStatus,
          float multiplicator, int nbVcores, long memoryUsed, int gpuUsed) {
    this.containerId = containerId;
    this.start = start;
    this.stop = stop;
    this.exitStatus = exitStatus;
    this.multiplicator = multiplicator;
    this.nbVcores = nbVcores;
    this.memoryUsed=memoryUsed;
    this.gpuUsed = gpuUsed;
  }

  public void setPrice(float price) {
    this.multiplicator = price;
  }

  public float getPrice() {
    return multiplicator;
  }

  public String getContainerid() {
    return containerId;
  }

  public long getStart() {
    return start;
  }

  public long getStop() {
    return stop;
  }

  public void setStop(long stop) {
    this.stop = stop;
  }

  public int getExitstatus() {
    return exitStatus;
  }

  public void setExitstatus(int exitstatus) {
    this.exitStatus = exitstatus;
  }

  public String getContainerId() {
    return containerId;
  }

  public int getExitStatus() {
    return exitStatus;
  }

  public float getMultiplicator() {
    return multiplicator;
  }

  public int getNbVcores() {
    return nbVcores;
  }

  public long getMemoryUsed() {
    return memoryUsed;
  }

  public int getGpuUsed() {
    return gpuUsed;
  }

  @Override
  public String toString() {
    return "HopContainersLogs{" + "containerid=" + containerId
            + ", start=" + start + ", stop=" + stop + ", state" + exitStatus
            + '}';
  }

  @Override
  public int compareTo(ContainerLog other) {
    if (this.equals(other)) {
      return 0;
    }
    return containerId.compareTo(other.getContainerid());

  }
}
