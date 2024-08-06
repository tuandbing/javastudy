<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/web/emp?flag=update" method="post">
  <input type="hidden" name="eid" value="${emp.eid}">
  <table>
    <tr>
      <td>ename</td><td><input type="text" name="ename" value="${emp.ename}"></td>
    </tr>
    <tr>
      <td>age</td><td><input type="text" name="age" value="${emp.age}"></td>
    </tr>
    <tr>
      <td>sex</td><td><input type="text" name="sex" value="${emp.sex}"></td>
    </tr>
    <tr>
      <td>address</td><td><input type="text" name="address" value="${emp.address}"></td>
    </tr>
    <tr>
      <td>birthday</td><td><input type="date" name="birthday" value="${emp.birthday}"></td>
    </tr>
    <tr>
      <td>salary</td><td><input type="text" name="salary" value="${emp.salary}"></td>
    </tr>
    <tr>
      <td>did</td><td><input type="text" name="did" value="${emp.did}"></td>
    </tr>

  </table>
  <input type="submit" value="修改">
</form>
</body>
</html>
