<%-- 
    Document   : custom_error
    Created on : Dec 18, 2015, 12:02:51 PM
    Author     : zelva
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>

        <c:if test="${not empty exception.errCode}">
            <h1>${exception.errCode} : System Errors</h1>
        </c:if>

        <c:if test="${empty exception.errCode}">
            <h1>System Errors</h1>
        </c:if>

        <c:if test="${not empty exception.errMsg}">
            <h2>${exception.errMsg}</h2>
        </c:if>

    </body>
</html>
