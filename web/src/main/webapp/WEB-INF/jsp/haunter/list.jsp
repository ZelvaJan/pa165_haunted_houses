<%-- 
    Document   : list
    Created on : 10.12.2015, 18:57:06
    Author     : petr.melicherik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head_common.jsp" %>
        <title>Haunters</title>
    </head>
    <body>
        <div id="main">
            <%@include file="../includes/header.jsp" %>
            <%@include file="../includes/nav.jsp" %>
            <section>
                <h1>Haunter list:</h1>
                <table class="table">
                    <caption>Haunters</caption>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>description</th>
                            <th>haunting reason</th>
                            <!-- TODO dalsi parametry z DTO -->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${haunters}" var="haunter">
                            <tr>
                                <td>${haunter.id}</td>
                                <td><c:out value="${haunter.name}"/></td>
                                <td><c:out value="${haunter.description}"/></td>
                                <td><c:out value="${haunter.hauntingReason}"/></td>
                                <!-- TODO odkaz na hunters list pro tuhle ability -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
			<%@include file="../includes/footer.jsp" %>
        </div>
    </body>
</html>
