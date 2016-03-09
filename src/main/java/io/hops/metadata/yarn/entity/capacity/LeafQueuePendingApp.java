/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.metadata.yarn.entity.capacity;

public class LeafQueuePendingApp {
  private final String appAttemptId;
  private final String queuePath;

  public LeafQueuePendingApp(String appAttemptId, String queuePath) {
    this.appAttemptId = appAttemptId;
    this.queuePath = queuePath;
  }

  public LeafQueuePendingApp(String appAttemptId) {
    this.appAttemptId = appAttemptId;
    this.queuePath = null;
  }

  public String getAppAttemptId() {
    return appAttemptId;
  }

  public String getQueuePath() {
    return queuePath;
  }
  
  
}
