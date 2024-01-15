<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 50%;
	margin: 0 auto;
	text-align: center;
}

.header {
	margin: 20px 0;
	display: flex;
	flex-direction: column;
	gap: 40px;
	border-bottom: 1px solid black;
	border-radius: 1.5%;
	padding-bottom: 5px;
	width: 700px;
}

.home {
	align-self: flex-start;
}

.back-link {
	text-decoration: none;
	color: blue;
	display: block;
	margin-bottom: 20px;
}

.form-container {
	border: 1px solid black;
	padding: 20px;
	text-align: left;
	width: 700px;
}

.form-field {
	margin-bottom: 10px;
	width: 650px;
	display: flex;
	border: 1px solid black;
	padding: 5px;
}

.form-field label {
	display: block;
	margin-bottom: 5px;
	width: 200px;
}

.form-field input[type="text"], .form-field input[type="number"],
	.form-field textarea {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.form-field input[type="submit"] {
	width: 100%;
	padding: 10px;
	border: none;
	background-color: #5cb85c;
	color: white;
	cursor: pointer;
	border-radius: 4px;
}

.form-field input[type="submit"]:hover {
	background-color: #4cae4c;
}
</style>

</head>
<body>
	<div class="container">
		<div class="header">
			<h1>New Product</h1>
			<a class="home" href="/" class="back-link">Home</a>
		</div>
		<form:form class="form-container" action="addProduct" method="post" modelAttribute="product">
			<div class="form-field">
				<form:label path="name" for="name">Name:</form:label>
				<form:input path="name" type="text" id="name" name="name"></form:input>
			</div>
			<div class="form-field">
				<form:label path="description" for="description">Description:</form:label>
				<form:input path="description" id="description" name="description"></form:input>
			</div>
			<div class="form-field">
				<form:label path="price" for="price">Price:</form:label>
				<form:input path="price" type="text" id="price" name="price" step="0.01" placeholder="0.00"></form:input>
			</div>
			<div class="form-field">
				<input type="submit" value="Submit">
			</div>
		</form:form>
	</div>
</body>
</html>


