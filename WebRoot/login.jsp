<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cmdinfos.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <style type="text/css">
/*
给body加了一个边框，可以看出，body已经居中了
*/
body{
	margin:auto;width:200px; border:solid 0px #000;
}
</style> 
  <body >
   
   <h1 margin:auto;>登录</h1><br>
   
   <%
   request.setCharacterEncoding("utf-8");

   response.setCharacterEncoding("utf-8");
   %>
   

   <form action="login.action" method="post">
   
   <table border=1>
  <tr>
  <td>账号:</td>
  <td><input type="text" name="uname" value="${ uname}"></td>
  </tr>
   <tr>
  <td>密码:</td>
  <td><input type="text" name="upass" value="${ upass}"></td>
  </tr>
  <tr><td colspan="2">
    <input type="submit" value="登陆">
    <input type="reset" value="重置"></td></tr>
  </table>
   
   
   </form> 

   
     <%
   if(request.getAttribute("error")!=null)
   {
    %>
   <h3><%=request.getAttribute("error") %></h3>
   <%} %>
   
  </body>
</html>
