<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();//获取当前web工程的绝对路径
    int index = 1;
%>
<html>
<head>
    <title>查看报名旅客</title>
    <link rel="stylesheet" href="<%=path%>/css/style.css">
</head>
<%--导入jquery的控件--%>
<script src = "<%=path%>/jQuery/jquery-1.7.2.js"></script>
<%--<script>
    window.onload = function (){
        const nums = document.getElementsByClassName("num");
        for (let i = 0; i < nums.length; i++) {
            nums[i].innerHTML  = (i + 1).toString();
        }
    }
</script>--%>

<body>

<h1 align="center">查看报名旅客</h1>
<hr>
线路名称：${travel.travelName};报名人数：${travel.num}
<table  class="table">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>手机号码</th>
        <th>身份证号</th>
        <th>报名时间</th>
    </tr>
        <c:forEach items="${travel.passengers}" var="passenger">
            <tr>
<%--                <td class="num"></td>--%>
                <td><%=index++%></td>
                <td>${passenger.name}</td>
                <td>${passenger.sex == 1 ? "男" : "女"}</td>
                <td>${passenger.birthday}</td>
                <td>${passenger.phone}</td>
                <td>${passenger.idCard}</td>
                <td>${passenger.signDate}</td>

            </tr>
        </c:forEach>

</table>



</body>
</html>
