<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <%@include file="includes/head_common.jsp" %>
        <title>Messages : Create</title>
    </head>
    <body>
        <div>
            <form:form name="login" method="post" action="${pageContext.request.contextPath}/login"
                       modelAttribute="user">
                <div>
                    <label for="username">Username</label>
                    <input type="text" id="username" name="email"/>     
                </div>
                <div>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"/>    
                </div>

                <button class="btn btn-primary" type="submit">Login</button>
            </form:form>

            <c:if test="${param.error ne null}">
                <p>Login failed or not admin!!<p>
                </c:if>
        </div>
    </body>
</html>