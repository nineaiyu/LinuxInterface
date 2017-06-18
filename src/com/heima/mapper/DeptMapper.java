/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:07:26
*/
package com.heima.mapper;

import java.util.List;

import com.heima.pojo.Dept;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:07:26
 */
public interface DeptMapper {
	
	//获取dept列表
	public List<Dept> selectDeptUser() throws Exception;

}
