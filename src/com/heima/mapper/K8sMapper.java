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
import com.heima.pojo.K8s;


/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:07:10
 */
//@Repository("k8sMapper")
public interface K8sMapper {
	
	public List<K8s> selectK8sInfos(String NamespaceName) throws Exception;
	
	public void updateK8s(K8s k8s) throws Exception;

	public void addK8s(K8s k8s) throws Exception;

	public void delK8s(K8s k8s) throws Exception;
	
	public List<String> getWebShellUrl(String NamespaceName,String appname,String DomeosIPort) throws Exception;
 
}
