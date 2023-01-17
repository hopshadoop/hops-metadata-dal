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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayVariable extends Variable {

  private List<Variable> vars;
  private int length;

  public ArrayVariable(Finder type) {
    super(type);
    vars = new ArrayList<>();
    length = 0;
  }

  public ArrayVariable(Finder type, List<? extends Object> value) {
    this(type);
    initVariables(value);
  }

  public ArrayVariable(List<? extends Object> value) {
    this(Finder.GenericArray, value);
  }
  
  public void addVariable(Variable var) {
    length += var.getLength();
    vars.add(var);
  }

  @Override
  public List<Variable> getValue() {
    return vars;
  }

  public List<? extends Object> getVarsValue() {
    List<Object> vals = new ArrayList<>();
    for (Variable var : vars) {
      vals.add(var.getValue());
    }
    return vals;
  }

  @Override
  public void setValue(byte[] val) {
    if (val == null || val.length == 0) {
      return;
    }
    ByteBuffer varsData = ByteBuffer.wrap(val);
    while (varsData.hasRemaining()) {
      Variable var = getVariable(varsData.get());
      byte[] vdata;
      int off = 0;
      int len = var.getLength();
      if (var instanceof StringVariable || var instanceof ByteArrayVariable ) {
        len = varsData.get();
        off = 1;
        vdata = new byte[len + off];
        vdata[0] = (byte) len;
      } else {
        vdata = new byte[len];
      }
      varsData.get(vdata, off, len);
      var.setValue(vdata);
      vars.add(var);
    }
  }

  @Override
  public byte[] getBytes() {
    ByteBuffer varsData = ByteBuffer.allocate(getLength());
    for (Variable var : vars) {
      varsData.put((byte) var.getType().getId());
      varsData.put(var.getBytes());
    }
    return varsData.array();
  }

  @Override
  public int getLength() {
    return length + vars.size();
  }

  private void initVariables(List<? extends Object> arrItems) {
    for (Object item : arrItems) {
      Class itemClass = item.getClass();
      if (itemClass == Integer.class) {
        addVariable(new IntVariable((Integer) item));
      } else if (itemClass == Long.class) {
        addVariable(new LongVariable((Long) item));
      } else if (itemClass == String.class) {
        addVariable(new StringVariable((String) item));
      } else if (itemClass == Double.class) {
        addVariable(new DoubleVariable((Double) item));
      } else {
        if (item instanceof byte[]) {
          addVariable(new ByteArrayVariable((byte[]) item));
        } else {
          throw new IllegalArgumentException(
              "Variable Type " + itemClass + " is not supported");
        }
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ArrayVariable that = (ArrayVariable) o;

    if (vars.size() != that.vars.size()) {
      return false;
    }

    if (length != that.length) {
      return false;
    }

    for (int i = 0; i < vars.size(); i++) {
      Variable v1 = vars.get(i);
      Variable v2 = that.vars.get(i);
      if (!v1.equals(v2)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(vars, length);
  }
}
