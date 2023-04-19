<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
</head>


<body>

    <div id="list-categories" class="padding dark-bg section">
        <c:if test="${categories == null}">
            <c:import url="/fetch-categories" />
        </c:if>
        <c:forEach var="cat" items="${categories}">
            <div class="cat-container">
                <span>${cat.name}</span>
                <c:if test="${logged}">
                    <div class="btn-div">
                        <a href="#">
                            <button>EDIT</button>
                        </a>
                        <a href="delete-category?id=${cat.id}">
                            <button class="red">DELETE</button>
                        </a>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </div>

</body>
</html>
