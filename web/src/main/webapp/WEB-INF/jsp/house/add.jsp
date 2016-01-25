<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%--
  User: turcovsky
  Date: 10/12/15
  Time: 20:34
--%>

<html>
    <head>
        <%@include file="../includes/head_common.jsp" %>
        <title>Add a new House</title>
    </head>
    <body>
        <div id="main">
            <%@include file="../includes/header.jsp" %>
            <%@include file="../includes/nav.jsp" %>
            <section>
                <h1>Add new house</h1>

                <form:form method="post" action="${pageContext.request.contextPath}/house/create"
                           modelAttribute="houseCreate" cssClass="form-horizontal">

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

                    <div class="form-group">
                        <form:label path="hauntedSince" cssClass="col-sm-2 control-label">Haunted since</form:label>
                            <div class="col-sm-10">
                            <form:input path="hauntedSince" cssClass="form-control" />
                            <form:errors path="hauntedSince" cssClass="help-block"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="description" cssClass="col-sm-2 control-label">Description</form:label>
                            <div class="col-sm-10">
                            <form:input path="description" cssClass="form-control" />
                            <form:errors path="description" cssClass="help-block"/>
                        </div>
                    </div>

                    <%--TODO select collection of haunters haunting this house--%>
                    <%--<div class="form-group">--%>
                    <%--<form:label path="description" cssClass="col-sm-2 control-label">Description</form:label>--%>
                    <%--<div class="col-sm-10">--%>
                    <%--<form:select path="haunter" cssClass="form-control">--%>
                    <%--<c:forEach items="${categories}" var="c">--%>
                    <%--<form:option value="${c.id}">${c.name}</form:option>--%>
                    <%--</c:forEach>--%>
                    <%--</form:select>--%>
                    <%--<form:errors path="description" cssClass="help-block"/>--%>
                    <%--</div>--%>
                    <%--</div>--%>

                    <button class="btn btn-primary" type="submit">Add house</button>
                </form:form>
            </section>
            <%@include file="../includes/footer.jsp" %>
        </div>
    </body>
</html>
