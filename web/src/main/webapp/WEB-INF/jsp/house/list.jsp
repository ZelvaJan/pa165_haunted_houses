<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%--
  User: turcovsky
  Date: 10/12/15
  Time: 20:33
--%>

<!DOCTYPE html>
<html>
<head>
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Houses</title>
</head>
<body>
	<h1>House list:</h1>

	<table class="table">
		<caption>Houses</caption>
		<thead>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>address</th>
			<th>haunted since</th>
			<th>description</th>
			<%--TODO haunters link--%>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${houses}" var="house">
		<tr>
			<td>${house.id}</td>
			<td><c:out value="${house.name}"/></td>
			<td><c:out value="${house.address}"/></td>
			<td><c:out value="${house.hauntedSince}"/></td>
			<td><c:out value="${house.description}"/></td>
			<!-- TODO odkaz na haunters list -->
		</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>
