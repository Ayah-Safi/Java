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
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Queries and Joins</title>
</head>
<body style="margin: 5vw;">
	<p style="text-align: center;">
		<span id="top"> <a href="#q1">Query 1</a> | <a href="#q2">Query
				2</a> | <a href="#q3">Query 3</a> | <a href="#q4">Query 4</a> | <a
			href="#q5">Query 5</a> | <a href="#q6">Query 6</a> | <a href="#q7">Query
				7</a> | <a href="#q8">Query 8</a>
		</span>
	</p>
	<div>
		<h3 id="q1">QUERY 1</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">COUNTRY</th>
					<th class="text-center">LANGUAGE</th>
					<th class="text-center">PERCENTAGE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${sloveneSpeakingCountries}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
						<td class="text-center"><c:out value="${column[2]}%" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h3 id="q2">QUERY 2</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">COUNTRY</th>
					<th class="text-center">CITIES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${citiesPerCountry}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h3 id="q3">QUERY 3</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">CITY</th>
					<th class="text-center">POPULATION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${mexicanCityPop}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h3 id="q4">QUERY 4</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">COUNTRY</th>
					<th class="text-center">LANGUAGE</th>
					<th class="text-center">PERCENTAGE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${countryLanguages}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
						<td class="text-center"><c:out value="${column[2]}%" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h3 id="q5">QUERY 5</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">COUNTRY</th>
					<th class="text-center">SURFACE AREA</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${countrySurfaceArea}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h3 id="q6">QUERY 6</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">COUNTRY</th>
					<th class="text-center">GOVERNMENT FORM</th>
					<th class="text-center">SURFACE AREA</th>
					<th class="text-center">LIFE EXPECTANCY</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${constitutionalMonarchies}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
						<td class="text-center"><c:out value="${column[2]}" /></td>
						<td class="text-center"><c:out value="${column[3]}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h3 id="q7">QUERY 7</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">COUNTRY</th>
					<th class="text-center">CITY</th>
					<th class="text-center">DISTRICT</th>
					<th class="text-center">POPULATION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${argentinaCities}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
						<td class="text-center"><c:out value="${column[2]}" /></td>
						<td class="text-center"><c:out value="${column[3]}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<h3 id="q8">QUERY 8</h3>
		<p>
			<a href="#top">Back to top</a>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">REGION</th>
					<th class="text-center">COUNTRIES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="column" items="${countriesPerRegion}">
					<tr>
						<td class="text-center"><c:out value="${column[0]}" /></td>
						<td class="text-center"><c:out value="${column[1]}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>