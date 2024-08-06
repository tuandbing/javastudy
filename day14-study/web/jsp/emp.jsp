<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${not empty user}">
  <h1 align="center" >员工信息</h1>


  <form action="http://localhost:8080/web/emp?flag=findEmpByName" method="post">
    <input type="text" name="likeName" value="${likeName}"> <input type="submit" value="查询">
  </form>
  欢迎<span style="color: red">${user.username}</span>
  <table border="2px"  width="600px" align="center">
    <tr>
      <td colspan="10" align="center">
        <a href="toAdd.jsp">添加学生</a>
      </td>
    </tr>
    <tr>
      <td>eid</td><td>ename</td><td>age</td><td>sex</td><td>address</td><td>birthday</td><td>salary</td><td>did</td><td>operate</td>
    </tr>
    <c:forEach items="${emps}" var="emp">
      <tr>
        <td>${emp.eid}</td>
        <td>${emp.ename}</td>
        <td>${emp.age}</td>
        <td>${emp.sex}</td>
        <td>${emp.address}</td>
        <td>${emp.birthday}</td>
        <td>${emp.salary}</td>
        <td>${emp.did}</td>
        <td>
          <a href="http://localhost:8080/web/emp?flag=findEmpById&eid=${emp.eid}">编辑</a>
          <a href="http://localhost:8080/web/emp?flag=delete&eid=${emp.eid}">删除</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<c:if test="${empty user}">
  <a href="http://localhost:8080/web/jsp/login.jsp">您还没有登录，请前往登录页面进行登陆！！！</a>
</c:if>
</body>
</html>
