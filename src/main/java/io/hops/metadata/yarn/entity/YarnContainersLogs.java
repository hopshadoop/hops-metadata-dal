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

/**
 *
 * @author rizvi
 */
public class YarnContainersLogs {

  private final String containerid;
  private final int state;
  private final long start;
  private final long stop;

  public YarnContainersLogs(String containerid, int state, long start, long stop) {
    this.containerid = containerid;
    this.state = state;
    this.start = start;
    this.stop = stop;
  }

  public String getContainerid() {
    return containerid;
  }

  public int getState() {
    return state;
  }

  public long getStart() {
    return start;
  }

  public long getStop() {
    return stop;
  }

  @Override
  public String toString() {
    return "YarnContainersLog{" + "containerid=" + containerid + ", state="
            + state + ", start=" + start + '}';
  }

}
