<%-- 
    Document   : list
    Created on : 9.12.2015, 18:58:37
    Author     : skornok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Users</h1>

        <table class="table">
            <caption>Users</caption>
            <thead>
                <tr>
                    <th>id</th>
                    <th>email</th>
                    <th>is admin?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${people}" var="person">
                    <tr>
                        <td>${person.id}</td>
                        <td><c:out value="${person.email}"/></td>
                        <td><c:out value="${person.admin}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="add" id="AddPerson" >Add new person</a>&nbsp;    </body>
</html>
