<%@ page import="java.util.Scanner" %><%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2019-10-21
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>

<%-- JSP Directive --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Hello --%>
<!-- Hello -->

<%
    Scanner sc = new Scanner(System.in);

    int x = 3;
    x += 2;
    String bob = "Hello";

%>

<%! int count = 0;  %>
<%
    count += 1;
    x += 1;
%>


<html>
<head>
    <title>JSP Tags</title>
</head>
<body>

    <%@include file="partials/navbar.html"%>

    <h1>My name is <%= 2 + 2 * 3 %></h1>

    <h1>count variable: <%= count %></h1>
    <h1>x variable: <%= x %></h1>

</body>
</html>
