<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
</head>


<body>

    <div id="list-cars" class="padding dark-bg section">
        <c:if test="${cars == null}">
            <c:import url="/list-cars" />
        </c:if>
        <c:forEach var="car" items="${cars}">
            <div class="car-card">
                <div class="img-container" style="background-image: url(${car.image})"></div>
                <div class="text">
                    <p>${car.name}</p>
                    <p>${car.category}</p>
                    <div class="btn-div">
                        <a href="#">
                            <button>DETAILS</button>
                        </a>
                        <c:if test="${logged}">
                            <a href="#">
                                <button class="red">DELETE</button>
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</body>


</html>
