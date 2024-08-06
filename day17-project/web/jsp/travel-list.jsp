<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();//获取当前web工程的绝对路径
%>
<html>
<head>
    <title>线路列表</title>
    <link rel="stylesheet" href="<%=path%>/css/style.css">
</head>
<%--导入jquery的控件--%>
<script src = "<%=path%>/jQuery/jquery-1.7.2.js"></script>

<script>
    $(function (){
        //绑定单击事件
        $("#qxOrQbx").click(function (){

            let flag = this.checked

            //获取所有的多选框
            $(".cks").each(function (){
                this.checked = flag;
            })

        })
        $("[value = '报名']").click(function (){
            //获取被选中的多选框的长度
            let length = $(".cks:checked").length
            if (length == 1){
                //获取线路线路id
                let tid = $(".cks:checked").val()
                location.href="http://localhost:8082/web/travel?flag=toTravelAdd&tid="+tid;
            }else if (length == 0 ){
                alert("请选择一条线路进行报名");
            }else{
                alert("只能选择一条线路进行报名")
            }
        })

        $("[value = '查看报名信息']").click(function (){
            //获取被选中的多选框的长度
            let length = $(".cks:checked").length
            if (length == 1){
                //获取线路线路id
                let tid = $(".cks:checked").val()
                location.href="http://localhost:8082/web/travel?flag=findTravelAndPassengerById&tid="+tid;
            }else if (length == 0 ){
                alert("请选择一条线路进行查询");
            }else{
                alert("只能选择一条线路进行查询")
            }
        })


    })

    // 修改deleteStuBySids
    function findTravelByTid(){
        //获取被选中的多选框的长度
        let length = $(".cks:checked").length
        if (length == 1){
            //获取线路线路id
            let tid = $(".cks:checked").val()
            location.href="http://localhost:8082/web/travel?flag=findTravelByTid&tid="+$(".cks:checked").val()
        }else if (length == 0 ){
            alert("请选择一条线路进行修改");
        }else{
            alert("只能选择一条线路进行修改")
        }

    }
    //删除
    function deleteTravelById(){
        let length = $(".cks:checked").length
        let tid = ""
        if(length == 0){
            alert("请选择一条线路进行查询");
        }else if (length == 1 ){
            tid = $(".cks:checked").val()
        }else{
            $(".cks:checked").each(function (){
                tid+=","+ this.value
            })
        }
        $.ajax({

            //提交到后端的地址
            url : "http://localhost:8082/web/travel?flag=deleteTravelById",
            //提交的方式
            type : "post",
            //提交到后端的数据
            data : {tid : tid},
            //请求成功之后的回调函数
            success : function (obj){

                if (obj == "true"){
                    alert("删除成功")
                    location.href="http://localhost:8082/web/travel?flag=list"
                }else if(obj == "false00"){
                    alert("删除失败，该线程有游客报名！！")
                }else {
                    alert("删除失败，有问题请联系管理员！！")
                }
            },
            //预期服务器的返回值类型
            dataType : "text"
        })
    }
</script>

<body>

<c:if test="${not empty username}">

    <h1 align="center">携程-欧洲跟团旅游管理</h1>


    <form action="http://localhost:8082/web/travel?flag=list" method="post">
        查询：<input type="text" name="likeName" value="${likeName}">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="搜索" class="btn btn-warning">
    </form>

    <table  class="table">
        <tr>
            <td colspan="10" align="center">
                <input type="button" id="add" value="报名" class="btn btn-info">
                <input type="button"  value="修改" onclick="findTravelByTid()" class="btn btn-info">
                <input type="button" value="删除线路" class="btn btn-warning" onclick="deleteTravelById()">
                <input type="button" value="查看报名信息" class="btn btn-warning" onclick="findStuById(${travel.id})">
            </td>
        </tr>
        <tr>
            <th><input type="checkbox" id="qxOrQbx">全选/全不选</th>
            <th>线路名称</th>
            <th>描述</th>
            <th>报名开始日期</th>
            <th>报名截止日期</th>
            <th>行程开始日期</th>
            <th>线程结束日期</th>
            <th>价格(元/人)</th>
            <th>已报名人数</th>
        </tr>
        <c:forEach items="${travels}" var="travel">
            <tr>
                <td><input type="checkbox" class="cks" value="${travel.id}"></td>
                <td>${travel.travelName}</td>
                <td>${travel.travelDesc}</td>
                <td>${travel.startDate}</td>
                <td>${travel.endDate}</td>
                <td>${travel.tripStart}</td>
                <td>${travel.tripEnd}</td>
                <td>${travel.price}</td>
                <td>${travel.num}</td>
            </tr>
        </c:forEach>
    </table>


</c:if>
<c:if test="${empty username}">
    <h2>还没有登录?</h2>
    <a href="http://localhost:8082/web/jsp/login.jsp">前往登录</a>
</c:if>

</body>
</html>
