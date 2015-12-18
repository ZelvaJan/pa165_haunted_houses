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
                            <th>haunting hours</th>
                            <th>description</th>
                            <th>haunting reason</th>
                            <th>abilities</th>
                            <th>detail</th>
                            <th>detail</th>
                            <th>delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${haunters}" var="haunter">
                            <tr>
                                <td>${haunter.id}</td>
                                <td><c:out value="${haunter.name}"/></td>
                                <td><c:out value="${haunter.hauntingHours}"/></td>
                                <td><c:out value="${haunter.description}"/></td>
                                <td><c:out value="${haunter.hauntingReason}"/></td>
                                <td>
                                    <ul>
                                        <c:forEach items="${haunter.abilities}" var="ability">
                                            <li>
                                                <a href="../ability/detail/${ability.id}">${ability.name}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>                                    
                                </td>
                                <td><a href="detail/${haunter.id}">Detail</a></td>
                                <td><a href="edit/${haunter.id}">Edit</a></td>
                                <td><a href="delete/${haunter.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br>
                <div>
                    <a href="list/active">List active haunters</a>&nbsp;
                </div>
                <div>
                    <a href="add">Add haunter</a>&nbsp;
                </div>
            </section>
            <%@include file="../includes/footer.jsp" %>
        </div>
    </body>
</html>
