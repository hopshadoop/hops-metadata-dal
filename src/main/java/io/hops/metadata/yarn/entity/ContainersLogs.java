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

public class ContainersLogs implements Comparable<ContainersLogs> {

  private final String containerid;
  private final long start;
  private long stop;
  private int exitstatus;

  public static final int DEFAULT_STOP_TIMESTAMP = 0;
  public static final int UNKNOWN_CONTAINER_EXIT = -200;
  public static final int CONTAINER_RUNNING_STATE = -201;

  public ContainersLogs(String containerid, long start,
          long stop, int exitstatus) {
    this.containerid = containerid;
    this.start = start;
    this.stop = stop;
    this.exitstatus = exitstatus;
  }

  public String getContainerid() {
    return containerid;
  }

  public long getStart() {
    return start;
  }

  public long getStop() {
    return stop;
  }

  public void setStop(int stop) {
    this.stop = stop;
  }

  public int getExitstatus() {
    return exitstatus;
  }

  public void setExitstatus(int exitstatus) {
    this.exitstatus = exitstatus;
  }

  @Override
  public String toString() {
    return "HopContainersLogs{" + "containerid=" + containerid
            + ", start=" + start + ", stop=" + stop + ", state" + exitstatus
            + '}';
  }

  @Override
  public int compareTo(ContainersLogs other) {
    if (this.equals(other)) {
      return 0;
    }
    return containerid.compareTo(other.getContainerid());

  }
}
