/**
 * 
 */
package com.heima.service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;




/**
 * @author liuyu
 *
 */
@Service("cmdService")
public class CmdServiceImpl implements CmdServiceI {
	public List<String> command(String cmds) throws Exception {
		// TODO Auto-generated method stub
		
		Process process = null;
	    List processList = new ArrayList();
	    try {
	      process = Runtime.getRuntime().exec(cmds);

	      BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
	      String line = "";
	      while ((line = input.readLine()) != null) {
	        processList.add(line);
	      }
	      input.close();
	    }
	    catch (Throwable e) {
	      System.out.println("call shell failed. " + e);
	      processList.add(e.toString());
	    }

	    return processList;
	}

	public List<String> CreateUser(String name) throws Exception {
		// TODO Auto-generated method stub
		String command = "bash /data/create_ftpuser.sh " + name;
	    System.out.println("create_ftpuser_cmd---------------------: " + command);
	    return command(command);
	}

	public List<String> DeleteUser(String name) throws Exception {
		// TODO Auto-generated method stub
		String command = "bash /data/delete_ftpuser.sh " + name;
	    System.out.println("delete_ftpuser_cmd---------------------: " + command);
	   
	    return command(command);
	}
	
	///////////////##########通过ssh远程执行命令################################
	
	
	
	

}
