<%--
  Created by IntelliJ IDEA.
  User: fercodeup
  Date: 10/22/19
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Products</title>
</head>
<body>
<h1>Here are all the products:</h1>

<c:forEach var="ipod" items="${ipods}">
    <div class="product">
        <h2>${ipod.name}</h2>
        <p>Price: $ ${ipod.getPrice()}</p>
    </div>
</c:forEach>

</body>
</html>
