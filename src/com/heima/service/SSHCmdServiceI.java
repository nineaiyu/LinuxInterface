package com.heima.service;

import java.util.List;

import com.heima.pojo.K8s;

public interface SSHCmdServiceI {

	public List<String> exec(String host,String user,String psw,int port,String command) throws Exception;
	public List<String> command(String command) throws Exception;
	
	////// FTP ///////////
	public List<String> CreateUser(String name,String pass) throws Exception;
	public List<String> DeleteUser(String name) throws Exception;
	public List<String> ChangeUserPW(String name,String pass) throws Exception;
	
	////// K8s docker ///////////
	public List<String> CreateK8sDocker(K8s k8s) throws Exception;
	public List<String> UpdateK8sDocker(K8s k8s) throws Exception;
	public List<String> DeleteK8sDocker(K8s k8s) throws Exception;
	public List<String> getWebShellUrl(K8s k8s) throws Exception;
	public List<String> getnodeips() throws Exception;
		
}
