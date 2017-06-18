package com.heima.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class GetSession {
	public static Boolean getsession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sname = (String) session.getAttribute("name");
		String uname = (String) request.getParameter("uname");
		System.out.println("sessionsi: "+sname+" -----uname: "+uname);
		if(sname !=null ){
			return true;
		}
		System.out.println("no session!!!!!!!!!");
		return false;
		
	}

}
