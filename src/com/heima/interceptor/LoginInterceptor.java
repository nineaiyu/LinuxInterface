package com.heima.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		String sname = (String) session.getAttribute("name");
		String uname = (String) request.getParameter("uname");
		System.out.println("session: "+sname+" -----uname: "+uname);
		if(sname !=null ){
			return true;
		}
		System.out.println("no session!!!!!!!!!");


		// TODO Auto-generated method stub
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

}
