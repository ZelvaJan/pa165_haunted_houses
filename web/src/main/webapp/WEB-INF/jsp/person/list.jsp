<%-- 
    Document   : list
    Created on : 9.12.2015, 18:58:37
    Author     : skornok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/main.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" />
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
                    <th>admin</th>
                    <th>edit</th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${people}" var="person">
                    <tr>
                        <td>${person.id}</td>
                        <td><c:out value="${person.email}"/></td>
                        <td><c:out value="${person.admin}"/></td>
                        <td><a href="edit/${person.id}" id="EditPerson" >Edit</a></td>
                        <td><a href="delete/${person.id}" id="DeletePerson" >Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br>
        <a href="add" id="AddPerson" >Add new person</a>&nbsp;    </body>
</html>
