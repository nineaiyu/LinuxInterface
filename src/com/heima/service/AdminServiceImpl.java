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

import com.heima.mapper.AdminMapper;
import com.heima.pojo.Admin;




/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:59:59
 */
@Service("adminService")
public class AdminServiceImpl implements AdminServiceI{
	
	@Autowired
	@Qualifier("adminMapper")
	private AdminMapper adminMapper;
	

	public Admin getUserByUid(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean logins(Admin admins) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> selectAdminUser() throws Exception {
		// TODO Auto-generated method stub
		List<Admin> list = adminMapper.selectAdminUser();
		return list;
	}

	public Admin getpasswd(String uname) throws Exception {
		// TODO Auto-generated method stub
		Admin admin = adminMapper.getAdminPass(uname);
		if(admin == null){
			return null;
		}
		System.out.println("getpasswd:name is "+uname+"  pass is :"+admin.getUpass());
		return admin;
		
	}



	


}
