/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:07:10
*/
package com.heima.mapper;

import java.util.List;


import com.heima.pojo.App;


/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:07:10
 */
//@Repository("appMapper")
public interface AppMapper {
	
	public List<App> selectAppInfos(String appname) throws Exception;
	public List<App> selectAppName() throws Exception;
	
	public void updateApp(App app) throws Exception;

	public void addApp(App app) throws Exception;

	public void delApp(int uid) throws Exception;
 
}
