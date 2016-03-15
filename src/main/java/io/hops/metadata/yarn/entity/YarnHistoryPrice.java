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
public class YarnHistoryPrice {

  private final long time;
  private final float price;

  public YarnHistoryPrice( long time, float price) {    
    this.time = time;
    this.price = price;
  }
  
  public long getTime() {
    return time;
  }

  public float getPrice() {
    return price;
  }
  
  @Override
  public String toString() {
    return "YarnProjectsQuota{time=" + time + ", price=" + price + " }";
  }
  
}
