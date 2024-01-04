<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

 <div class="gold-display">
    Your Gold: <input type="text" name="gold" value="${gold}">
 </div>
  
<div class="container">
  <form class="location" action="/earn" method="post">
    Farm<br>
    (earns 10-20 gold)
    <input type="hidden" name="whichform" value="farm">
    <button type="submit">Find Gold!</button>
  </form>
  
  <form class="location" action="/earn" method="post">
    Cave<br>
    (earns 5-10 gold)
    <input type="hidden" name="whichform" value="cave">
    <button type="submit">Find Gold!</button>
  </form>
  
  <form class="location" action="/earn" method="post">
    House<br>
    (earns 2-5 gold)
    <input type="hidden" name="whichform" value="house">
    <button type="submit">Find Gold!</button>
  </form>
  
  <form class="location" action="/earn" method="post">
    Quest<br>
    (earns/takes 0 - 50 gold)
    <input type="hidden" name="whichform" value="quest">
    <button type="submit">Find Gold!</button>
  </form>
  
<form class="location" action="/earn" method="post">
    Spa<br>
    (takes 5 - 20 gold)
    <input type="hidden" name="whichform" value="quest">
    <button type="submit">Find Gold!</button>
  </form>
</div>  
  
<div class="activities-container">
    <span>Activities:</span>
    <div class="activities">
        <c:forEach items="${activities}" var="activity">
            <div style="color:${activity.color};">${activity.text}</div>
        </c:forEach>
    </div>
</div>

<form class="reset-btn" action="/earn" method="post">
	<input type="hidden" name="whichform" value="reset">
	<button type="submit">Reset</button>
</form>


</body>
</html>