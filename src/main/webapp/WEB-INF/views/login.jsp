<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.servletContext.contextPath}"/>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <div class="col-10">
            <a href="${URL}/" class="stretched-link"><h4>Форум job4j</h4></a>
        </div>
        <div class="col-2">
            <a href="<c:url value='/reg'/>" class="btn btn-success">Регистрация</a>
        </div>
    </div>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>
    <form name="login" action="<c:url value='/login'/>" method="POST">
        <div class="form-group">
            <label>Логин</label>
            <input type="text" class="form-control" name="username">
        </div>
        <div class="form-group">
            <label>Пароль</label>
            <input type="password"  name="password" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
</div>
</body>
</html>