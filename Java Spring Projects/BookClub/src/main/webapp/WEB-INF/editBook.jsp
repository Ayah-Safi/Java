<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/addBook.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body style="background-color: #DDDDDD">

    <div class="right-section">
        <h1 class="">change your Entry</h1>
        <form:form action="/updateBook/${book.getId()}" method="post" modelAttribute="book">
            <input type="hidden" name="_method" value="put">
            <p class="red-txt">Author must not be blank</p>

            <div class="form-group">
                <form:label path="title" for="title">Title</form:label>
                <form:input path="title" type="text" id="title" name="title" required="required" />
            </div>
            <div class="form-group">
                <form:label path="author" for="author">Author</form:label>
                <form:input path="author" type="text" id="author" name="author" required="required" />
            </div>
            <div class="form-group">
                <form:label path="thoughts" for="thoughts">My thoughts</form:label>
                <form:input path="thoughts" type="text" id="thoughts" name="thoughts" required="required" />
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
