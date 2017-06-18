/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:59:59
*/
package com.heima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.heima.mapper.K8sMapper;
import com.heima.pojo.K8s;


/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:59:59
 */
@Service("k8sService")
public class K8sServiceImpl implements K8sServiceI{
	
	@Autowired
	@Qualifier("k8sMapper")
	private K8sMapper k8sMapper;

	@Override
	public List<K8s> selectK8sInfos(String NamespaceName) throws Exception {
		// TODO Auto-generated method stub
		List<K8s> list = k8sMapper.selectK8sInfos(NamespaceName);
		return list;
	}

	@Override
	public void updateK8s(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addK8s(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		k8s.setAction("create");
		k8sMapper.addK8s(k8s);
		//CreateK8sDocker
		SSHCmdServiceImpl sshcmd = new SSHCmdServiceImpl();
		System.out.println(sshcmd.CreateK8sDocker(k8s));
		
	}

	@Override
	public void delK8s(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		SSHCmdServiceImpl sshcmd = new SSHCmdServiceImpl();
		System.out.println(sshcmd.DeleteK8sDocker(k8s));
	}

	@Override
	public List<String> getWebShellUrl(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		SSHCmdServiceImpl sshcmd = new SSHCmdServiceImpl();
		List<String> webshellurl = sshcmd.getWebShellUrl(k8s);
		System.out.println(webshellurl);
		return webshellurl;
	}

	@Override
	public String[] getnodeips()
			throws Exception {
		// TODO Auto-generated method stub
		SSHCmdServiceImpl sshcmd = new SSHCmdServiceImpl();
		List<String> ips = sshcmd.getnodeips();
		String[] arrayStr =new String[]{};
		arrayStr = ips.toString().replace("[[","").replace("]]", "").split(",");
//		System.out.println(arrayStr.length);
//		for (String string : arrayStr) {
//			System.out.println(string);
//		}
		System.out.println("################################################################");
//		System.out.println(java.util.Arrays.asList(ips.toString().replace("[[","").replace("]]", "")));
		return arrayStr;
	}

	

}
