<%--
  Created by IntelliJ IDEA.
  User: fandja
  Date: 15/04/2023
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Posts list</title>
</head>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"> <h1>TP Post</h1></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="posts-list">Posts list</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="form-posts">Add a post</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/userSession/logout">Log out</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<main>
    <div class="container-fluid d-flex flex-wrap justify-content-around mt-4">
        <c:forEach var="post" items="${postList}">
            <div id="{post.id}" class="card" style="width: 18rem;">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${post.title}</h5>
                    <h6 class="card-subtitle mb-2 text-body-secondary">${post.author}</h6>
                    <p class="card-text">${post.content}</p>
                    <a href="#" class="card-link">Go somewhere</a>
                    <p href="#" class="card-link">${post.createAt}</p>
                    <form method="post" action="posts-list">
                        <input type="hidden" name="buttonId" value="${post.id}">
                        <button type="submit" class="btn btn-primary"  id="${post.id}">Supprimer</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</main>
<footer></footer>
</body>
</html>
