<%--
  Created by IntelliJ IDEA.
  User: justinreich
  Date: 2019-10-21
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


    String username = (request.getParameter("username") != null) ? request.getParameter("username") : "";
    String password = (request.getParameter("password") != null) ? request.getParameter("password") : "";

//    if (request.getParameter("username") != null && request.getParameter("password") != null) {
        if (username.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("password")) {
            response.sendRedirect("/profile.jsp");
        }
//    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1><%= request.getParameter("username") %> <%= request.getParameter("password") %></h1>

<form action="/login.jsp" method="post">


    <label for="username">Enter username</label>
    <input id="username" type="text" name="username" placeholder="Enter username">

    <label for="password">Enter password</label>
    <input id="password" type="password" name="password" placeholder="Enter password">

    <button>Submit</button>

</form>

</body>
</html>
