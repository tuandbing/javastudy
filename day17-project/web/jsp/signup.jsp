<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>注册</h2>
    <form method="post" action="http://localhost:8082/web/travel?flag=signup">
        用户名 : <input type="text" name="username"><br>
        密码 : <input type="password" name="password"><br>

        <a href="http://localhost:8082/web/jsp/login.jsp">已有账号?前往登录</a>
        <input type="submit" value="注册">

    </form>
</center>
</body>
</html>
