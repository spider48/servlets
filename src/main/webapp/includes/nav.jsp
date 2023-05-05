<%--
  Created by IntelliJ IDEA.
  User: SUMAN
  Date: 4/16/2023
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
<%="welcome" + session.getAttribute("username")%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <%--                <a class="nav-link" href="data?page=profile">profile <span class="sr-only">(current)</span></a>--%>
                <a class="nav-link " href="user?page=dash">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="user?page=userList">UserList</a>
            </li><li class="nav-item">
                <a class="nav-link " href="user?page=addUser">AddUser</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="user?page=logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>