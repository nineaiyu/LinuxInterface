<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'siteinfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">

	function CreateUser() {
		//         document.getElementById("acts").value="createuser";
		//         document.forms[0].submit();
		//  Location.href="siteinfos?cmdacts=createuser";
		location.href = "siteinfos.action?cmdacts=createuser";
	}
	function DeleteUser() {

		location.href = "siteinfos.action?cmdacts=deleteuser";

	}
	function flashes() {
		location.href = "serviceget.action";
	}
	function flashapps() {
		location.href = "appget.action";
	}

	function del(uid) {
		// 		if (confirm("您确定要删除uid为" + uid + "的user数据吗")) {
		location.href = "delservice.action?uid=" + uid;
		// 		}
	}

	function serviceinit() {

		location.href = "serviceinit.action";

	}
	function k8sinit() {

		location.href = "k8sinit.action";

	}

	function appnamechange() {
		var objS = document.getElementById("appname");
		var grades = objS.options[objS.selectedIndex].value;
		location.href = "appversionsget.action?appname=" + grades;
	}

	function appversionschange() {
		var objS = document.getElementById("appversion");
		var grades = objS.options[objS.selectedIndex].value;
		location.href = "setappversions.action?appversion=" + grades;
	}

	function testcmds() {
		location.href = "sshcmdinfos.jsp";
	}

	
	function getwebshellurl(uid) {
		location.href = "getwebshellurl.action?uid="+ uid;
	}
	
	
	
</script>

</head>

<body>
	<%
   if(session.getAttribute("name")==null){
   response.sendRedirect("login.jsp"); 
   }
    %>
	<h1>
		欢迎<%=session.getAttribute("name") %>光临
	</h1>
	<table>
		<tr>
			<td><input type="button" onclick="CreateUser()" value="创建用户">
<!-- 				<input type="button" onclick="DeleteUser()" value="删除用户"> 	<input type="button"  onclick="flashes()" value="测试刷新"> -->
				<input type="button" onclick="flashapps()" value="刷新app"> <input
				type="button" onclick="testcmds()" value="ssh命令"> </td>
		</tr>
	</table>
	<table border=1>

		<c:forEach items="${ftpinfos }" var="ftpinfos">
			<tr>
				<td>${ftpinfos }</td>
			</tr>
		</c:forEach>

	</table>


	<br>
	<hr>
	<h3>服务初始化信息</h3>
	<table border=1>

		<tr>

			<td>服务名称</td>
			<td>服务版本</td>
			<td>服务选择</td>
			<td>服务操作</td>
			
		</tr>

		<tr>
			<td><select id="appname" onchange="appnamechange()">
					<c:if test="${appnames !=null}">
						<c:forEach items="${appnames}" var="appnames">
							<c:choose>
								<c:when test="${ appselected==appnames.appname}">
									<option value="${appnames.appname }" selected="selected">${appselected}</option>
								</c:when>
								<c:otherwise>
									<option value="${appnames.appname }">${appnames.appname}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
			</select></td>

			<td><select id="appversion" onchange="appversionschange()">
					<c:if test="${appversion !=null}">
						<c:forEach items="${appversion}" var="appversion">
							<c:choose>
								<c:when test="${ appversionsselected==appversion.versions}">
									<option value="${appversion.versions }" selected="selected">${appversion.versions}</option>
								</c:when>
								<c:otherwise>
									<option value="${appversion.versions }">${appversion.versions}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
			</select></td>
			<td><input type="button" ${buttonvalue} onclick="serviceinit()"
				value="添加"></td>
			<td><input type="button" onclick="k8sinit()" value="初始化"></td>
			

		</tr>


		<!--    <c:if test="${slist !=null}"> -->
		<!-- 	        <c:forEach items="${slist}" var="slist"> -->
		<!-- 	          <tr> -->
		<!-- 	            <td>服务标识</td> -->
		<!-- 	            <td> -->


		<!-- 			            <select > -->
		<!-- 		        		<c:if test="${appnames !=null}"> -->
		<!-- 		          		<c:forEach items="${appnames}" var="appname"> -->
		<!-- 		           		 <option value="${appnames.appname }">${appnames.appname}</option> -->
		<!-- 		          		</c:forEach> -->
		<!-- 		        		</c:if> -->
		<!-- 		      			</select>	        -->

		<!-- 				</td> -->
		<!-- 	            <td> -->
		<!-- 			            <select id="sel1" name="did"> -->
		<!-- 		        		<c:if test="${dlist !=null}"> -->
		<!-- 		          		<c:forEach items="${dlist}" var="dlist"> -->
		<!-- 		           		 <option value="${dlist.did }">${dlist.dname}</option> -->
		<!-- 		          		</c:forEach> -->
		<!-- 		        		</c:if> -->
		<!-- 		      			</select> -->
		<!-- 	            </td> -->
		<!-- 	            <td><a href="javascript:void(0)" style="text-decoration: none;" onclick="add(${ulist.uid })">添加</a></td> -->
		<!-- 	          </tr>  -->
		<!-- 	        </c:forEach> -->
		<!-- 	      </c:if> -->









	</table>




	<hr>
	<h3>服务基本信息</h3>


	<table border=1>
		<tr>
			<td>服务标识</td>
			<td>服务所属</td>
			<td>服务名称</td>
			<td>服务版本</td>
			<td>IP:端口</td>
			<td>服务账号</td>
			<td>服务密码</td>
			<td>服务操作</td>
			<td>webshellurl</td>

		</tr>
		<c:if test="${ulist !=null}">
			<c:forEach items="${ulist}" var="ulist">
				<tr align="center">
					<td>${ulist.uid }</td>
					<td>${ulist.name }</td>
					<td>${ulist.servicename }</td>
					<td>${ulist.serviceversion }</td>
					<td>${ulist.ipandport }</td>
					<td>${ulist.account }</td>
					<td>${ulist.password }</td>
					<td><a href="javascript:void(0)"
						style="text-decoration: none;" onclick="del(${ulist.uid })">删除</a></td>
					<td><a href="javascript:void(0)"
						style="text-decoration: none;" onclick="getwebshellurl(${ulist.uid })">获取</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>



     <%
   if(request.getSession().getAttribute("webshellurl")!=null)
   {
   	out.println( "<script> alert( 'webshellurl : "+ request.getSession().getAttribute("webshellurl") + " ') ;</script> ");
    //request.getSession().setAttribute("webshellurl", null);
    %>
    
   <h3><%=request.getSession().getAttribute("webshellurl") %></h3>
   <%
   request.getSession().setAttribute("webshellurl", null);
   } %>


</body>
</html>
