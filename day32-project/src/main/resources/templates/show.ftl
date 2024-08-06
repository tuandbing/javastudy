<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息查看</title>
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
        $("[value='返回']").click(function (){
            window.location = "http://localhost:8080/product/list"
        })
    })
</script>
<body>
<center>
    <h2>产品详情页</h2>

    <table border="1px solid black">
        <tr>
            <td>产品名称</td><td>${product.productName}</td>
        </tr>
        <tr>
            <td>产品规格</td><td>${(product.weight)}</td>
        </tr>
        <tr>
            <td>单价</td><td>${product.price}</td>
        </tr>
        <tr>
            <td>产品特色</td><td>${product.feature}</td>
        </tr>
        <tr>
            <td>发布时间</td><td>${(product.date)?string("yyyy-MM-dd")}</td>
        </tr>
        <tr>
            <td>产地</td><td>${(product.area.areaName)}</td>
        </tr>
        <tr>
            <td>当前商家</td><td>${product.business.username}</td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: white;">
                <input type="button" value="返回" style="width: 65px;height: 40px;line-height: 40px;font-size: 20px">
            </td>
        </tr>
    </table>
</center>
</body>
</html>