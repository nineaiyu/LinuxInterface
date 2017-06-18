/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:59:37
*/
package com.heima.service;

import java.util.List;

import com.heima.pojo.User;
import com.heima.vo.UserVo;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:59:37
 */
public interface UserServiceI {

	public List<User> selectUserDeptMap(UserVo userVo) throws Exception;

	/**
	 * @param uid
	 * @return
	 */
	public User getUserByUid(Integer uid) throws Exception;

	/**
	 * @param user
	 */
	public void updateUser(User user) throws Exception;

	/**
	 * @param user
	 */
	public void addUser(User user) throws Exception;

	/**
	 * @param uid
	 */
	public void delUser(Integer uid) throws Exception;

	/**
	 * @param item 
	 * @return
	 */
	public int getUserCount(String item) throws Exception;
}
