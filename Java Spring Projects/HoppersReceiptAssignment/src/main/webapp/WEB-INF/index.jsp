<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Receipt</title>
</head>
<body>
<h2>Simple Receipt</h2>
<p>Customer Name: <c:out value="${name}"/></p>
<p>Item name: <c:out value="${itemName}"/></p>
<p>Price: <c:out value="${price}"/></p>
<p>Description: <c:out value="${description}"/></p>
<p>Vendor: <c:out value="${vendor}"/></p>
</body>
</html>