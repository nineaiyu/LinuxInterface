package com.heima.service;


import java.util.List;

import com.heima.pojo.App;

public interface AppServiceI {


	public List<App> selectAppInfos(String name) throws Exception;
	
	public List<App> selectAppName() throws Exception;
	
	public void updateApp(App app) throws Exception;

	public void addApp(App app) throws Exception;

	public void delApp(int uid) throws Exception;
}
