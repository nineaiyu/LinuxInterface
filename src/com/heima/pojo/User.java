/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 上午11:05:30
*/
package com.heima.pojo;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 上午11:05:30
 */
public class User {

	 private Integer uid;

	    private String uname;

	    private Integer age;

	    private Integer did;
	    private Dept dept;
		public Integer getUid() {
			return uid;
		}
		public void setUid(Integer uid) {
			this.uid = uid;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public Integer getDid() {
			return did;
		}
		public void setDid(Integer did) {
			this.did = did;
		}
		public Dept getDept() {
			return dept;
		}
		public void setDept(Dept dept) {
			this.dept = dept;
		}
		/**
		 * 
		 */
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * @param uid
		 * @param uname
		 * @param age
		 * @param did
		 * @param dept
		 */
		public User(Integer uid, String uname, Integer age, Integer did,
				Dept dept) {
			super();
			this.uid = uid;
			this.uname = uname;
			this.age = age;
			this.did = did;
			this.dept = dept;
		}
		@Override
		public String toString() {
			return "User [age=" + age + ", dept=" + dept + ", did=" + did
					+ ", uid=" + uid + ", uname=" + uname + "]";
		}
	    

	   
		
	    
}
