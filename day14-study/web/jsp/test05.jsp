<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <table border="1" width="300px" align="center">
          <tr>
              <td>id</td><td>name<td>age</td>
          </tr>
          <c:forEach items="${students}" var="student">
              <tr>
                  <td>${student.sid}</td>
                  <td>${student.sname}</td>
                  <td>${student.age}</td>
              </tr>
          </c:forEach>
      </table>
</body>
</html>
