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
package io.hops.metadata.yarn.entity.appmasterrpc;

import java.util.List;
import java.util.Map;

public class AllocateRPC {

  private final int rpcID;
  private final int responseId;
  private final float progress;
  private final List<String> releaseList;
  private final Map<String, byte[]> ask;
  private final Map<String, byte[]> resourceIncreaseRequest;
  private final List<String> blackListAddition;
  private final List<String> blackListRemovals;

  public AllocateRPC(int rpcID, int responseId, float progress,
          List<String> releaseList, Map<String, byte[]> ask,
          Map<String, byte[]> resourceIncreaseRequest,
          List<String> blackListAddition, List<String> blackListRemovals) {
    this.rpcID = rpcID;
    this.responseId = responseId;
    this.progress = progress;
    this.releaseList = releaseList;
    this.ask = ask;
    this.resourceIncreaseRequest = resourceIncreaseRequest;
    this.blackListAddition = blackListAddition;
    this.blackListRemovals = blackListRemovals;
  }

  public int getRpcID() {
    return rpcID;
  }

  public int getResponseId() {
    return responseId;
  }

  public float getProgress() {
    return progress;
  }

  public List<String> getReleaseList() {
    return releaseList;
  }

  public Map<String, byte[]> getAsk() {
    return ask;
  }

  public Map<String, byte[]> getResourceIncreaseRequest() {
    return resourceIncreaseRequest;
  }

  public List<String> getBlackListAddition() {
    return blackListAddition;
  }

  public List<String> getBlackListRemovals() {
    return blackListRemovals;
  }

}
