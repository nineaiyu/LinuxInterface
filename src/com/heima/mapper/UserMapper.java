/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:07:10
*/
package com.heima.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heima.pojo.User;
import com.heima.vo.UserVo;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:07:10
 */
//@Repository("userMapper")
public interface UserMapper {
	
	//获取user列表
	public List<User> selectUserDeptMap(UserVo userVo) throws Exception;

	//通过uid得到对象
	public User getUserByUid(Integer uid) throws Exception;

	//根新user
	public void updateUser(User user) throws Exception;

	//新增user
	public void addUser(User user) throws Exception;

	//通过uid删除user
	public void delUser(Integer uid)throws Exception;

	//获取usercount
	public int getUserCount(String item) throws Exception;
 
}
