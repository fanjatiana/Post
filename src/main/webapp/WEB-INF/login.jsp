<%--
  Created by IntelliJ IDEA.
  User: fandja
  Date: 16/04/2023
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<header>
    <h1 class="mt-5 mb-5 text-center">Login</h1>
</header>
<main>
    <div class="container-fluid d-flex flex-direction-column justify-content-center">
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="mb-3 row">
                <label for="email" class="col-sm-2 col-form-label me-3">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputPassword" class="col-sm-2 col-form-label me-3">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" name="password" required>
                </div>
            </div>
            <p>${isError}</p>
            <button type="submit" class="btn btn-primary">To log in</button>
        </form>
    </div>
</main>
<footer></footer>
</body>
</html>
