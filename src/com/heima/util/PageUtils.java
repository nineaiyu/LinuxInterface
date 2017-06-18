/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-9-29 下午04:52:03
*/
package com.heima.util;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-9-29 下午04:52:03
 */
public class PageUtils {
	//定义分页的相关参数
	int currentPage=0;
	int prevPage=0;
	int nextPage=0;
	int lastPage=0;
	int pageSize=0;
	int count=0;

	
	public PageUtils(int count,String page,int pageSize) {
		initcurrentPage(page);
		initprevPage();
		//this.count=count;
		//this.pageSize=pageSize;
		initlastPage(count,pageSize);
		initnextPage();
		System.out.println("-------------------");
		
		
	}
	private void initnextPage() {
		//确定下一页的值
		if(currentPage==lastPage){
			nextPage=currentPage;
		}else{
			nextPage=currentPage+1;
		}
		System.out.println("nextpage-->"+nextPage);
	}
	private void initlastPage(int count,int pageSize) {
		//通过count/pageSize确定最后一页的值
		lastPage=count/pageSize;
		if(count%pageSize!=0){
			lastPage+=1;
		}
		System.out.println("lastpage-->"+lastPage);
	}
	private void initprevPage() {
		
		//确定当前页与上一页的值
		if(currentPage==1){
			prevPage=currentPage;
		}else{
			prevPage=currentPage-1;
		}
		System.out.println("prevpage-->"+prevPage);
		
	}
	private void initcurrentPage(String page) {
		System.out.println("page-->"+page);
		if(page==null){
			page="1";
		}
		currentPage=Integer.parseInt(page);	
		System.out.println("currentPage-->"+currentPage);
	}
	

	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPrevPage() {
		return prevPage;
	}


	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}


	public int getLastPage() {
		return lastPage;
	}


	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	

}
