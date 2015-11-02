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

public class ResourceRequest implements Comparable<ResourceRequest> {
  private final String id;
  private final int priority;
  private final String name;
  private final byte[] resourcerequeststate;

  public ResourceRequest(String id, int priority, String name,
      byte[] resourcerequeststate) {
    this.id = id;
    this.priority = priority;
    this.name = name;
    this.resourcerequeststate = resourcerequeststate;
  }

  public String getId() {
    return id;
  }

  public int getPriority() {
    return priority;
  }

  public String getName() {
    return name;
  }

  public byte[] getResourcerequeststate() {
    return resourcerequeststate;
  }

  @Override
  public int hashCode() {

    return id.hashCode() + 100 * priority + 200 * name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ResourceRequest)) {
      return false;
    }
    ResourceRequest other = (ResourceRequest) obj;
    return (id.equals(other.id) && priority == other.priority && name.equals(
            other.name));
  }

  @Override
  public int compareTo(ResourceRequest other) {
    if (id.compareTo(other.id) != 0) {
      return id.compareTo(other.id);
    } else if (priority != other.priority) {
      return priority - other.priority;
    } else {
      return name.compareTo(other.name);
    }
  }
}
