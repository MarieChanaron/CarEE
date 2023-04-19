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

    <div id="add-category-section" class="section dark-bg padding">
        <h1>Add Category</h1>
        <form action="add-category" method="post">
            <input name="name" type="text" placeholder="Name" autocomplete="off"/>
            <button type="submit">Add category</button>
        </form>
    </div>


</body>
</html>
