<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="http://localhost:8080/web/servlet?method=login" method="post">
    用户名 : <input type="text" name="username">
      <br/>
    密码 : <input type="password" name="password">
      <br/>
    <input type="submit" value="登录">
  </form>
</body>
</html>
