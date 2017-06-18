/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 下午05:17:25
*/
package com.heima.vo;

import com.heima.pojo.User;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 下午05:17:25
 */
public class UserVo {
	private User user;
	private String item;
	private Integer startpage;
	private Integer pagesize;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getStartpage() {
		return startpage;
	}
	public void setStartpage(Integer startpage) {
		this.startpage = startpage;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	

}
