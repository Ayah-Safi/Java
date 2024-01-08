<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Book Details</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin-left: 20px;
    }
    .title {
        font-size: 24px;
        font-weight: bold;
    }
    .attribute {
        margin-top: 5px;
    }
</style>
</head>
<body>
    <div class="title"><c:out value="${title}"></c:out></div>
    <div class="attribute"><strong>Description:</strong> <c:out value="${desc}"></c:out></div>
    <div class="attribute"><strong>Language:</strong> <c:out value="${langauge}"></c:out></div>
    <div class="attribute"><strong>Number of Pages:</strong> <c:out value="${numOfPages}"></c:out></div>
</body>
</html>