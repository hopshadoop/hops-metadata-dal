/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.entity;

/**
 *
 * @author rizvi
 */
public class YarnRunningPrice {

  private final int id;
  private final long time;
  private final float price;

  public YarnRunningPrice(int id, long time, float price) {
    this.id = id;
    this.time = time;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public long getTime() {
    return time;
  }

  public float getPrice() {
    return price;
  }
  
  @Override
  public String toString() {
    return "YarnProjectsQuota{" + "id=" + id + ", time=" + time + ", price="
            + price + " }";
  }

}
