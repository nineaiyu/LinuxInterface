/**
 * 
 */
package com.heima.service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.heima.pojo.K8s;
import com.jcraft.jsch.*;





/**
 * @author liuyu
 *
 */
@Service("sshcmdService")
public class SSHCmdServiceImpl implements SSHCmdServiceI {

	private String hostip = "10.1.41.100:8888";
	CmdServiceImpl cmi = new CmdServiceImpl();
	public List<String> exec(String host,String user,String psw,int port,String command) throws Exception {
		// TODO Auto-generated method stub
		String result="";
		
		Session session =null;
		ChannelExec openChannel =null;
		List<String> list = new ArrayList<String>();
		try {
			JSch jsch=new JSch();
			session = jsch.getSession(user, host, port);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(psw);
			session.connect();
			openChannel = (ChannelExec) session.openChannel("exec");
			openChannel.setCommand(command);
//			List<String> list = openChannel.getOutputStream()
			int exitStatus = openChannel.getExitStatus();
			System.out.println(exitStatus);
			openChannel.connect();  
            InputStream in = openChannel.getInputStream();  
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            String buf = null;
           
            while ((buf = reader.readLine()) != null) {
            	result+= new String(buf.getBytes("gbk"),"UTF-8")+"    <br>\r\n";  
            	list.add(new String(buf.getBytes("gbk"),"UTF-8"));
            }  
		} catch (JSchException | IOException e) {
			result+=e.getMessage();
		}finally{
			if(openChannel!=null&&!openChannel.isClosed()){
				openChannel.disconnect();
			}
			if(session!=null&&session.isConnected()){
				session.disconnect();
			}
		}
		
		for (String string : list) {
			System.out.println(string);
			
		}
//		return result;
		return list;
	}

	@Override
	public List<String> CreateUser(String name,String pass) throws Exception {
		// TODO Auto-generated method stub
		String cmds = "docker exec -i ftp create_ftpuser "+name+" "+pass;
		System.out.println("执行命令如下："+cmds);
		return command(cmds);
	}

	@Override
	public List<String> DeleteUser(String name) throws Exception {
		// TODO Auto-generated method stub
		String cmds = "docker exec -i ftp delete_ftpuser "+name;
		System.out.println("执行命令如下："+cmds);
		return command(cmds);
	}

	@Override
	public List<String> ChangeUserPW(String name, String pass) throws Exception {
		// TODO Auto-generated method stub
		String cmds = "docker exec -i ftp change_ftppass "+name+" "+pass;
		System.out.println("执行命令如下："+cmds);
		return command(cmds);
	}

	@Override
	public List<String> command(String command) throws Exception {
		// TODO Auto-generated method stub
//		String hosts = "119.29.217.240";
//		int ports = 22;
//		String name = "root";
//		String password = "rq0Y9>oL6H)m5Ecu!{5p%SJsJtgz}<";
//		String password = "rq0Y9>oL6H)m";
		String hosts = "10.1.41.200";
		int ports = 22222;
		String name = "root";
		String password = "root";
		
		return this.exec(hosts, name, password, ports, command);
	}
	
	/////////////////// create k8s docker /////////////////////////

	@Override
	public List<String> CreateK8sDocker(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		
		
		String cmds = "python  C:/Users/liuyu/PycharmProjects/k8s/k8sutils.py " +hostip+" "+ k8s.getAction() + " "
				+ k8s.getNamespaceName() + " " + k8s.getAppname() + " "
				+ k8s.getReplicas() + " " + k8s.getHostIP() + " "
				+ k8s.getHostPort() + " " + k8s.getHostPath() + " "
				+ k8s.getContainerPath() + " " + k8s.getContainerImage() + " "
				+ k8s.getCpu() + " " + k8s.getMem() + " "
				+ k8s.getContainerPort() + " " + k8s.getDeployId() + " "
				+ k8s.getEnvname() + " " + k8s.getEnvalue();
		System.out.println("执行命令如下：" + cmds);
		return cmi.command(cmds);
		//return command(cmds);
	}

	@Override
	public List<String> UpdateK8sDocker(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		String cmds = "python  C:/Users/liuyu/PycharmProjects/k8s/k8sutils.py " +hostip+" "+ "create" + " "
				+ k8s.getNamespaceName() + " " + k8s.getAppname() + " "
				+ k8s.getReplicas() + " " + k8s.getHostIP() + " "
				+ k8s.getHostPort() + " " + k8s.getHostPath() + " "
				+ k8s.getContainerPath() + " " + k8s.getContainerImage() + " "
				+ k8s.getCpu() + " " + k8s.getMem() + " "
				+ k8s.getContainerPort() + " " + k8s.getDeployId() + " "
				+ k8s.getEnvname() + " " + k8s.getEnvalue();
		System.out.println("执行命令如下：" + cmds);
		return cmi.command(cmds);
		//return command(cmds);
	}

	@Override
	public List<String> DeleteK8sDocker(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		String cmds = "python  C:/Users/liuyu/PycharmProjects/k8s/k8sutils.py " +hostip+" "+ "delete" + " "
				+ k8s.getNamespaceName() + " " + k8s.getAppname() + " "
				+ k8s.getHostPath() + " "
				+ k8s.getContainerPath() + " " + k8s.getContainerImage() + " "
				+ k8s.getCpu() + " " + k8s.getMem() + " "
				+ k8s.getContainerPort() + " " + k8s.getDeployId() + " "
				+ k8s.getEnvname() + " " + k8s.getEnvalue();
		System.out.println("执行命令如下：" + cmds);
		return cmi.command(cmds);
		//return command(cmds);
	}

	@Override
	public List<String> getnodeips()
			throws Exception {
		// TODO Auto-generated method stub
		String cmds = "python  C:/Users/liuyu/PycharmProjects/k8s/k8sutils.py " +hostip+" "+ "getnodeips"; 
		System.out.println("执行命令如下：" + cmds);
		return cmi.command(cmds);
	}

	@Override
	public List<String> getWebShellUrl(K8s k8s) throws Exception {
		// TODO Auto-generated method stub
		String DomeosIPort = "10.1.41.100:8080";
		String cmds = "python  C:/Users/liuyu/PycharmProjects/k8s/k8sutils.py "
				+ hostip + " " +"getwebshellurl"+" "+ k8s.getNamespaceName() + " "
				+ k8s.getAppname() + " "+DomeosIPort;
		System.out.println("执行命令如下：" + cmds);
		return cmi.command(cmds);
		// return null;
	}
	

	


	

}
