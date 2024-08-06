<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();//获取当前web工程的绝对路径
%>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<%--导入jquery的控件--%>
<script src = "<%=path%>/jquery/jquery-1.7.2.js"></script>

<script>

    //文本就绪函数
    $(function (){
        //绑定单击事件
        $("#add").click(function (){
             location.href = "http://localhost:8080/web/jsp/add.jsp";
        })

        //绑定单击事件
        $("#qxOrQbx").click(function (){

            let flag = this.checked

            //获取所有的多选框
            $(".cks").each(function (){
                this.checked = flag;
            })

        })
    })

    //访问后端根据学生id查询学生记录
    function findStuById(sid){

        location.href = "http://localhost:8080/web/student?flag=findStuById&sid="+sid;
    }

    //删除
    function deleteStuBySid(sid){

        $.ajax({
            //提交到后端的地址
            url : "http://localhost:8080/web/student?flag=deleteStuBySid",
            //提交的方式
            type : "post",
            //提交到后端的数据
            data : {sid : sid},
            //请求成功之后的回调函数
            success : function (obj){

                if (obj == "true"){
                    alert("删除成功")
                    location.href="http://localhost:8080/web/student?flag=list"
                }else {
                    alert("删除失败，有问题请联系管理员！！")
                }
            },
            //预期服务器的返回值类型
            dataType : "text"
        })
    }

    //删除
    function deleteStuBySids(){

        //获取被选中的多选框
        let length = $(".cks:checked").length
        if (length > 0){
            if (confirm("是否确定要删除")){
                let sids = "";
                //获取被选中状态多选框的主键id
                $(".cks:checked").each(function (){
                    sids += ","+this.value;
                })
                sids = sids.substring(1);

                $.ajax({
                    //提交到后端的地址
                    url : "http://localhost:8080/web/student?flag=deleteStuBySids",
                    //提交的方式
                    type : "post",
                    //提交到后端的数据
                    data : {sids : sids},
                    //请求成功之后的回调函数
                    success : function (obj){

                        if (obj == "true"){
                            alert("删除成功")
                            location.href="http://localhost:8080/web/student?flag=list"
                        }else {
                            alert("删除失败，有问题请联系管理员！！")
                        }
                    },
                    //预期服务器的返回值类型
                    dataType : "text"
                })

            }

        }else {
            alert("请至少选择一条数据")
        }

    }




</script>

<body>


    <h1 align="center">学生列表</h1>


    <form action="http://localhost:8080/web/student?flag=list" method="post">
        根据姓名模糊查询：<input type="text" name="likeName" value="${likeName}">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="搜索" class="btn btn-warning">
    </form>

    <table  class="table">
        <tr>
            <td colspan="10" align="center">
                <input type="button" id="add" value="添加学生" class="btn btn-info">
                <input type="button"  value="批量删除" onclick="deleteStuBySids()" class="btn btn-info">
            </td>
        </tr>
        <tr>
            <th><input type="checkbox" id="qxOrQbx">全选/全不选</th>
            <th>学生姓名</th>
            <th>性别</th>
            <th>居住地址</th>
            <th>生日</th>
            <th>爱好</th>
            <th>所属班级</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${studentList}" var="stu">
            <tr>
                <td><input type="checkbox" class="cks" value="${stu.sid}"></td>
                <td>${stu.studentName}</td>
                <td>${stu.sex == 1 ? '男' : '女'}</td>
                <td>${stu.address}</td>
                <td>${stu.birthday}</td>
                <td>${stu.hobby}</td>
                <td>${stu.clazz.className}</td>
                <td>
                    <input type="button" value="删除" class="btn btn-warning" onclick="deleteStuBySid(${stu.sid})">
                    <input type="button" value="编辑" class="btn btn-warning" onclick="findStuById(${stu.sid})">
                </td>
            </tr>
        </c:forEach>
    </table>



</body>
</html>
