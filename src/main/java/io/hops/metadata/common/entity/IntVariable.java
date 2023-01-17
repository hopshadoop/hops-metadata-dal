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

public class IntVariable extends Variable {

  private Integer value = new Integer(0);

  public IntVariable(Finder type, int value) {
    this(type);
    this.value = value;
  }

  public IntVariable(Finder type) {
    super(type);
  }

  public IntVariable(int value) {
    this(Finder.GenericInteger, value);
  }

  @Override
  public Integer getValue() {
    return value;
  }

  @Override
  public void setValue(byte[] val) {
    if (val == null || val.length != getLength()) {
      return;
    }
    ByteBuffer buf = ByteBuffer.wrap(val);
    value = buf.getInt();
  }

  @Override
  public byte[] getBytes() {
    ByteBuffer buf = ByteBuffer.allocate(getLength());
    buf.putInt(value);
    return buf.array();
  }

  @Override
  public int getLength() {
    return 4;
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IntVariable that = (IntVariable) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
