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
    <title>Dojos and Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script><!-- change to match your file/naming structure -->
    <style>
    	
    	
    	h3 {
    	    margin: 20px;
    	}
    	form {
    		margin: 20px;
		   	display: flex;
		    flex-direction: column;
		    gap: 10px;
		}
		button {
			margin-left: 46px;
			width: 150px;
		}
		
		input {
			width: 150px;
		}
		
    	
	</style>
</head>
	<body>
		<div class="main">
			<h3>New Dojo</h3>
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name" type="text"></form:input>
				</div>
				<div class="form-group">
					<form:button class="submit" type="submit">Submit</form:button>
				</div>
			</form:form>
		</div>
	
	</body>
</html>