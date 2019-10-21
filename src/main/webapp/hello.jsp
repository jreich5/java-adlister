<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2019-10-21
  Time: 09:13
  To change this template use File | Settings | File Templates.
--%>
<%
    int x = 4;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@include file="partials/navbar.html"%>

    <h1>First JSP!</h1>

    <%= x %>

    <%@include file="test.jsp"%>

    <%= x + y %>

</body>
</html>
