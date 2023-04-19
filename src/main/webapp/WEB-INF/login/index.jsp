<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>CarEE | Home</title>
    <style><%@include file="../global-css.css"%></style>
    <style><%@include file="style.css"%></style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>


<body>
    <c:import url="../header-normal/" />

    <div id="login-section" class="section dark-bg padding">
        <h1>Login page</h1>
        <form action="auth/list-car" method="post">
            <input type="text" />
            <input type="password">
            <button type="submit">Login</button>
        </form>
    </div>
</body>

</html>

