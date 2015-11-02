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

public class FiCaSchedulerAppContainer {
  private final String schedulerapp_id;
  private final String rmcontainer_id;

  public FiCaSchedulerAppContainer(String schedulerapp_id,
      String rmcontainer_id) {
    this.schedulerapp_id = schedulerapp_id;
    this.rmcontainer_id = rmcontainer_id;
  }

  public String getSchedulerapp_id() {
    return schedulerapp_id;
  }

  public String getRmcontainer_id() {
    return rmcontainer_id;
  }
}
