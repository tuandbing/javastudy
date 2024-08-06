<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>编辑</title>
    <!-- 导入Bootstrap CSS 文件 -->
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
    <style>
        .back {
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: #E4E4E4;
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        .container-round {
            background-color: rgba(255,255,255,0.5);
            width: 736px;
            border-radius: 10px;
            margin-top: 40px
        }
    </style>
</head>
<%--导入jquery的控件--%>
<script src = "<%=path%>/jQuery/jquery-1.7.2.js"></script>

<script>

    $(function (){


        //追加下拉列表
        <c:forEach items="${classList}" var="clazz">
            $("#cid").append("<option value='${clazz.cid}'>${clazz.className}</option>")
        </c:forEach>


        //回显单选框
        let sex = '${student.sex}'
        $("[name = 'sex']").each(function (){
            if (this.value == sex ){
                this.checked = true;
            }
        })

        //回显多选框
        let hobby = '${student.hobby}'

        let hobbyArray = hobby.split(",")

        for (let i = 0 ; i < hobbyArray.length ; i++){
            //遍历所有爱好的多选框
            $("[name = 'hobby']").each(function (){
                if (this.value == hobbyArray[i]){
                    this.checked = true;
                }
            })
        }

        //下拉列表数据的回显
        let cid = '${student.cid}'
        //alert(cid)
        $("#cid option").each(function (){
           //alert(this.value)
            if (this.value == cid){
                this.selected = true;
            }
        })



    })

    //执行添加
    function toUpdate(){
        $.ajax({
            //提交到后端的地址
            url : "http://localhost:8082/web/travel?flag=toUpdate",
            //提交的方式
            type : "post",
            //提交到后端的数据
            data : $("form").serialize(),
            //请求成功之后的回调函数
            success : function (obj){

                if (obj == "true"){
                    alert("修改成功")
                    location.href="http://localhost:8082/web/travel?flag=list"
                }else {
                    alert("修改失败，有问题请联系管理员！！")
                }
            },
            //预期服务器的返回值类型
            dataType : "text"

        })

    }

    function toHome(){
        location.href = "http://localhost:8082/web/travel?flag=list";
    }

</script>

<body class="back">

<table class="table table-hover">
</table>

<div class="container container-round">
    <h1 align="center" style="font-size: 30px">编辑</h1>

    <form class="form-horizontal" role="form" style="margin-top: 20px">
        <input type="hidden" name="id" value="${travel.id}">
        <div class="form-group">
            <label for="travelName" class="col-sm-3 control-label">线路名称:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="travelName" name="travelName" value="${travel.travelName}">
            </div>
        </div>

        <div class="form-group">
            <label for="travelDesc" class="col-sm-3 control-label">线路描述:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="travelDesc" name="travelDesc" value="${travel.travelDesc}">
            </div>
        </div>

        <div class="form-group">
            <label for="startDate" class="col-sm-3 control-label">报名开始日期:</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" value="${travel.startDate}" id="startDate" name="startDate">
            </div>
        </div>

        <div class="form-group">
            <label for="endDate" class="col-sm-3 control-label">报名结束日期:</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" value="${travel.startDate}" id="endDate" name="endDate">
            </div>
        </div>

        <div class="form-group">
            <label for="tripStart" class="col-sm-3 control-label">行程开始日期:</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" value="${travel.tripStart}" id="tripStart" name="tripStart">
            </div>
        </div>

        <div class="form-group">
            <label for="tripEnd" class="col-sm-3 control-label">行程结束日期:</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" value="${travel.tripEnd}" id="tripEnd" name="tripEnd">
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="col-sm-3 control-label">价格(元/人)</label>
            <div class="col-sm-6">
                <input type="number" class="form-control" value="${travel.price}" id="price" name="price">
            </div>
        </div>

        <input type="hidden" name="num" value="${travel.num}">


        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-6">
                <input type="button" class="btn btn-info" value="编辑" onclick="toUpdate()">
                <input type="button" class="btn btn-warning" value="取消" onclick="toHome()">
            </div>
        </div>
    </form>
</div>

</body>

</html>
