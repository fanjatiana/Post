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
  <h1>Create a new post</h1>
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
