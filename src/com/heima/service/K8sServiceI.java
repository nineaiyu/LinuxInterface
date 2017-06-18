package com.heima.service;


import java.util.List;



import com.heima.pojo.K8s;

public interface K8sServiceI {


	public List<K8s> selectK8sInfos(String NamespaceName) throws Exception;
	
	public void updateK8s(K8s k8s) throws Exception;

	public void addK8s(K8s k8s) throws Exception;

	public void delK8s(K8s k8s) throws Exception;
	
	public List<String> getWebShellUrl(K8s k8s) throws Exception;
	
	public String[] getnodeips() throws Exception;
}
