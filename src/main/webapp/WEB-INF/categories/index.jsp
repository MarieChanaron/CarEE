<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>


<body>

    <div id="list-categories" class="padding dark-bg section">
        <c:if test="${categories == null}">
            <c:import url="/fetch-categories" />
        </c:if>
        <c:forEach var="cat" items="${categories}">
            <p class="cat-container">
                ${cat.name}
            </p>
        </c:forEach>
    </div>

</body>
</html>
