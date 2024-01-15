<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/addBook.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
    <div class="right-section">
        <h1 class="">Add a Book to Your Shelf!</h1>
       <form:form action="/addBook" method="post" modelAttribute="book">
            <div class="form-group">
                <form:label path="title" for="title">Title</form:label> 
                <form:input path="title" type="text" id="title" name="title" required="required"/>
            </div>
            <div class="form-group">
                <form:label path="author" for="author">Author</form:label>
                <form:input path="author" type="text" id="author" name="author" required="required"/>
            </div>
            <div class="form-group">
                <form:label path="thoughts" for="thoughts">My thoughts</form:label>
                <form:input path="thoughts" id="thoughts" name="thoughts" required="required"/>
            </div>
            <div class="form-group">
                <button type="submit">Submit</button>
            </div>
        </form:form>
    </div>
    <div class="left-section">
        <a href="/home">back to the shelves</a>
    </div>
</body>
</html>
