<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/web/emp?flag=add" method="post">
  <table>
    <tr>
      <td>ename</td><td><input type="text" name="ename"></td>
    </tr>
    <tr>
      <td>age</td><td><input type="text" name="age"></td>
    </tr>
    <tr>
      <td>sex</td><td><input type="text" name="sex"></td>
    </tr>
    <tr>
      <td>address</td><td><input type="text" name="address"></td>
    </tr>
    <tr>
      <td>birthday</td><td><input type="date" name="birthday"></td>
    </tr>
    <tr>
      <td>salary</td><td><input type="text" name="salary"></td>
    </tr>
    <tr>
      <td>did</td><td><input type="text" name="did"></td>
    </tr>

  </table>
  <input type="submit" value="添加">
</form>

</body>
</html>
