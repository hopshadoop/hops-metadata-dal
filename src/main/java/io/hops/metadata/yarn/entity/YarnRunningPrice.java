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

public class YarnRunningPrice {

  private final PriceType type;
  private final long time;
  private final float price;

  public enum PriceType{
    VARIABLE;
  }
  public YarnRunningPrice(PriceType type, long time, float price) {
    this.type = type;
    this.time = time;
    this.price = price;
  }

  public PriceType getId() {
    return type;
  }

  public long getTime() {
    return time;
  }

  public float getPrice() {
    return price;
  }
  
  @Override
  public String toString() {
    return "YarnProjectsQuota{" + "type=" + type + ", time=" + time + ", price="
            + price + " }";
  }

}
