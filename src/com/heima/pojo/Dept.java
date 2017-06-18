/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:06:21
*/
package com.heima.pojo;

import java.util.List;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:06:21
 */
public class Dept {
	private Integer did;
	private String dname;
	private List<User> user;
	
	/**
	 * 
	 */
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param did
	 * @param dname
	 */
	public Dept(Integer did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + "]";
	}
	

}
