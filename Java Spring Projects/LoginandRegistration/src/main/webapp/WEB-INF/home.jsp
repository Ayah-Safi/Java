<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<div class="dashboard">
    <h1>Welcome, <c:out value="${userName}" />!</h1>
    <!-- Replace "userName" with the actual property name for the user's name -->
    <p>This is your dashboard. Nothing to see here yet.</p>
    <a href="/logout">logout</a>
</div>
</body>
</html>