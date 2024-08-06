<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息更新</title>
    <style>
        table tr td:last-child{
            width: 200px;
            height: 40px;
            line-height: 40px;
            text-align: center;
        }
        table tr td:first-child{
            width: 100px;
            background-color: yellow;
            height: 40px;
            line-height: 40px;
            text-align: center;
        }
        table{
            border-spacing: 0;

            border-collapse: collapse;
        }
    </style>
</head>
<script src="/jquery/jquery-1.7.2.js"></script>
<script>
    $(function (){

        // 获取商家下拉列表
        $.ajax({
            url:"http://localhost:8080/business/findBusinessAll",
            data: "",
            type:"post",
            success:function (obj){
                for (let i in obj){
                    $("#business").append("<option value='"+obj[i].id+"'>"+obj[i].username+"</option>")
                }
            },
            dataType:"json"
        })

        // 获取产地下拉列表
        $.ajax({
            url:"http://localhost:8080/area/getAreaList",
            data: "",
            type:"post",
            success:function (obj){
                for (let i in obj){
                    $("#area").append("<option value='"+obj[i].id+"'>"+obj[i].areaName+"</option>")
                }
            },
            dataType:"json"
        })

        $("[value='更新']").click(function (){
            $.ajax({
                url:"http://localhost:8080/product/update",
                type:"post",
                data:$("form").serialize(),
                success:function (obj){
                    if(obj == "1"){
                        alert("信息更新成功")
                        location.href = "http://localhost:8080/product/list"
                    }else{
                        alert("信息更新失败,请联系管理员")
                    }
                },
                dataType:"json"
            })
        })
    })
</script>
<body>
<center>
    <h2>产品详情页</h2>
    <form>
        <input type="hidden" value="${product.id}" name="id">
        <table border="1px solid black">
            <tr>
                <td>产品名称</td>
                <td><input type="text" value="${product.productName}" name="productName"></td>
            </tr>
            <tr>
                <td>产品规格</td>
                <td><input type="text" value="${(product.weight)}" name="weight"></td>
            </tr>
            <tr>
                <td>单价</td>
                <td><input type="number" step="0.01" value="${product.price}" name="price"></td>
            </tr>
            <tr>
                <td>产品特色</td>
                <td><input type="text" name="feature" value="${product.feature}"></td>
            </tr>
            <tr>
                <td>产地</td>
                <td>
                    <select style="width: 50px;height: 30px;line-height: 30px" name="areaId" id="area">

                    </select>
                </td>
            </tr>
            <tr>
                <td>当前商家</td>
                <td>
                    <select style="width: 50px;height: 30px;line-height: 30px" name="bid" id="business">
                        <option selected value="${(product.business.id)}">${(product.business.username)}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="更新" style="width: 65px;height: 40px;line-height: 40px;font-size: 20px"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>