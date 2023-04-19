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

    <div class="car-overview block-center">
        <div class="img-container" style="background-image: url(${thisCar.image})"></div>
        <div class="text">
            <p id="car-name">${thisCar.name}</p>
            <p id="car-description">${thisCar.description}</p>
            <p id="car-price">PRICE: $${thisCar.price}</p>
            <p id="car-category">${thisCar.category}</p>
            <c:if test="${logged}">
                <div class="btn-div">
                    <a href="#">
                        <button>EDIT</button>
                    </a>
                    <a href="delete-car?id=${thisCar.id}">
                        <button class="red">DELETE</button>
                    </a>
                </div>
            </c:if>
        </div>
    </div>


</body>

</html>
