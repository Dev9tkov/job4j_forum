<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="nameVal" value=""/>
<c:set var="descriptionVal" value=""/>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <c:if test="${not empty oldPost}">
        <c:set var="title" value="Edit Post"/>
    </c:if>
    <c:if test="${empty oldPost}">
        <c:set var="title" value="Новый пост"/>
    </c:if>
    <c:if test="${not empty answerFor}">
        <c:set var="title" value="Новый ответ"/>
    </c:if>
    <title>${title}</title>
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

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>

    <form name="topic" action="<c:url value="${action}"/>" method="POST">
        <input type="hidden" name="author" value="${user.name}">

        <c:if test="${not empty oldPost}">
            <c:set var="nameVal" value="${oldPost.name}"/>
            <c:set var="descVal" value="${oldPost.desc}"/>
            <input type="hidden" name="oldPostId" value="${oldPost.id}">
        </c:if>

        <c:if test="${not empty oldPost}">
            <c:set var="nameVal" value="${oldPost.name}"/>
            <c:set var="descVal" value="${oldPost.answers}"/>
            <input type="hidden" name="oldPostId" value="${oldPost.id}">
        </c:if>

        <c:if test="${not empty oldPost && !oldPost.topic}">
            <input type="hidden" name="name" value="${nameVal}">
        </c:if>

        <c:if test="${not empty answerFor}">
            <input type="hidden" name="answerFor" value="${answerFor}">
            <input type="hidden" name="name" value="${nameVal}">
        </c:if>

        <c:if test="${(oldPost.topic || empty oldPost) && empty answerFor}">
            <div class="form-group">
                <label>Название темы: </label>
                <input type="text" class="form-control" name="name" value="${nameVal}">
            </div>
        </c:if>

        <div class="form-group">
            <label>Описание:</label>
            <textarea class="form-control" name="description" rows="3">${descVal}</textarea>
        </div>

        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>