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
	    <title>Login and Registration</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
	</head>
	<body>
		<div class="main">
			<h1 class="center">Welcome!</h1>
			<h3 class="center">Join our growing community.</h3>
			<div class="forms">
			<form:form action="register" method="post" modelAttribute="newUser">
				<h1>Register</h1>
				<div class="form-group">
					<form:label path="userName" for="username">User Name:</form:label>
					<form:errors path="userName"  class="text-danger"/>
      				<form:input path="userName" type="text" id="username" name="username"></form:input>
				</div>
				<div class="form-group">
				 	<form:label path="email" for="email">Email:</form:label>
				 	<form:errors path="email"  class="text-danger"/>
      				<form:input path="email" type="text" id="email" name="eamil"></form:input>
				</div>
				<div class="form-group">
					<form:label path="password" for="password">Password:</form:label>
					<form:errors path="password"  class="text-danger"/>
      				<form:input path="password" type="password" id="password" name="password"></form:input>
				</div>
				<div class="form-group">
					<form:label path="confirm" for="confirm">Confirm PW:</form:label>
					<form:errors path="confirm"  class="text-danger"/>
      				<form:input path="confirm" type="password" id="confirm" name="confirm"></form:input>
				</div>
				<div class="form-group">
					<button type="submit">Submit</button>
				</div>
			</form:form>
			
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<h1>Login</h1>
				<div class="form-group">
				 	<form:label path="email" for="email">Email:</form:label>
				 	<form:errors path="email"  class="text-danger"/>
      				<form:input path="email" type="text" id="email" name="eamil"></form:input>
				</div>
				<div class="form-group">
					<form:label path="password" for="password">Password:</form:label>
					<form:errors path="password"  class="text-danger"/>
      				<form:input path="password" type="password" id="password" name="password"></form:input>
      			</div>
				<div class="form-group">
					<button type="submit">Submit</button>
				</div>
			</form:form>
			</div>
		</div>
	</body>
</html>