<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
<form method="post" action="${pageContext.request.contextPath}/user/login">
    用户名 : <input type="text" name="username"><br>
    密码 : <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
