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
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Show Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 80%;
	margin: 20px auto;
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
	width: 1000px;
}

.home {
	align-self: flex-start;
}

.categories-list {
	text-align: left;
	margin-bottom: 20px;
	width: 1000px;
	border-bottom: 1px solid black;
	border-radius: 1.5%;
}

.add-category {
	text-align: left;
	margin-top: 20px;
	width: 1000px;
}

.add-category select {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
}

.add-category button {
	padding: 10px 20px;
	margin-top: 10px;
	width: 100%;
	background-color: #4cae4c;
	box-shadow: 3px 3px solid #4cae4c;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<h2>${product.name}</h2>
			<a href="/" class="home">Home</a>
		</div>
		<div class="categories-list">
			<h3>Categories:</h3>
			<c:forEach var="category" items="${assignedCategories}">
			<p>- ${category.name}</p>
			</c:forEach>
			
		</div>
		<form class="add-category" action="/showProduct/${product.id}" method="post">
			<h3>Add Category:</h3>
			<select name="categoryId" id="categoryId" class="input" >
				<c:forEach var="category" items="${unassignedCategories}">
					<option  value="${category.id}">${category.name}</option>
				</c:forEach>
			</select>
			<button type="submit">Add</button>
		</form>
	</div>
</body>
</html>
