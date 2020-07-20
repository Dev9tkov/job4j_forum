<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<c:set var="post" value="${post}"/>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Topic</title>
</head>
<body>
<div class="container mt-3">
    <ul class="nav justify-content-end">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/"/>"> На главную</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/logout"/>"> <c:out value="${user.name}"/> | Выйти</a>
    </li>
    </ul>
    <div class="card">
        <h5 class="card-header">${post.name}</h5>
        <div class="card-body">
            <p class="card-text">${post.desc}</p>
            <p class="card-text"><small class="text-muted">${post.created.time}</small></p>
            <c:if test="${user.name == post.author.name}">
                <a href="<c:url value="/create?id=${post.id}"/>">Редактировать</a>
            </c:if>
        </div>
    </div>
    <c:forEach items="${post.answers}" var="answer">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">${answer.author.name} ответил:</h6>
                <p class="card-text">${answer.desc}</p>
                <p class="card-text"><small class="text-muted">${answer.created.time}</small></p>
            </div>
        </div>
    </c:forEach>

    <div class="row">
        <div class="col-2" style="margin-top: 10px">
            <a href="<c:url value='/create?answerFor=${post.id}'/>" class="btn btn-success">Ответить</a>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>