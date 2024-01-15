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
<link rel="stylesheet" href="/css/home.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Home Page</h1>
		</div>
		<div class="menu">
			<a href="/addProduct">New Product</a> <br> <a href="/addCat">New
				Category</a>
		</div>
		<div class="content">
			<div class="section">
				<h2>Products</h2>
				<ul>
					<c:forEach var="product" items="${allProducts}">
						<li><a href="/showProduct/${product.getId()}">${product.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="section">
				<h2>Categories</h2>
				<ul>
					<c:forEach var="category" items="${allCat}">
						<li><a href="/showCat/${category.getId()}">${category.name}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
</body>
</html>

