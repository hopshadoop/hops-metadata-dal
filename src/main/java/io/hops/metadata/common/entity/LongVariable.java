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
package io.hops.metadata.common.entity;

import java.nio.ByteBuffer;
import java.util.Objects;

public class LongVariable extends Variable {

  private Long value = new Long(0);

  public LongVariable(Finder type, long value) {
    this(type);
    this.value = value;
  }

  public LongVariable(Finder type) {
    super(type);
  }

  public LongVariable(long value) {
    this(Finder.GenericLong, value);
  }

  @Override
  public Long getValue() {
    return value;
  }

  @Override
  public void setValue(byte[] val) {
    if (val == null){
      return;
    }

    if (val.length != getLength()) {
      //it sometime (updates) happen that we want to convert a int to a long
      if(val.length == 4){
        ByteBuffer buf = ByteBuffer.wrap(val);
        value = new Long(buf.getInt());
      }
      return;
    }
    ByteBuffer buf = ByteBuffer.wrap(val);
    value = buf.getLong();
  }

  @Override
  public byte[] getBytes() {
    ByteBuffer buf = ByteBuffer.allocate(getLength());
    buf.putLong(value);
    return buf.array();
  }

  @Override
  public int getLength() {
    return 8;
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LongVariable that = (LongVariable) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
