
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();//获取当前web工程的绝对路径
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="">
    用户名 : <input type="text" name="username"><br>
    密码 : <input type="password" name="password"><br>
    <input type="submit" value="登录">

</form>
</body>
</html>
