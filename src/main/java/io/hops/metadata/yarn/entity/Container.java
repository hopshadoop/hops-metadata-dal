package io.hops.metadata.yarn.entity;

public class Container {

  private final String containerId;
  private final String NodeId;
  private final String httpAddress;
  private final int priority;
  private final long memSize;
  private final int virtualCores;
  private final int gpus;
  private final int version;

  public Container(String containerId, String NodeId, String httpAddress, int priority, long memSize, int virtualCores,
      int gpus, int version) {
    this.containerId = containerId;
    this.NodeId = NodeId;
    this.httpAddress = httpAddress;
    this.priority = priority;
    this.memSize = memSize;
    this.virtualCores = virtualCores;
    this.gpus = gpus;
    this.version = version;
  }

  public String getContainerId() {
    return containerId;
  }

  public String getNodeId() {
    return NodeId;
  }

  public String getHttpAddress() {
    return httpAddress;
  }

  public int getPriority() {
    return priority;
  }

  public long getMemSize() {
    return memSize;
  }

  public int getVirtualCores() {
    return virtualCores;
  }

  public int getGpus() {
    return gpus;
  }

  public int getVersion() {
    return version;
  }

}
