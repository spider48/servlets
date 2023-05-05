<%--
  Created by IntelliJ IDEA.
  User: SUMAN
  Date: 4/23/2023
  Time: 7:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
</head>
<body>
<%@include file="../includes/nav.jsp"%>
<form action="user?page=editUser" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <input type="text" name="username" value="${student.username}">
    <input type="text" name="address" value="${student.address}">
    <input type="password" name="password" value="${student.password}">
    <input type="submit" name="Edit">
</form>

</body>
</html>
