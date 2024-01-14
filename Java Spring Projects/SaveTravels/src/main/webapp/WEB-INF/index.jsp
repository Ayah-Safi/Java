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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/main.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
  <h1>Save Travels</h1>
  <table>
    <tr>
      <th>Expenses</th>
      <th>Vendor</th>
      <th>Amount</th>
      <th>Action</th>
    </tr>
    <c:forEach var="expense" items="${allExpenses}">
    <tr>
      <td><a href="/expenses/show/${expense.getId()}">${expense.getExpensesName()}</a></td>
      <td>${expense.getVendor()}</td>
      <td>$<fmt:formatNumber value="${expense.getAmount()}" /></td>
      <td><a href="/expenses/edit/${expense.getId()}">Edit</a> <a href="/expenses/delete/${expense.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
  </table>

 <div class="form-section">
    <h2>Add an expense:</h2>
    <p class="red">Description must not be blank</p>
    <form:form action="/expenses" method="post" modelAttribute="travel">
    <div class="form-group">
       <form:label path="expensesName">Expense Name:</form:label>
       <form:errors path="expensesName"  class="text-danger"/>
       <form:input path="expensesName"/>
	</div>
	
	 <div class="form-group">
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor" class="text-danger"/>
        <form:input path="vendor"/>
	</div>
	
	<div class="form-group">
      <form:label path="amount">Amount:</form:label>
      <form:errors path="amount" class="text-danger"/>
      <form:input path="amount"/>
	</div>
	
	<div class="form-group">
      <form:label path="description">Description:</form:label>
      <form:errors path="description" class="text-danger"/>
      <form:textarea path="description"></form:textarea>
	</div>
	
      <button type="submit">Submit</button>
      
    </form:form>
  </div>
</div>
</body>
</html>