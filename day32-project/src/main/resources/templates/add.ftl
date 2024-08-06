<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商家登录</title>
    <style>
        table tr{
            width: 200px;
            height: 30px;
        }
        table tr:last-child{
            text-align: center;
        }
    </style>
</head>
<script src="/jquery/jquery-1.7.2.js"></script>
<script>
    $(function (){
        // 获取产地下拉列表
        $.ajax({
            url:"http://localhost:8080/area/getAreaList",
            data: "",
            type:"post",
            success:function (obj){
                for (let i in obj){
                    $("select").append("<option value='"+obj[i].id+"'>"+obj[i].areaName+"</option>")
                }
            },
            dataType:"json"
        })

        $("[value='上架']").click(function (){

            $.ajax({
                url:"http://localhost:8080/product/add",
                type:"post",
                data:$("form").serialize(),
                success:function (obj){
                    if(obj == "1"){
                        alert("上架成功")
                        location.href = "http://localhost:8080/product/list"
                    }else if(obj == "2"){
                        alert("商品已存在,上架失败")
                        location.reload()
                    }else{
                        alert("上架失败,请联系管理员")
                        location.reload()
                    }
                },
                dataType:"text"
            })
        })

        $("[value='返回']").click(function (){
            location.href = "http://localhost:8080/product/list"
        })
    })
</script>
<body>
<center>
    <h2>果蔬上架</h2>
    <form>
        <input type="hidden" value="${business.id}" name="bid">
        <table>
            <tr>
                <td>果蔬名 : </td>
                <td><input type="text" name="productName" required></td>
            </tr>
            <tr>
                <td>特征 : </td>
                <td><input type="text" name="feature" required></td>
            </tr>
            <tr>
                <td>产地 : </td>
                <td>
                    <select name="areaId" required>
                        <option>请选择产地</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>规格 : </td>
                <td><input type="text" name="weight" required></td>
            </tr>
            <tr>
                <td>价格 : </td>
                <td><input type="number" name="price" step="0.01" required></td>
            </tr>
            <tr>
                <td>是否公开 : </td>
                <td>
                    <input type="radio" name="power" value="1"> 是
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="power" value="2"> 否
                </td>
            </tr>
            <tr>
                <td><input type="button" value="上架"></td>
                <td><input type="button" value="返回"></td>
            </tr>
        </table>

    </form>
</center>
</body>
</html>