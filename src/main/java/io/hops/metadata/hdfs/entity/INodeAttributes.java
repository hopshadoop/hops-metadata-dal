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


/**
 * right now it holds quota info. later we can add more
 * information like access time ( if we want to remove locks from the parent
 * dirs )
 */
public class INodeAttributes implements Comparable<INodeAttributes> {
  private Integer inodeId;
  private Long nsQuota; /// NameSpace quota
  private Long nsCount;
  private Long dsQuota; /// disk space quota
  private Long diskspace;

  public INodeAttributes(Integer inodeId, Long nsQuota, Long nsCount,
      Long dsQuota, Long diskspace) {
    this.inodeId = inodeId;
    this.nsQuota = nsQuota;
    this.nsCount = nsCount;
    this.dsQuota = dsQuota;
    this.diskspace = diskspace;
  }

  public Integer getInodeId() {
    return inodeId;
  }

  public Long getNsQuota() {
    return nsQuota;
  }

  public Long getNsCount() {
    return nsCount;
  }

  public Long getDsQuota() {
    return dsQuota;
  }

  public Long getDiskspace() {
    return diskspace;
  }

  public void setInodeId(Integer inodeId) {
    this.inodeId = inodeId;
  }

  public void setNsQuota(Long nsQuota) {
    this.nsQuota = nsQuota;
  }

  public void setNsCount(Long nsCount) {
    this.nsCount = nsCount;
  }

  public void setDsQuota(Long dsQuota) {
    this.dsQuota = dsQuota;
  }

  public void setDiskspace(Long diskspace) {
    this.diskspace = diskspace;
  }

  public int compareTo(INodeAttributes o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String toString() {
    return "HopINodeAttributes{" +
        "inodeId=" + inodeId +
        ", nsQuota=" + nsQuota +
        ", nsCount=" + nsCount +
        ", dsQuota=" + dsQuota +
        ", diskspace=" + diskspace +
        '}';
  }
}
