<%-- 
    Document   : add
    Created on : 10.12.2015, 17:45:55
    Author     : skornok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new person</title>
    </head>
    <body>

        <form:form method="post" action="${pageContext.request.contextPath}/person/add"
                   modelAttribute="personCreate" cssClass="form-horizontal">

            <div class="form-group ${email_error?'has-error':''}">
                <form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
                    <div class="col-sm-10">
                    <form:input path="email" cssClass="form-control"/>
                    <form:errors path="email" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${password_error?'has-error':''}">
                <form:label path="password" cssClass="col-sm-2 control-label">Password</form:label>
                    <div class="col-sm-10">
                    <form:password path="password" cssClass="form-control"/>
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
