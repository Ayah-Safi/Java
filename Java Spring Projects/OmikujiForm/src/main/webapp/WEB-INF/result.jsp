<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/result.css"/>
<title>Omikuji Result</title>
</head>
<body>
<div class="content">
  <h2>Here's Your Omikuji!</h2>
  <div class="omikuji-result">
    In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with  <c:out value="${person}"/> as your roommate,  <c:out value="${endeavor}"/> for a living. The next time you see a  <c:out value="${living_thing}"/>, you will have good luck. Also, <c:out value="${nice_thing}"/>.
  </div>
  <a href="/omikuji" class="go-back">Go Back</a>
</div>
</body>
</html>