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

import com.heima.mapper.AppMapper;
import com.heima.mapper.ServicesMapper;
import com.heima.pojo.App;
import com.heima.pojo.Services;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:59:59
 */
@Service("appService")
public class AppServiceImpl implements AppServiceI{
	
	@Autowired
	@Qualifier("appMapper")
	private AppMapper appMapper;

	public List<App> selectAppInfos(String name) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("name is select app : "+name);
		List<App> list = appMapper.selectAppInfos(name);
		return list;
	}

	public void updateApp(App app) throws Exception {
		// TODO Auto-generated method stub
		appMapper.updateApp(app);
	}

	public void addApp(App app) throws Exception {
		// TODO Auto-generated method stub
		appMapper.addApp(app);
	}

	public void delApp(int uid) throws Exception {
		// TODO Auto-generated method stub
		appMapper.delApp(uid);
	}

	public List<App> selectAppName() throws Exception {
		// TODO Auto-generated method stub
		List<App> list = appMapper.selectAppName();
		return list;
	}



}
