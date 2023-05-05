<%--
  Created by IntelliJ IDEA.
  User: SUMAN
  Date: 4/24/2023
  Time: 7:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADDNEWUSER</title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
</head>
<body>
<form action="user?page=addNewUser" method="post">
    <div class="form-group">
        <label >Username</label>
        <input type="text" class="form-control"  name="username" placeholder="Enter username">
    </div>
    <div class="form-group">
        <label >Address</label>
        <input type="text" class="form-control"  name="address" placeholder="Enter Address">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
    </div>
    <input type="submit" class="btn btn-primary" value="addUser">

</form>

</body>
</html>
