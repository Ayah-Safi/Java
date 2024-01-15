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
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/home.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<div class="header">
		<div class="left">
			<h4>Welcome,${currentUser.getUserName()}</h4>
			<h5>Books from everyone's shelves:</h5>
		</div>
		<div class="right">
			<a href="/logout">logout</a>
			<br>
			<a href="/addBook">+Add to my shelf</a>
		</div>
	</div>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
		<c:forEach items="${allBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td><a href="showBook/${book.id}" class="link">${book.title}</a></td>
                <td>${book.author}</td>
                <td>${book.user.userName}</td>
            </tr>
        </c:forEach>
	</table>
</body>
</html>