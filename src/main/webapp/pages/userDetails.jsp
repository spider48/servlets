<%--
  Created by IntelliJ IDEA.
  User: SUMAN
  Date: 4/19/2023
  Time: 7:36 AM
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
<table class="table table-black">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">username</th>
        <th scope="col">address</th>
        <th scope="col">password</th>
        <th scope="col">Action</th>

    </tr>
    </thead>
    <tr>
        <td>${student.id}</td>
        <td>${student.username}</td>
        <td>${student.address}</td>
        <td>${student.password}</td>
        <td><a href="user?page=deleteUser&id=${student.id}">Delete</a></td>
         <td><a href="user?page=userEditRow&id=${student.id}&username=${student.username}&address=${student.address}&password=${student.password}">edit</a></td>
        <td><a href="">add</a></td>
</table>
</body>
</html>
