<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="List of ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="container">
    <h1>For sale</h1>
    <%--  ads list   --%>
    <c:forEach items="${ads}" var="ad">
        <h2>${ad.title}</h2>
        <span>${ad.userId}</span>
        <p>${ad.description}</p>
        <button>Buy</button>
        <input type="hidden" value="${ad.id}">
    </c:forEach>
</div>
</body>
</html>