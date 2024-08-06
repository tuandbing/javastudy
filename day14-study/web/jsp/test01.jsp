<%--
  Created by IntelliJ IDEA.
  User: 彭垚旺
  Date: 2024/3/10
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
pageContext : <%=pageContext.getAttribute("pageContext")%><br>
request : <%=request.getAttribute("request")%><br>
session : <%=session.getAttribute("session")%><br>
application : <%=application.getAttribute("application")%><br>
</body>
</html>
