<%--
  Created by IntelliJ IDEA.
  User: SUMAN
  Date: 4/17/2023
  Time: 7:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
</head>
<body>
<%@include file="../includes/nav.jsp"%>
<P>this is userlist</P>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">username</th>
        <th scope="col">address</th>
        <th scope="col">password</th>
        <th scope="col">Action</th>

    </tr>
    </thead>
    <tbody>
<c:forEach items="${studentList}" var="student">
    <tr>
        <td>${student.id}</td>
        <td>${student.username}</td>
        <td>${student.address}</td>
        <td>${student.password}</td>
        <td><a href="user?page=userDetails&id=${student.id}">userDetails</a></td>
    </tr>
</c:forEach>
    </tbody>
</table>

</body>
</html>
