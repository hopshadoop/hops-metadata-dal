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
package io.hops.util;

public class Slicer {

  public interface OperationHandler {

    public void handle(int startIndex, int endIndex) throws Exception;
  }

  public static void slice(final int total, final int sliceSize,
      OperationHandler op) throws Exception {
    if (total == 0) {
      return;
    }
    int numOfSlices;
    if (total <= sliceSize) {
      numOfSlices = 1;
    } else {
      numOfSlices = (int) Math.ceil(((double) total) / sliceSize);
    }
    for (int slice = 0; slice < numOfSlices; slice++) {
      int startIndex = slice * sliceSize;
      int endIndex = Math.min((slice + 1) * sliceSize, total);
      op.handle(startIndex, endIndex);
    }
  }
}
