<%-- 
    Document   : deteail
    Created on : Dec 17, 2015, 4:04:22 PM
    Author     : zelva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head_common.jsp" %>
        <title>${ability.name}</title>
    </head>
    <body>
        <div id="main">
            <%@include file="../includes/header.jsp" %>
            <%@include file="../includes/nav.jsp" %>
            <section>
                <h1>${ability.name}</h1>

                <table class="table">
                    <caption>Ability: ${ability.name}</caption>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>description</th>
                            <th>delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${ability.id}</td>
                            <td><c:out value="${ability.name}"/></td>
                            <td><c:out value="${ability.description}"/></td>
                            <td><a href="../delete/${ability.id}">Delete</a></td>
                        </tr>
                    </tbody>
                </table>

            </section>
            <%@include file="../includes/footer.jsp" %>
        </div> 
    </body>
</html>
