<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Fruit Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8d7da;
        }
        .table-container {
            background-color: #fff;
            border: 1px solid #f5c6cb;
            margin-top: 20px;
            padding: 20px;
            border-radius: 5px;
        }
        table {
            background-color: #fff;
        }
        th, td {
            border-color: #f5c6cb;
        }
    </style>
    
</head>
<body>
<div class="container">
        <div class="table-container">
            <h1 class="text-center">Fruit Store</h1>
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                    </tr>
                </thead>
                <tbody>
                  <c:forEach var="oneFruit" items="${fruitFromController}">
				  <tr>
				    <td><c:out value="${oneFruit.name}"></c:out></td>
				    <td><c:out value="${oneFruit.price}"></c:out></td>
				  </tr>
				  </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>



















































	 

