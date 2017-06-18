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

import com.heima.mapper.ServicesMapper;
import com.heima.pojo.Services;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:59:59
 */
@Service("servicesService")
public class ServicesServiceImpl implements ServicesServiceI{
	
	@Autowired
	@Qualifier("servicesMapper")
	private ServicesMapper servicesMapper;



	public void updateServices(Services service) throws Exception {
		// TODO Auto-generated method stub
		servicesMapper.updateServices(service);
	}

	public void addServices(Services service) throws Exception {
		// TODO Auto-generated method stub
		servicesMapper.addServices(service);
		
	}

	public void delServices(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		servicesMapper.delServices(uid);
		
	}

	public List<Services> selectServices(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Services> list = servicesMapper.selectServices(name);
		return list;
	}
	
	public List<Services> getServices(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		List<Services> list = servicesMapper.getServices(uid);
		System.out.println(uid+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		for (Services services : list) {
			
			System.out.println(services.getName());
			System.out.println(services.getUid());
		}
		return list;
	}

	

}
