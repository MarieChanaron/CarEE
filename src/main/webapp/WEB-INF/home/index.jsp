<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>CarEE | Home</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>


<body>

    <c:choose>
        <c:when test="${logged}">
            <c:import url="../header-secured/" />
        </c:when>
        <c:otherwise>
            <c:import url="../header-normal/" />
        </c:otherwise>
    </c:choose>

    <c:import url="../list-car/" />
</body>

</html>
