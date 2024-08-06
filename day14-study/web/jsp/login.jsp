<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/web/emp?flag=login" method="post">
        <label>
            用户名 :
            <input type="text" name="username" value="${cookie.username.value}">
        </label>
        <br/>
        <label>
            密码 :
            <input type="password" name="password" value="${cookie.password.value}">
        </label>
        <br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
