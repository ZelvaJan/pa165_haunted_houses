<%-- 
    Document   : list
    Created on : 10.12.2015, 17:34:21
    Author     : petr.melicherik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/main.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abilities</title>
    </head>
    <body>
        <h1>Ability list:</h1>
    </body>

    <table class="table">
        <caption>Abilities</caption>
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <!-- TODO odkaz na hunters list pro tuhle ability -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${abilities}" var="ability">
                <tr>
                    <td>${ability.id}</td>
                    <td><c:out value="${ability.name}"/></td>
                    <td><c:out value="${ability.description}"/></td>
                    <!-- TODO odkaz na hunters list pro tuhle ability -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
