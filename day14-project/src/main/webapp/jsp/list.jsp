<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">员工信息</h1>
<table border="2px"  width="600px" align="center">
    <tr>
        <td>eid</td><td>ename</td><td>age</td><td>sex</td><td>address</td><td>birthday</td><td>salary</td><td>did</td>
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
        </tr>
    </c:forEach>
</table>
</body>
</html>

</body>
</html>
