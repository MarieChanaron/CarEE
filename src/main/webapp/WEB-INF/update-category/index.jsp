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

  <div id="update-category-section" class="section dark-bg padding">
    <h1>Update Category</h1>
    <form action="update-category" method="post">
      <input name="id" type="text" placeholder="Name" autocomplete="off" value="${catId}"/>
      <input name="name" type="text" placeholder="Name" autocomplete="off" value="${catName}"/>
      <button type="submit">Update category</button>
    </form>
  </div>

</body>
</html>
