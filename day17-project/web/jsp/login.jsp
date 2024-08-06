<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>登录</h2>
    <form method="post" action="http://localhost:8082/web/travel?flag=login">
        <label>
            用户名 :
            <input type="text" name="username">
        </label>
        <br/>
        <label>
            密码 :
            <input type="password" name="password">
        </label>
        <br/>
        <a href="http://localhost:8082/web/jsp/signup.jsp">还没有账号?前往注册</a>
        <input type="submit" value="登录">

    </form>
</center>
</body>
</html>
