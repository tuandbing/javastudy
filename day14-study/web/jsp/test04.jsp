<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

request:<%=request.getAttribute("request")%> <br/>
application:<%=application.getAttribute("application")%> <br/>
session:<%=session.getAttribute("session")%> <br/>
pageContext:<%=pageContext.getAttribute("pageContext")%> <br/>


</body>
</html>
