<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/3/16
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>便民超市网购登陆界面</title>
</head>
<body>
    <h1 style="text-align: center">便民超市网购登陆界面</h1>
    <br>
    <br>
    <br>
    <br>
       <form action="purchase.jsp">
           <fieldset>
               <legend>请登录</legend>
               账号<input type="text" name="account" id="account" required>
               <br>
               密码<input type="password" name="password" id="password" required>
               <br>
               <br>
               <input type="submit" value="登录">
           </fieldset>
       </form>
</body>
<%--<script>
    function checkAccount() {
        var userName = document.getElementById("account").value;
        var password = document.getElementById("password").value;

        if (userName === "123" && password === "123"){
            window.location.href = "/web/jsp/homework2/purchase.jsp";
        }else {
            alert("账号或密码错误");
        }
    }
</script>--%>
</html>
