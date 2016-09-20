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

public class NextHeartbeat {

  //Field that denotes the integer value of the nextheartbeat field if is true
  public static final int NEXTHEARTBEAT_TRUE = 1;
  public static final int NEXTHEARTBEAT_FALSE = 0;

  private final String rmnodeid;
  private final boolean nextheartbeat;

  /**
   * @param rmnodeid
   * @param nextheartbeat
   */
  public NextHeartbeat(String rmnodeid, boolean nextheartbeat) {
    this.rmnodeid = rmnodeid;
    this.nextheartbeat = nextheartbeat;
  }


  /**
   * @return
   */
  public String getRmnodeid() {
    return rmnodeid;
  }

  /**
   * @return
   */
  public boolean isNextheartbeat() {
    return nextheartbeat;
  }

  @Override
  public String toString() {
    return "HopNextHeartbeat{" + "rmnodeid=" + rmnodeid + ", nextheartbeat=" +
        nextheartbeat + '}';
  }
  
    /**
   * As ClusterJ boolean is buggy, we use Int to store the boolean field to NDB
   * and we convert it here to integer.
   * <p/>
   *
   * @return
   */
  public static boolean intToBoolean(int a) {
    return a == NEXTHEARTBEAT_TRUE;
  }

  public static int booleanToInt(boolean a) {
    return a ? NEXTHEARTBEAT_TRUE : NEXTHEARTBEAT_FALSE;
  }

}
