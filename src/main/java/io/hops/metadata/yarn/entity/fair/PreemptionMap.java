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
package io.hops.metadata.yarn.entity.fair;

public class PreemptionMap {

  private final String schedulerappId;
  private final String rmcontainerId;
  private final long value;

  public PreemptionMap(String schedulerappId, String rmcontainerId, long value) {
    this.schedulerappId = schedulerappId;
    this.rmcontainerId = rmcontainerId;
    this.value = value;
  }

  public String getSchedulerappId() {
    return schedulerappId;
  }

  public String getRmcontainerId() {
    return rmcontainerId;
  }

  public long getValue() {
    return value;
  }
}
