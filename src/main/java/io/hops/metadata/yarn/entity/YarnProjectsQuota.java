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
public class YarnProjectsQuota {

  private final String projectid;
  private final float remaining_quota;
  private final float total_used_quota;

  public YarnProjectsQuota(String projectid, float remaining_quota,
          float total_used_quota) {
    this.projectid = projectid;
    this.remaining_quota = remaining_quota;
    this.total_used_quota = total_used_quota;
  }

  public String getProjectid() {
    return projectid;
  }

  public float getRemainingQuota() {
    return remaining_quota;
  }

  public float getTotalUsedQuota() {
    return total_used_quota;
  }

  @Override
  public String toString() {
    return "YarnProjectsQuota{" + "projectid=" + projectid
            + ", remaining_quota=" + remaining_quota + ", total_used_quota="
            + total_used_quota + " }";
  }
}
