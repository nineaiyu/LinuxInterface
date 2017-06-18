package com.heima.pojo;

public class K8s {
	
	@Override
	public String toString() {
		return "K8s [action=" + action + ", NamespaceName=" + NamespaceName
				+ ", appname=" + appname + ", uname=" + uname + ", replicas="
				+ replicas + ", hostIP=" + hostIP + ", hostPort=" + hostPort
				+ ", hostPath=" + hostPath + ", containerPath=" + containerPath
				+ ", containerImage=" + containerImage + ", cpu=" + cpu
				+ ", mem=" + mem + ", containerPort=" + containerPort
				+ ", deployId=" + deployId + ", envname=" + envname
				+ ", envalue=" + envalue + "]";
	}
	public K8s(String action, String namespaceName, String appname,
			String uname, Integer replicas, String hostIP, Integer hostPort,
			String hostPath, String containerPath, String containerImage,
			Integer cpu, Integer mem, Integer containerPort, String deployId,
			String envname, String envalue) {
		super();
		this.action = action;
		NamespaceName = namespaceName;
		this.appname = appname;
		this.uname = uname;
		this.replicas = replicas;
		this.hostIP = hostIP;
		this.hostPort = hostPort;
		this.hostPath = hostPath;
		this.containerPath = containerPath;
		this.containerImage = containerImage;
		this.cpu = cpu;
		this.mem = mem;
		this.containerPort = containerPort;
		this.deployId = deployId;
		this.envname = envname;
		this.envalue = envalue;
	}
	public K8s() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getNamespaceName() {
		return NamespaceName;
	}
	public void setNamespaceName(String namespaceName) {
		NamespaceName = namespaceName;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getReplicas() {
		return replicas;
	}
	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}
	public String getHostIP() {
		return hostIP;
	}
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	public Integer getHostPort() {
		return hostPort;
	}
	public void setHostPort(Integer hostPort) {
		this.hostPort = hostPort;
	}
	public String getHostPath() {
		return hostPath;
	}
	public void setHostPath(String hostPath) {
		this.hostPath = hostPath;
	}
	public String getContainerPath() {
		return containerPath;
	}
	public void setContainerPath(String containerPath) {
		this.containerPath = containerPath;
	}
	public String getContainerImage() {
		return containerImage;
	}
	public void setContainerImage(String containerImage) {
		this.containerImage = containerImage;
	}
	public Integer getCpu() {
		return cpu;
	}
	public void setCpu(Integer cpu) {
		this.cpu = cpu;
	}
	public Integer getMem() {
		return mem;
	}
	public void setMem(Integer mem) {
		this.mem = mem;
	}
	public Integer getContainerPort() {
		return containerPort;
	}
	public void setContainerPort(Integer containerPort) {
		this.containerPort = containerPort;
	}
	public String getDeployId() {
		return deployId;
	}
	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
	public String getEnvname() {
		return envname;
	}
	public void setEnvname(String envname) {
		this.envname = envname;
	}
	public String getEnvalue() {
		return envalue;
	}
	public void setEnvalue(String envalue) {
		this.envalue = envalue;
	}
	private String action;
	private String NamespaceName;
	private String appname;
	private String uname;
	private Integer replicas;
	private String hostIP;
	private Integer hostPort;
	private String hostPath;
	private String containerPath;
	private String containerImage;
	private Integer cpu;
	private Integer mem;
	private Integer containerPort;
	private String deployId;
	private String envname;
	private String envalue;

}
