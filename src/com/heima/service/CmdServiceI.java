package com.heima.service;

import java.util.List;

public interface CmdServiceI {

	public List<String> command(String cmds) throws Exception;
	public List<String> CreateUser(String name) throws Exception;
	public List<String> DeleteUser(String name) throws Exception;
	
}
