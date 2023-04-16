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
    <title>Title</title>
</head>
<body>
<header>
    <h1></h1>
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
                    <form method="" action="">
                        <button type="submit" class="btn btn-primary" name="btnDelete">Supprimer</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</main>
<footer></footer>

</body>
</html>
