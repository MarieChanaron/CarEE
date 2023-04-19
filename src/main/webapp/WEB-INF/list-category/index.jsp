<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Title</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
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

    <c:if test="${logged}">
        <div class="section block-center">
            <a href="/auth/add-category">
                <button>Add category</button>
            </a>
        </div>
    </c:if>

    <c:import url="../categories/" />
</body>

</html>
