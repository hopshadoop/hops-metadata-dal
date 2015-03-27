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

import com.google.common.base.Splitter;

import java.util.Iterator;

public class ApplicationId {

  private final String id;
  private long clustertimestamp;
  private int appId;

  public ApplicationId(String id) {
    this.id = id;
    build();
  }

  public String getId() {
    return id;
  }

  public int getAppId() {
    return appId;
  }
  
  private void build() {
    Iterator<String> it = Splitter.on('_').trimResults().split(id).iterator();
    it.next(); // prefix.
    clustertimestamp = Long.parseLong(it.next());
    appId = Integer.parseInt(it.next());
  }

  
  public long getClustertimestamp() {
    return clustertimestamp;
  }

  /**
   * @param object
   * @return
   */
  @Override
  public boolean equals(Object object) {
    if (object instanceof ApplicationId) {
      ApplicationId oth = (ApplicationId) object;
      return id.equals(oth.getId()) &&
          clustertimestamp == oth.getClustertimestamp();
    } else {
      return false;
    }

  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
    hash = 53 * hash +
        (int) (this.clustertimestamp ^ (this.clustertimestamp >>> 32));
    return hash;
  }
}
