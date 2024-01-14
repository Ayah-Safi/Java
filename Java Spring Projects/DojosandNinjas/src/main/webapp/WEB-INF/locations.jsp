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
<title>Dojos Ninjas Display</title>
</head>
<body>
<div class="container">
  <h1>${dojo.getName()} Location Ninjas</h1>
  <table>
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
    </tr>
    <c:forEach var="ninja" items="${dojo.ninjas}">
    <tr>
      <td>${ninja.getfName()}</td>
      <td>${ninja.getlName()}</td>
      <td>${ninja.getAge()}</td>
    </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>