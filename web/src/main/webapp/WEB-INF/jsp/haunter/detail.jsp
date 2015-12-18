<%-- 
    Document   : detail
    Created on : Dec 18, 2015, 12:10:56 PM
    Author     : zelva
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
                <h1>${haunter.name}</h1>

                <table class="table">
                    <caption>Haunter ${haunter.name}</caption>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>haunting hours</th>
                            <th>description</th>
                            <th>haunting reason</th>
                            <th>abilities</th>
                            <th>delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${haunter.id}</td>
                            <td><c:out value="${haunter.name}"/></td>
                            <td><c:out value="${haunter.hauntingHours.fromTime} - ${haunter.hauntingHours.toTime}"/></td>
                            <td><c:out value="${haunter.description}"/></td>
                            <td><c:out value="${haunter.hauntingReason}"/></td>
                            <td>
                                <ul>
                                    <c:forEach items="${haunter.abilities}" var="ability">
                                        <li>
                                            <c:url value="/ability" var="homeUrl" />
                                            <a href="${homeUrl}/detail/${ability.id}">${ability.name}</a>
                                        </li>
                                    </c:forEach>
                                </ul>                                    
                            </td>
                            <td><a href="../delete/${haunter.id}">Delete</a></td>
                        </tr>
                    </tbody>
                </table>

                <h2> Compare with another haunter </h2>
                <form:form method="post" action="${pageContext.request.contextPath}/haunter/compare/${haunter.id}"
                           modelAttribute="selectedHaunter" cssClass="form-horizontal">
                    <form:select name="selectID" path="id">
                        <c:forEach items="${haunters}" var="haunterItem">
                            <form:option value="${haunterItem.id}">${haunterItem.name}</form:option>
                        </c:forEach>
                    </form:select>

                    <button class="btn btn-primary" type="submit">Submit</button>
                </form:form>

                <div>
                    <a href="../edit/${haunter.id}">Edit haunter</a>&nbsp;
                </div>
            </section>
            <%@include file="../includes/footer.jsp" %>
        </div> 
    </body>
</html>
