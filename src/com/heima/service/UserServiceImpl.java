/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:59:59
*/
package com.heima.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.heima.mapper.UserMapper;
import com.heima.pojo.User;
import com.heima.vo.UserVo;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:59:59
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI{
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	//获取列表
	public List<User> selectUserDeptMap(UserVo userVo) throws Exception {
		List<User> list = userMapper.selectUserDeptMap(userVo);
		return list;
	}

	//通过uid得到user对象
	public User getUserByUid(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		User user=userMapper.getUserByUid(uid);
		return user;
	}

	//跟新user
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	//新增user
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}

	//通过uid删除user
	public void delUser(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		userMapper.delUser(uid);
	}

	//获取userCount
	public int getUserCount(String item) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserCount(item);
	}
	

}
