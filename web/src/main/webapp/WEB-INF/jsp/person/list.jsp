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
        <%@include file="../includes/head_common.jsp" %>
        <title>People</title>
    </head>
    <body>
        <div id="main">
            <%@include file="../includes/header.jsp" %>
            <%@include file="../includes/nav.jsp" %>
            <section>
                <h1>People</h1>
                <table class="table">
                    <caption>People</caption>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>email</th>
                            <th>admin</th>
                            <th>detail</th>
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
                                <c:url value="/person" var="homeUrl" />
                                <td><a href="${homeUrl}/detail/${person.id}" id="DetailPerson" >detail</a></td>
                                <td><a href="${homeUrl}/edit/${person.id}" id="EditPerson" >edit</a></td>
                                <td><a href="${homeUrl}/delete/${person.id}" id="DeletePerson" >delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <br>
                <a href="add" id="AddPerson" >Add new person</a>&nbsp;
            </section>
            <%@include file="../includes/footer.jsp" %>
        </div>
    </body>
</html>
