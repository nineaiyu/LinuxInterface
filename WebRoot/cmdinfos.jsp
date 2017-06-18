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
  
  <body>
   <%
   if(session.getAttribute("name")==null){
   response.sendRedirect("login.jsp"); 
   }
    %>
   <h1>登陆成功，欢迎<%=session.getAttribute("name") %>光临</h1>
   <a href="exits.action">退出登录</a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <a href="appget.action">后台管理</a>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <a href="sshcmdinfos.jsp">sshcmdtest</a>
   
   
   <%
   request.setCharacterEncoding("utf-8");

   response.setCharacterEncoding("utf-8");
   %>
   

   <form action="command.action" method="post">
   
   <table border=1>
   
   <tr><td colspan=2>执行命令</td></tr>
	


    <tr>
    <td>命令如下</td>
    </tr>
    <tr>
    <td> <input type="text" name="command" value="${ info}" > <input type="submit" value="执行"> </td>
    </tr>
     
     
      <c:forEach items="${infos }" var="infos">
         <tr>
           <td>${infos }</td>
         </tr>
      </c:forEach>
   </table>
   
   
   </form> 

   
    
   
  </body>
</html>
