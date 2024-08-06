<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息列表</title>
    <style>
        table tr {
            text-align: center;
        }

        #msg {
            height: 300px;
        }

        #search {
            margin-left: 134px;
        }

        h1 {
            padding-top: 30px;
            height: 100px;
            line-height: 100px;
        }
    </style>
    <link rel="stylesheet" href="/css/style.css">
</head>
<script src="/jquery/jquery-1.7.2.js"></script>
<script>
    function page(currentPage) {
        location.href = "http://localhost:8080/product/list?currentPage=" +

            currentPage + "&likeName=${productVo.likeName}&likeArea=${productVo.likeArea}&upTimeEnd=${productVo.upTimeEnd}&upTimeStart=${productVo.upTimeStart}"

    }

    $(function () {

        // 产地下拉框
        $.ajax({
            url:"http://localhost:8080/area/getAreaList",
            type:"post",
            success:function (obj){
                for (let i in obj){
                    $("#area").append("<option value='"+obj[i].areaName+"'>"+obj[i].areaName+"</option>")
                }
            },
            dataType:"json"
        })

        $("[value='添加']").click(function () {
            location.href = "http://localhost:8080/product/toAdd?username=" + $(this).data('value');
        })
        $("[value='查看']").click(function () {
            location.href = "http://localhost:8080/product/show?id=" + $(this).data('value');
        })
        $("[value='全选']").click(function () {
            $(".choose").each(function (){
                this.checked = true
            })
        })
        $("[value='编辑']").click(function () {

            if("${business.username}" != $(this).data("business")){
                alert("您没有权限修改别人的商品喔")
            }else{
                location.href = "http://localhost:8080/product/toUpdate?id=" + $(this).data('value');
            }
        })

        $("[value='批量删除']").click(function () {

            //获取被选中的多选框数目
            let length = $(".choose:checked").length

            // 判断是否有选择删除的条目
            if (length > 0){

                // 判断所选产品是否都属于当前商家
                $(".choose:checked").each(function (){
                    if($(this).data("business") !== "${business.username}"){
                        alert("您不能删除其它商家的产品")
                        location.reload()
                    }else{
                        if (confirm("是否确定要删除")){
                            let ids = "";
                            //获取被选中状态多选框的主键id
                            $(".choose:checked").each(function (){
                                ids += "," + this.value;
                            })

                            // 要删除的id列表
                            ids = ids.substring(1);

                            $.ajax({
                                //提交到后端的地址
                                url : "http://localhost:8080/product/delete",
                                //提交的方式
                                type : "post",
                                //提交到后端的数据
                                data : {ids : ids},
                                //请求成功之后的回调函数
                                success : function (obj){

                                    if (obj == "1"){
                                        alert("删除成功")
                                        location.href="http://localhost:8080/product/list"
                                    }else {
                                        alert("删除失败，有问题请联系管理员！！")
                                    }
                                },
                                //预期服务器的返回值类型
                                dataType : "text"
                            })

                        }
                    }
                })

            }else {
                alert("请至少选择一条数据")
            }
        })
    })
</script>
<body>
<#if business??>
    <h1 align="center">欢迎${business.username}</h1>

    <form action="http://localhost:8080/product/list" method="post" id="search">

        名称查询 :
        <input type="text" value="${productVo.likeName}" name="likeName">
        &nbsp;&nbsp;&nbsp;&nbsp;
        产地查询 :
        <select name="likeArea" id="area">
            <option value="">请选择产地</option>
            <#if productVo.likeArea??>
                <option selected value='${productVo.likeArea}'>${productVo.likeArea}</option>
            </#if>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;
        区间查询：
        <input type="date" name="upTimeStart" value="${productVo.upTimeStart}">--<input type="date" name="upTimeEnd" value="${productVo.upTimeEnd}">

        <input type="submit" value="搜索"><br/>
    </form>
    <form id="msg">
        <table width="80%" border="1px" align="center">
            <tr>
                <td colspan="4"><input type="button" value="批量删除"></td>
                <td colspan="4"><input type="button" value="添加" data-value="${business.username}"></td>
            </tr>
            <tr>
                <td><input type="button" value="全选"></td>
                <td>编号</td>
                <td>名称</td>
                <td>产地</td>
                <td>价格</td>
                <td>商家</td>
                <td>描述</td>
                <td>操作</td>
            </tr>
            <#list productList as product>
                <tr>
                    <td><input type="checkbox" name="choose" class="choose" value="${product.id}" data-business="${product.business.username}"></td>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.area.areaName}</td>
                    <td>${product.price}</td>
                    <td>${product.business.username}</td>
                    <td>${product.feature}</td>
                    <td>
                        <input type="button" value="查看" data-value="${product.id}">
                        <input type="button" value="编辑" data-value="${product.id}" data-business="${product.business.username}">
                    </td>
                </tr>
            </#list>
            <tr>
                <td colspan="20" align="center">
                    当前页${pageUtils.currentPage}/${pageUtils.lastPage}
                    <a href="#" onclick="page(1)">首页</a>
                    <a href="#" onclick="page(${pageUtils.prevPage})">上一页</a>
                    <a href="#" onclick="page(${pageUtils.nextPage})">下一页</a>
                    <a href="#" onclick="page(${pageUtils.lastPage})">尾页</a>
                </td>
            </tr>
        </table>
    </form>
<#else>
    <a href="http://localhost:8080/business/toLog">您还没有登录,请前往登录</a>
</#if>

</body>
</html>