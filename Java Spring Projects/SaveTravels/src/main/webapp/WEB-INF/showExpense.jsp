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
	<title>Expense Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/main.js"></script><!-- change to match your file/naming structure -->

</head>
<body>
<body>

<div class="container mt-4">
	<a class="go-back" href="/">Go back</a>
    <h2 class="text-center mb-4" style="color:blue">Expense Details</h2>
    
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Expense Name: <span class="font-weight-normal">${expense.getExpensesName()}</span></h5>
            <h5 class="card-title">Expense Description: <span class="font-weight-normal">${expense.getDescription()}</span></h5>
            <h5 class="card-title">Vendor: <span class="font-weight-normal">${expense.getVendor()}</span></h5>
            <h5 class="card-title">Amount Spent: $<span class="font-weight-normal">${expense.getAmount()}</span></h5>
        </div>
    </div>
    
</div>
</body>
</html>