package com.heima.pojo;

public class App {

	
	@Override
	public String toString() {
		return "App [uid=" + uid + ", appname=" + appname + ", versions="
				+ versions + "]";
	}
	public App(Integer uid, String appname, String versions) {
		super();
		this.uid = uid;
		this.appname = appname;
		this.versions = versions;
	}
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getversions() {
		return versions;
	}
	public void setversions(String versions) {
		this.versions = versions;
	}
	private Integer uid;
	private String appname;
	private String versions;

}
