<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="../jquery/jquery-1.7.2.js"></script>
<body>
  <h2>学生信息表</h2>
  <table border="1">
    <tr>
      <td>name</td><td>sex</td><td>birth</td><td>department</td><td>address</td>
    </tr>
    <c:forEach items="${students}" var="student">
      <tr>
        <td>${student.name}</td><td>${student.sex}</td><td>${student.birth}</td><td>${student.department}</td><td>${student.address}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
