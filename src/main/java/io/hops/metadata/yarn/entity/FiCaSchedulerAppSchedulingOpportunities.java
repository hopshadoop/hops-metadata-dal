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

public class FiCaSchedulerAppSchedulingOpportunities {

  private final String schedulerapp_id;
  private final int priority_id;
  private final int counter;

  public FiCaSchedulerAppSchedulingOpportunities(String schedulerapp_id,
          int priority_id, int counter) {
    this.schedulerapp_id = schedulerapp_id;
    this.priority_id = priority_id;
    this.counter = counter;
  }

  public String getSchedulerapp_id() {
    return schedulerapp_id;
  }

  public int getPriority_id() {
    return priority_id;
  }

  public int getCounter() {
    return counter;
  }
}
