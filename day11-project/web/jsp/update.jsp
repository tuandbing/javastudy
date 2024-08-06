<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>编辑</title>
    <!-- 导入Bootstrap CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
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
<script src = "<%=path%>/jquery/jquery-1.7.2.js"></script>

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
            url : "http://localhost:8080/web/student?flag=toUpdate",
            //提交的方式
            type : "post",
            //提交到后端的数据
            data : $("form").serialize(),
            //请求成功之后的回调函数
            success : function (obj){

                if (obj == "true"){
                    alert("修改成功")
                    location.href="http://localhost:8080/web/student?flag=list"
                }else {
                    alert("修改失败，有问题请联系管理员！！")
                }
            },
            //预期服务器的返回值类型
            dataType : "text"

        })

    }

    function toHome(){
        location.href = "http://localhost:8080/web/student?flag=list";
    }

</script>

<body class="back">

<table class="table table-hover">
</table>

<div class="container container-round">
    <h1 align="center" style="font-size: 30px">编辑</h1>

    <form class="form-horizontal" role="form" style="margin-top: 20px">
        <input type="hidden" name="sid" value="${student.sid}">
        <div class="form-group">
            <label for="studentName" class="col-sm-3 control-label">学生姓名:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="studentName" name="studentName" placeholder="学生姓名" value="${student.studentName}">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">性别:</label>
            <div class="col-sm-6">

                <label>
                    男：<input type="radio"  name="sex" value="1">
                </label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label>
                    女：<input type="radio"  name="sex" value="2">
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="address" class="col-sm-3 control-label">居住地址:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" value="${student.address}" id="address" name="address" placeholder="居住地址">
            </div>
        </div>

        <div class="form-group">
            <label for="birthday" class="col-sm-3 control-label">生日:</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" value="${student.birthday}" id="birthday" name="birthday" placeholder="生日">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">爱好:</label>
            <div class="radio">
                <label>
                    <input type="checkbox" name="hobby" value="打篮球"> 打篮球
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="约会"> 约会
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="敲代码"> 敲代码
                </label>
                <label>
                    <input type="checkbox" name="hobby" value="逛街"> 逛街
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="cid" class="col-sm-3 control-label">所属班级:</label>
            <div class="col-sm-6">

                <select id="cid" class="form-control" name="cid">
                    <option value="0">---请选择---</option>
                </select>
            </div>
        </div>

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
