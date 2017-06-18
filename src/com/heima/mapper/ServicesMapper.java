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

import com.heima.pojo.Services;
import com.heima.pojo.User;
import com.heima.vo.UserVo;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:07:10
 */
//@Repository("servicesMapper")
public interface ServicesMapper {
	
	public List<Services> selectServices(String name) throws Exception;
	
	public void updateServices(Services service) throws Exception;

	public void addServices(Services service) throws Exception;

	public void delServices(Integer uid) throws Exception;
	
	public List<Services> getServices(Integer uid) throws Exception;
 
}
