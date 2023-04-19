<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>


<head>
    <title>Title</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
</head>


<body>

    <c:import url="../header-secured/" />

    <div id="add-car-section" class="section dark-bg padding">
        <h1>Add Car</h1>
        <form action="add-car" method="post">
            <select name="category">
                <c:forEach var="cat" items="${categories}" varStatus="loop">
                    <option value="${loop.index}">${cat.name}</option>
                </c:forEach>
            </select>
            <input name="name" type="text" placeholder="Name" autocomplete="off"/>
            <input name="description" type="text" placeholder="Description" autocomplete="off"/>
            <input name="image" type="text" placeholder="http://image-link" autocomplete="off"/>
            <input name="price" type="number" placeholder="70000" step=".01" autocomplete="off"/>
            <button type="submit">Add car</button>
        </form>
    </div>

</body>

</html>
