<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/3/16
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>便民超市</title>
</head>
<meta charset="utf-8">
<%
    request.setCharacterEncoding("utf-8");
    String account = request.getParameter("account");
    String password = request.getParameter("password");
    session.setAttribute("username",account);
    if(!account.equals("123") || !password.equals("123")){
%>
<script>
    alert("账号或密码错误");
    window.location.href = "http://localhost:8080/web/jsp/homework2/login.jsp";
</script>
<%
        //response.sendRedirect("http://localhost:8080/web/jsp/homework2/login.jsp");
    }
%>

<body>
    <h1 style="text-align: center">便民超市欢迎您的到来！</h1>

    <h2>您好！<% out.print(session.getAttribute("username")); %>&nbsp;<a href="login.jsp">点击重退出登录</a></h2>
    <br>
    <form action="" method="post">
        <fieldset>
            <input type="checkbox" name="food" value="黄瓜"> 黄瓜 &nbsp;&nbsp;&nbsp;| 1.6 元 / kg &nbsp;&nbsp;&nbsp;&nbsp;
            斤两：<input type="number" name="weight" min="0" step="0.01">kg
            <br>
            <input type="checkbox" name="food" value="茄子"> 茄子 &nbsp;&nbsp;&nbsp;| 2.4 元 / kg &nbsp;&nbsp;&nbsp;&nbsp;
            斤两：<input type="number" name="weight" min="0" step="0.01">kg
            <br>
            <input type="checkbox" name="food" value="猪肉"> 猪肉 &nbsp;&nbsp;&nbsp;| 11.5 元 / kg &nbsp;&nbsp;&nbsp;&nbsp;
            斤两：<input type="number" name="weight" min="0" step="0.01">kg
            <br>
            <input type="checkbox" name="food" value="葱"> 葱 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 3.0 元 / kg &nbsp;&nbsp;&nbsp;&nbsp;
            斤两：<input type="number" name="weight" min="0" step="0.01">kg
            <br>
            <input type="checkbox" name="food" value="姜"> 姜 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 4.2 元 / kg &nbsp;&nbsp;&nbsp;&nbsp;
            斤两：<input type="number" name="weight" min="0" step="0.01">kg
            <br>
            <input type="checkbox" name="food" value="蒜"> 蒜 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 1.8 元 / kg &nbsp;&nbsp;&nbsp;&nbsp;
            斤两：<input type="number" name="weight" min="0" step="0.01">kg
            <br>
            <input type="checkbox" name="food" value="鸡胸肉"> 鸡胸肉 | 9.9 元 / kg &nbsp;&nbsp;&nbsp;&nbsp;
            斤两：<input type="number" name="weight" min="0" step="0.01">kg
            <br>
            <input type="submit" value="加入购物车">
            <p>
                <a href="check.jsp">去结账！</a>
            </p>
            <%
                request.setCharacterEncoding("utf-8");
                String[] goods = request.getParameterValues("food");
                if (goods != null && goods.length != 0){
                    for (int i = 0 ; i < goods.length ; i++){
                        session.setAttribute("goods",goods);
                    }
                }
                String[] weights = request.getParameterValues("weight");
                String[] weight = new String[10];
                int count = 0;
                if (weights != null && weights.length != 0){
                    for (int i = 0 ; i < weights.length ; i++){
                        if(weights[i] != ""){
                            weight[count++] = weights[i];
                        }
                        session.setAttribute("weights",weight);
                    }
                }

            %>
        </fieldset>

    </form>

</body>
</html>
