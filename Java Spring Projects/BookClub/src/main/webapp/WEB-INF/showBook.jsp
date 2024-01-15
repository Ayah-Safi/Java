<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/showBook.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
    <div class="header">
        <h1 class="center">${book.title}</h1>
        <a href="/home">back to the shelves</a>
    </div>
    
    <div class="section-two">
        <p><span class="red-txt">${book.user.userName}</span> read <span class="maroon-txt">${book.title}</span> by <span class="green-txt">${book.author}</span></p>
        <p>Here are ${book.user.userName}'s thoughts:</p>
    </div>

    <div class="section-three">
        <p>${book.thoughts}</p>
    </div>
</body>
</html>
