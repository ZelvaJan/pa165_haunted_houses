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
    <title>Add a new House</title>
</head>
<body>
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
            <form:label path="password" cssClass="col-sm-2 control-label">Password</form:label>
            <div class="col-sm-10">
                <form:input path="password" cssClass="form-control"/>
                <form:errors path="password" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="admin" cssClass="col-sm-2 control-label">admin</form:label>
            <div class="col-sm-10">
                <form:select path="admin" cssClass="form-control">
                    <form:option value="true">yes</form:option>
                    <form:option value="false">no</form:option>
                </form:select>
                <form:errors path="admin" cssClass="error"/>
            </div>
        </div>


        <button class="btn btn-primary" type="submit">Add person</button>
    </form:form>
</body>
</html>
