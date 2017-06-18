/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:07:10
*/
package com.heima.mapper;



import java.util.List;

import com.heima.pojo.Admin;



/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:07:10
 */

public interface AdminMapper {
	
	public Admin getUserByUid(Integer uid) throws Exception;
	public Boolean logins(Admin admins) throws Exception;
	public List<Admin> selectAdminUser() throws Exception;
	public Admin getAdminPass(String uname) throws Exception;
 
}
