<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>
<p> You have visited <a href="/">http://your_server</a> <c:out value="${count}"/> times.</p>

<a href="/">Test another visit?</a>
<br>
<br>
<button id="reset">Reset Counter</button>
</body>
</html>