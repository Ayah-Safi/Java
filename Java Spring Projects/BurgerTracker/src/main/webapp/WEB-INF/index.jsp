<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger Tracker One</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
  <h1>Burger Tracker</h1>
  <table>
    <tr>
      <th>Burger Name</th>
      <th>Restaurant Name</th>
      <th>Rating (out of 5)</th>
    </tr>
    <c:forEach var="burger" items="${burgers}">
    <tr>
      <td>${burger.getBurgerName()}</td>
      <td>${burger.getResturantName()}</td>
      <td>${burger.getRating()}</td>
    </tr>
    </c:forEach>
  </table>

  <div class="form-section">
    <h2>Add a Burger:</h2>
    <p class="red">Notes must not be blank</p>
    <form:form action="/addBurger" method="post" modelAttribute="burger">
    <div class="form-group">
       <form:label path="burgerName">Burger Name</form:label>
       <form:errors path="burgerName"  class="text-danger"/>
       <form:input path="burgerName"/>
	</div>
	
	 <div class="form-group">
        <form:label path="resturantName">Restaurant Name</form:label>
        <form:errors path="resturantName" class="text-danger"/>
        <form:input path="resturantName"/>
	</div>
	
	<div class="form-group">
      <form:label path="rating">Rating</form:label>
      <form:errors path="rating" class="text-danger"/>
      <form:input path="rating"/>
	</div>
	
	<div class="form-group">
      <form:label path="notes">Notes</form:label>
      <form:errors path="notes" class="text-danger"/>
      <form:textarea path="notes"></form:textarea>
	</div>
	
      <button type="submit">Submit</button>
      
    </form:form>
  </div>
</div>
</body>
</html>