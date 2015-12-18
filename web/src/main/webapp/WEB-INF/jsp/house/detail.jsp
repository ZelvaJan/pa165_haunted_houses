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
	<%@include file="../includes/head_common.jsp" %>
	<title>House detail</title>
</head>
<body>
<div id="main">
	<%@include file="../includes/header.jsp" %>
	<%@include file="../includes/nav.jsp" %>
	<section>
		<h1>House detail</h1>

		<table class="table">
			<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>address</th>
				<th>haunted since</th>
				<th>description</th>
				<th>haunter</th>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td>${house.id}</td>
					<td><c:out value="${house.name}"/></td>
					<td><c:out value="${house.address}"/></td>
					<td><c:out value="${house.hauntedSince}"/></td>
					<td><c:out value="${house.description}"/></td>
					<td>
						<c:if test="${empty house.haunter}">
							no haunter
						</c:if>
						<c:if test="${not empty house.haunter}">
							<a href="detail/${house.haunter.id}" id="DetailHaunter">${house.haunter.name}</a>
						</c:if>
					</td>
					<td><a href="edit/${house.id}" id="EditHouse">Edit</a></td>
				</tr>
			</tbody>
		</table>
	</section>
	<%@include file="../includes/footer.jsp" %>
</div>
</body>
</html>
