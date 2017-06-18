package com.heima.service;


import java.util.List;

import com.heima.pojo.Admin;




public interface AdminServiceI {

	/**
	 * @param uid
	 * @return
	 */
	public Admin getUserByUid(Integer uid) throws Exception;
	public Boolean logins(Admin admins) throws Exception;
	public List<Admin> selectAdminUser() throws Exception;
	public Admin getpasswd(String uname) throws Exception;
}
