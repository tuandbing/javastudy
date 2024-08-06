<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商家登录</title>
</head>
<script src="/jquery/jquery-1.7.2.js"></script>
<script>
    $(function (){

        $("[value='登录']").click(function (){

            $.ajax({
                url:"http://localhost:8080/business/login",
                type:"post",
                data:$("form").serialize(),
                success:function (obj){
                    if(obj == "1"){
                        alert("登录成功")
                        location.href = "http://localhost:8080/product/list"
                    }else{
                        alert("登录失败")
                        location.reload()
                    }
                },
                dataType:"text"
            })
        })
    })
</script>
<body>
<center>
    <h2>商家登录</h2>
    <form>
        用户名 : <input type="text" name="username"><br>
        密码 : <input type="password" name="password"><br>
        <a href="http://localhost:8080/business/toRegister">还没有账号?前往注册</a>
        <input type="button" value="登录">
    </form>
</center>
</body>
</html>