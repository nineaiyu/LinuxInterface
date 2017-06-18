package com.heima.service;


import java.util.List;

import com.heima.pojo.Services;

public interface ServicesServiceI {


	public List<Services> selectServices(String name) throws Exception;
	
	public void updateServices(Services service) throws Exception;

	public void addServices(Services service) throws Exception;

	public void delServices(Integer uid) throws Exception;
	
	public List<Services> getServices(Integer uid) throws Exception;
}
