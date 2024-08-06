<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商家登录</title>
</head>
<script src="/jquery/jquery-1.7.2.js"></script>
<script>
    $(function (){

        $("[value='注册']").click(function (){

            $.ajax({

                url:"http://localhost:8080/business/register",
                type:"post",
                data:$("form").serialize(),
                success:function (obj){
                    if(obj == "1"){
                        alert("注册成功")
                        location.href = "http://localhost:8080/business/toLog"
                    }else if(obj == "2"){
                        alert("注册失败,请联系管理员")
                        location.reload()
                    }else if(obj == "3"){
                        alert("两次密码不一致")
                        location.reload()
                    }else{
                        alert("用户名重复")
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
    <h2>商家注册</h2>
    <form>
        用户名 : <input type="text" name="username" required><br>
        密码 : <input type="password" name="password" required><br>
        确认密码 : <input type="password" name="rePassword" required><br>
        联系电话 : <input type="number" name="phone" required><br/>
        联系地址 : <input type="text" name="address" required><br/>
        <a href="http://localhost:8080/business/toLog">已有账号?前往登录</a><br/>
        <input type="button" value="注册">
    </form>
</center>
</body>
</html>