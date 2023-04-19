<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
</head>
<body>
    <h1>List of cars</h1>
    <div>
        <c:if test="${cars == null}">
            <c:import url="/list-cars" />
        </c:if>
        <c:forEach var="car" items="${cars}">
            <div class="car-box">
                <img src="${car.image}" alt="${car.name}">
                <p>${car.name}</p>
                <p>${car.category}</p>
            </div>
        </c:forEach>

    </div>
</body>
</html>
