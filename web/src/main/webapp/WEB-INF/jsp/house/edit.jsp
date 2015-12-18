<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  User: turcovsky
  Date: 10/12/15
  Time: 20:33
--%>

<!DOCTYPE html>
<html>
	<head>
		<%@include file="../includes/head_common.jsp" %>
		<title>Edit House</title>
	</head>
	<body>
		<div id="main">
			<%@include file="../includes/header.jsp" %>
			<%@include file="../includes/nav.jsp" %>
			<section>
				<h1>Edit House</h1>
				<form:form method="post" action="${pageContext.request.contextPath}/house/edit/${id}"
						   modelAttribute="house" cssClass="form-horizontal">

					<div class="form-group ${name_error?'has-error':''}">
						<form:label path="name" cssClass="col-sm-2 control-label">Name</form:label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control"/>
							<form:errors path="name" cssClass="help-block"/>
						</div>
					</div>

					<div class="form-group ${address_error?'has-error':''}">
						<form:label path="address" cssClass="col-sm-2 control-label">Address</form:label>
						<div class="col-sm-10">
							<form:input path="address" cssClass="form-control"/>
							<form:errors path="address" cssClass="help-block"/>
						</div>
					</div>

					<div class="form-group ${hauntedSince_error?'has-error':''}">
						<form:label path="hauntedSince" cssClass="col-sm-2 control-label">Haunted since</form:label>
						<div class="col-sm-10">
							<form:input path="hauntedSince" cssClass="form-control"/>
							<form:errors path="hauntedSince" cssClass="help-block"/>
						</div>
					</div>

					<div class="form-group ${description_error?'has-error':''}">
						<form:label path="description" cssClass="col-sm-2 control-label">Description</form:label>
						<div class="col-sm-10">
							<form:input path="description" cssClass="form-control"/>
							<form:errors path="description" cssClass="help-block"/>
						</div>
					</div>

					<div class="form-group ${haunter_error?'has-error':''}">
						<form:label path="haunter" cssClass="col-sm-2 control-label">Haunter</form:label>
						<div class="col-sm-10">
							<form:select name="id" path="id">
								<form:option value="${null}" label="Select a Haunter" />
								<c:forEach items="${haunters}" var="haunter">
									<form:option value="${haunter.id}">${haunter.name}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="haunter" cssClass="help-block"/>
						</div>
					</div>

					<button class="btn btn-primary" type="submit">Edit house</button>
				</form:form>
			</section>
			<%@include file="../includes/footer.jsp" %>
		</div>
	</body>
</html>
