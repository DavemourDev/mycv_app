<%-- 

<jsp:useBean id="user" scope="request" class="model.User"/>
    Document   : show
    Created on : 28-ago-2017, 20:19:41
    Author     : OSCAR
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Show User</h1>
        <dl>
            <dt>Email</dt>
            <dd>${user.email}</dd>
            <dt>Password</dt>
            <dd>${user.password}</dd>
        </dl>
    </body>
</html>
