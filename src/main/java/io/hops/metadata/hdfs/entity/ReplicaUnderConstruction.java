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
package io.hops.metadata.hdfs.entity;

public class ReplicaUnderConstruction extends ReplicaBase {

  private int state;
  private int bucketId;
  private boolean chosenAsPrimary;

  public ReplicaUnderConstruction(int state, int storageId, long blockId,
      int inodeId, int bucketId, boolean chosenAsPrimary) {
    super(storageId, blockId, inodeId);
    this.state = state;
    this.bucketId = bucketId;
    this.chosenAsPrimary = chosenAsPrimary;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }
  
  public int getBucketId() {
    return bucketId;
  }
  
  public void setBucketId(int bucketId) {
    this.bucketId = bucketId;
  }
  
  public boolean getChosenAsPrimary(){
    return chosenAsPrimary;
  }

  public void setChosenAsPrimary(boolean chosenAsPrimary) {
    this.chosenAsPrimary = chosenAsPrimary;
  }
  
}
