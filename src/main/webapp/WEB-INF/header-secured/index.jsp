<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
</head>
<body>

<nav>
    <ul>
        <li><a href="#">Home</a></li>
        <li>
            <a href="#">Category List</a>
        </li>
        <li>
            <a href="#">Administration</a>
            <ul>
                <li><a href="#">Add Car</a></li>
                <li><a href="#">Add Category</a></li>
            </ul>
        </li>
        <li>
            <a href="logout">Logout</a>
        </li>
        <li>
            <a href="#">Icon</a>
        </li>
    </ul>
</nav>

</body>
</html>
