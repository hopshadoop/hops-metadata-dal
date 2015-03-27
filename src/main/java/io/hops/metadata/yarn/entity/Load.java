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

public class Load {
  private final String rmHostName;
  private final long load;

  public Load(String rmId, long load) {
    this.rmHostName = rmId;
    this.load = load;
  }

  public String getRmHostName() {
    return rmHostName;
  }

  public long getLoad() {
    return load;
  }
  
  
}
