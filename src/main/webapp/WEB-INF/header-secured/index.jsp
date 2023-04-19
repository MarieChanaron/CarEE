<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
</head>
<body>

    <header class="padding">
        <p style="font-size: 32px">&#128664;</p>
        <nav>
            <ul>
                <li><a href="home" class="turquoise bold">Home</a></li>
                <li>
                    <a href="list-category" class="turquoise bold">Category List</a>
                </li>
                <li>
                    <a href="#" class="turquoise bold">Administration</a>
                    <ul>
                        <li><a href="add-car" class="turquoise bold">Add Car</a></li>
                        <li><a href="add-category" class="turquoise bold">Add Category</a></li>
                    </ul>
                </li>
                <li>
                    <a href="logout" class="turquoise bold">Logout</a>
                </li>
                <li>
                    <a href="#">&#128269;</a>
                </li>
            </ul>
        </nav>

    </header>

</body>
</html>
