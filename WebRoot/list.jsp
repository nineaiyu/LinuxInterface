<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
 
     //跟新回显
     function toupdate(uid){
              //alert(uid);
              $("#div2").css("display","none");
               $.ajax({
                       url:"toupdate.action",
                       type:"get",
                       data:{uid:uid},
                       dataType:"json",
                       success:function(obj){
                               //alert(obj);
                               $("#uid").val(obj.uid);
                               $("#uname").val(obj.uname);
                               $("#age").val(obj.age);
                               $("#sel1").val(obj.did);
                               $("#div1").css("display","block");
                           }
                   })
         }
     //根新
     function update(){
         $("#div1").css("display","none");
     }
     // 新增显示
     function toadd(){
    	 $("#div1").css("display","none");
    	 $("#div2").css("display","block");
         }
     //新增隐藏
     function add(){
    	 $("#div2").css("display","none");
         }
     //删除
     function del(uid){
         if(confirm("您确定要删除uid为"+uid+"的user数据吗")){
             location.href="del.action?uid="+uid;
             }
         }
     //模糊查询
     function search(){
             var item=$("#item").val();
             //alert(item);
             location.href="list.action?item="+item;
         }
     //分页
     function fy(page){
              //alert(page);
              var item=$("#item").val();
            location.href="list.action?page="+page+"&item="+item;
         }
</script>
<body>
<CENTER>
    请输入想要查询的内容<input type="text" id="item" name="item" value="${item }">
    <button onclick="search()">查询</button>
  <table border="1" width="60%">
	    <thead>
	       <tr>
	         <th>uid</th>
	         <th>uname</th>
	         <th>age</th>
	         <th>部门</th>
	         <th>操作
	            <a href="javascript:void(0)" style="text-decoration: none;" onclick="toadd()">新增</a>
	         </th>
	       </tr>
	    </thead>
	    <tbody>
	      <c:if test="${ulist !=null}">
	        <c:forEach items="${ulist}" var="ulist">
	          <tr align="center">
	            <td>${ulist.uid }</td>
	            <td>${ulist.uname }</td>
	            <td>${ulist.age }</td>
	            <td>${ulist.dept.dname }</td>
	            <td>
	              <a href="javascript:void(0)" style="text-decoration: none;" onclick="toupdate(${ulist.uid })">更新</a>
	              <a href="javascript:void(0)" style="text-decoration: none;" onclick="del(${ulist.uid })">删除</a>
	            </td>
	          </tr> 
	        </c:forEach>
	      </c:if>
	      <tr align="center"">
	        <td colspan="10" >
	           <button onclick="fy(1)" style="width: 20%">首页</button>
	           <button onclick="fy(${pageUtils.prevPage})" style="width: 20%">上一页</button>
	           <button onclick="fy(${pageUtils.nextPage})" style="width: 20%">下一页</button>
	           <button onclick="fy(${pageUtils.lastPage})" style="width: 20%">尾页</button>
	        </td>
	      </tr>
	    </tbody>
  </table>
  
  <div id="div1" style="display: none;">
    <form action="update.action" method="post">
      uid<input type="text" id="uid" name="uid" readonly="readonly"><br>
      uname<input type="text" id="uname" name="uname"><br>
      age<input type="text" id="age" name="age"><br>
      部门：<select id="sel1" name="did">
        <c:if test="${dlist !=null}">
          <c:forEach items="${dlist}" var="dlist">
            <option value="${dlist.did }">${dlist.dname}</option>
          </c:forEach>
        </c:if>
      </select>
      <input type="submit" value="更新" onclick="update()">
    </form>
  </div>
  <div id="div2" style="display: none;">
    <form action="add.action" method="post">
      uname<input type="text" id="uname" name="uname"><br>
      age<input type="text" id="age" name="age"><br>
      部门：<select id="sel2" name="did">
        <c:if test="${dlist !=null}">
          <c:forEach items="${dlist}" var="dlist">
            <option value="${dlist.did }">${dlist.dname}</option>
          </c:forEach>
        </c:if>
      </select>
      <input type="submit" value="新增" onclick="add()">
    </form>
  </div>
</CENTER>

</body>
</html>