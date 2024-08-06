<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("pageContext","pageContext");
        request.setAttribute("request","request");
        session.setAttribute("session","session");
        application.setAttribute("application","application");
    %>
</head>
<body>
pageContext : <%=pageContext.getAttribute("pageContext")%><br>
request : <%=request.getAttribute("request")%><br>
session : <%=session.getAttribute("session")%><br>
application : <%=application.getAttribute("application")%><br>
</body>
</html>
