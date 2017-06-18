package com.heima.pojo;

public class Services {

	public Services(Integer uid, String name, String servicename,
			String ipandport, String account, String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.servicename = servicename;
		this.ipandport = ipandport;
		this.account = account;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Services [uid=" + uid + ", name=" + name + ", servicename="
				+ servicename + ", serviceversion=" + serviceversion
				+ ", ipandport=" + ipandport + ", account=" + account
				+ ", password=" + password + "]";
	}
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getIpandport() {
		return ipandport;
	}
	public void setIpandport(String ipandport) {
		this.ipandport = ipandport;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Services(Integer uid, String name, String servicename,
			String serviceversion, String ipandport, String account,
			String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.servicename = servicename;
		this.serviceversion = serviceversion;
		this.ipandport = ipandport;
		this.account = account;
		this.password = password;
	}
	public String getServiceversion() {
		return serviceversion;
	}
	public void setServiceversion(String serviceversion) {
		this.serviceversion = serviceversion;
	}
	private Integer uid;
	private String name;
	private String servicename;
	private String serviceversion;
	private String ipandport;
	private String account;
	private String password;

}
