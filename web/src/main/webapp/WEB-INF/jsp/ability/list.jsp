<%-- 
    Document   : list
    Created on : 10.12.2015, 17:34:21
    Author     : petr.melicherik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head_common.jsp" %>
        <title>Abilities</title>
    </head>
    <body>
        <div id="main">
            <%@include file="../includes/header.jsp" %>
            <%@include file="../includes/nav.jsp" %>
            <section>
                <h1>Ability list:</h1>

                <table class="table">
                    <caption>Abilities</caption>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>description</th>
                            <th>detail</th>
                            <th>delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${abilities}" var="ability">
                            <tr>
                                <td>${ability.id}</td>
                                <td><c:out value="${ability.name}"/></td>
                                <td><c:out value="${ability.description}"/></td>
                                <td><a href="detail/${ability.id}">Detail</a></td>
                                <td><a href="delete/${ability.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
                <div>
                    <a href="add">Add new ability</a>&nbsp;
                </div>
            </section>
            <%@include file="../includes/footer.jsp" %>
        </div> 
    </body>
</html>
