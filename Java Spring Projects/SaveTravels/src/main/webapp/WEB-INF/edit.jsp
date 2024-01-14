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
 <a class="go-back" href="/">Go back</a>
 <div class="form-section">
   	<h2 style="color:green">Edit Expenses</h2>
    <form:form action="/expenses/edit/${travel.getId()}" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="put">
    
    <div class="form-group">
       <form:label path="expensesName">Expense Name:</form:label>
       <form:errors path="expensesName"  class="text-danger"/>
       <form:input path="expensesName" value="${travel.getExpensesName()}"/>
	</div>
	
	 <div class="form-group">
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor" class="text-danger"/>
        <form:input path="vendor" value="${travel.getVendor()}"/>
	</div>
	
	<div class="form-group">
      <form:label path="amount">Amount:</form:label>
      <form:errors path="amount" class="text-danger"/>
      <form:input path="amount" value="${travel.getAmount()}"/>
	</div>
	
	<div class="form-group">
      <form:label path="description">Description:</form:label>
      <form:errors path="description" class="text-danger"/>
      <form:input path="description" value="${travel.getDescription()}"></form:input>
	</div>
	
      <button type="submit">Submit</button>
      
    </form:form>
    
  </div>
</div>
</body>
</html>