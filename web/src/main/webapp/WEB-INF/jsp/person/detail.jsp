<%-- 
    Document   : detail
    Created on : 18.12.2015, 14:03:17
    Author     : skornok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head_common.jsp" %>
        <title>${haunter.name}</title>
    </head>
    <body>
        <div id="main">
            <%@include file="../includes/header.jsp" %>
            <%@include file="../includes/nav.jsp" %>
            <section>
                <h1>${person.email}</h1>

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
                        <tr>
                            <td>${person.id}</td>
                            <td><c:out value="${person.email}"/></td>
                            <td><c:out value="${person.admin}"/></td>
                            <c:url value="/person" var="homeUrl" />`
                            <td><a href="${homeUrl}/edit/${person.id}" id="EditPerson" >Edit</a></td>
                            <td><a href="${homeUrl}/delete/${person.id}" id="DeletePerson" >Delete</a></td>
                        </tr>
                    </tbody>
                </table>
            </section>
            <%@include file="../includes/footer.jsp" %>
        </div> 
    </body>
</html>
