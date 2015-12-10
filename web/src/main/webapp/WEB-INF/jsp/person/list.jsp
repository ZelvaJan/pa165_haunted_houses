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
                    <th>given name</th>
                    <th>surname</th>
                    <th>email</th>
                    <th>phone</th>
                    <th>address</th>
                    <th>joined</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td><c:out value="${user.givenName}"/></td>
                        <td><c:out value="${user.surname}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.phone}"/></td>
                        <td><c:out value="${user.address}"/></td>
                        <td><fmt:formatDate value="${user.joinedDate}" pattern="yyyy-MM-dd"/></td>
        </tr>
    </c:forEach>
</tbody>
</table>

</body>
</html>
