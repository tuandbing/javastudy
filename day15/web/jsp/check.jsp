<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.DecimalFormatSymbols" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/3/16
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
    <h1 style="text-align: center">请确认您的购物车</h1>
    <h2>您好！<% out.print(session.getAttribute("username")); %>&nbsp;<a href="login.jsp">点击重退出登录</a></h2>
    <hr>
    <h2>有什么？<br>
        <%
        response.setContentType("text/html;charset=utf-8");

        String[] goods = (String[]) session.getAttribute("goods") ;
        String[] weights = (String[]) session.getAttribute("weights");
        Double[] finalPrice = new Double[goods.length];
        DecimalFormat df = new DecimalFormat("#.##",new DecimalFormatSymbols(Locale.US));
        if (goods != null){
            for (int i = 0;i < goods.length ; i++){
                double price = 0;
                out.println("&nbsp;&nbsp;" + goods[i] + "&nbsp;");
                out.println("&nbsp;&nbsp;" + Double.parseDouble(weights[i]) + "kg&nbsp;");
                switch (goods[i]){
                    case "黄瓜": price = 1.6;break;
                    case "茄子": price = 2.4;break;
                    case "猪肉": price = 11.5;break;
                    case "葱": price = 3.0;break;
                    case "姜": price = 4.2;break;
                    case "蒜": price = 1.8;break;
                    case "鸡胸肉": price = 9.9;break;
                }
                System.out.println(weights[i]);
                double price2 = price * Double.parseDouble(weights[i]);
                String formattedPrice = df.format(price2);
                out.println("&nbsp;&nbsp;单价" + price+ "元/kg&nbsp;&nbsp;计" + formattedPrice +"元<br>");

                finalPrice[i] = price2;
            }
        }
        double sum = 0;
        for (int i =0;i<finalPrice.length;i++){
            sum += finalPrice[i];
        }
        String formattedSum = df.format(sum);
        out.println("<br><hr>总计:" + formattedSum +"元");
        %>
    </h2>
    <button>去结账！</button>
</body>
</html>
