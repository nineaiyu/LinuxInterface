/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:29:47
*/
package com.heima.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.heima.mapper.UserMapper;
import com.heima.pojo.User;
import com.heima.service.UserServiceI;
import com.heima.service.UserServiceImpl;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:29:47
 */

public class Demo1 {
	
	@Autowired
	@Qualifier("userService")
	private UserServiceI userService=null;
	//private UserServiceI userService=new UserServiceImpl();

	 private ApplicationContext context=null;
	@Before
		public void before(){
		context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		 userService = (UserServiceI)context.getBean("userService");
	}
	
	
	@Test
	public void test1() throws Exception{
	}
}
