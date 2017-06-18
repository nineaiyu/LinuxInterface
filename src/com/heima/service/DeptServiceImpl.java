/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 下午03:14:04
*/
package com.heima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.heima.mapper.DeptMapper;
import com.heima.pojo.Dept;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 下午03:14:04
 */
@Service("deptService")
public class DeptServiceImpl implements DeptServiceI{
	
	
	@Autowired
	@Qualifier("deptMapper")
	private DeptMapper deptMapper;

	//获取dept列表
	public List getDList() throws Exception {
		// TODO Auto-generated method stub
		List<Dept> list = deptMapper.selectDeptUser();
		return list;
	}

}
