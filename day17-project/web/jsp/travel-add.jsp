<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>添加学生</title>
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

    //报名游客
    function toAdd(){
        //取到线路id的值
        $.ajax({
            url:"http://localhost:8082/web/travel?flag=addPassenger&tid="+${tid},
            type:"post",
            data:$("form").serialize(),
            success:function (obj){
                if (obj == "true"){
                    alert("报名成功");
                    location.href="http://localhost:8082/web/travel?flag=list"
                }else {
                    alert("报名失败")
                }
            },
            dataType:"text"
        })
    }

</script>

<body class="back">
<table align="center" class="table table-hover">
    <div class="container container-round">
        <h1 align="center" style="font-size: 30px">报名</h1>

        <form class="form-horizontal" role="form" style="margin-top: 20px">
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">姓名:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="name" name="name">
                </div>
            </div>

            <div class="form-group">
                <label>性别:</label>
                <div class="radio">
                    <label>
                        男：<input type="radio" name="sex" value="1">
                    </label>
                    <label>
                        女：<input type="radio" name="sex" value="2">
                    </label>
                </div>
            </div>


            <div class="form-group">
                <label for="birthday" class="col-sm-3 control-label">出生日期:</label>
                <div class="col-sm-6">
                    <input type="date" class="form-control" id="birthday" name="birthday">
                </div>
            </div>

            <div class="form-group">
                <label for="phone" class="col-sm-3 control-label">手机号码:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="phone" name="phone">
                </div>
            </div>

            <div class="form-group">
                <label for="idCard" class="col-sm-3 control-label">身份证号:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="idCard" name="idCard">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                    <input type="button" class="btn btn-info" value="保存" onclick="toAdd()">
                </div>
            </div>
        </form>
    </div>
</table>

</body>

</html>
