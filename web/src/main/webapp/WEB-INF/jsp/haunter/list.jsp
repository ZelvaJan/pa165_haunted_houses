<%-- 
    Document   : list
    Created on : 10.12.2015, 18:57:06
    Author     : petr.melicherik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/main.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Haunters</title>
    </head>
    <body>
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
    </body>
    
</html>
