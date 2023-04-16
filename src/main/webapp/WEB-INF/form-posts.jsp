<%--
  Created by IntelliJ IDEA.
  User: fandja
  Date: 15/04/2023
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Title</title>
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
            <a class="nav-link" href="#">Add a post</a>
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
  <div class="container-fluid">
    <form  action="form-posts" method="post">
      <div class="mb-3">
        <Label for="uploadImage" class = "contrôle-label"> Upload an Image
          <Input id="uploadImage" name="postImage" type="file" classe multiple="file-chargement">
        </Label>
      </div>
      <div class="mb-3">
        <label for="postTitle" class="form-label">Title</label>
        <input type="text" class="form-control" id="postTitle" name="title">
      </div>
      <div class="mb-3">
        <label for="authorName" class="form-label">Your name</label>
        <input type="text" maxlength="10" class="form-control" id="authorName" name="author">
      </div>
      <div class="input-group">
        <span class="input-group-text">Your message</span>
        <textarea class="form-control" aria-label="With textarea" name="content"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</main>
<footer></footer>
</body>
</html>
