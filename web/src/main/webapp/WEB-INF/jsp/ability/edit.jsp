<%-- 
    Document   : edit
    Created on : Dec 17, 2015, 4:45:50 PM
    Author     : zelva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head_common.jsp" %>
        <title>Edit ${ability.name}</title>
    </head>
    <body>
        <div id="main">
            <%@include file="../includes/header.jsp" %>
            <%@include file="../includes/nav.jsp" %>
            <section>
                <h1>Edit ${ability.name}</h1>
                
                <form:form method="post" action="${pageContext.request.contextPath}/ability/edit/${id}"
                           modelAttribute="ability" cssClass="form-horizontal">

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

                        <button class="btn btn-primary" type="submit">Submit</button>
                </form:form>
        	</section>
			<%@include file="../includes/footer.jsp" %>
		</div>
    </body>
</html>
