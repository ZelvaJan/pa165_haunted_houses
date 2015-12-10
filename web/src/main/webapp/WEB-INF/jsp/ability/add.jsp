<%-- 
    Document   : add
    Created on : 10.12.2015, 18:53:56
    Author     : petr.melicherik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New ability</title>
    </head>
    <body>
        <h1>Add new ability</h1>

        <form:form method="post" action="${pageContext.request.contextPath}/ability/add"
                   modelAttribute="newAbility" cssClass="form-horizontal">

            <div class="form-group">
                <form:label path="name" cssClass="col-sm-2 control-label">Name</form:label>
                    <div class="col-sm-10">
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="description" cssClass="col-sm-2 control-label">Description</form:label>
                    <div class="col-sm-10">
                    <form:input path="description" cssClass="form-control"/>
                    <form:errors path="description" cssClass="help-block"/>
                </div>
            </div>

            <button class="btn btn-primary" type="submit">Add ability</button>
        </form:form>
    </body>
</html>
