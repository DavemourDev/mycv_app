<%-- 
    Document   : control-panel
    Created on : 31-ago-2017, 12:54:52
    Author     : mati
--%>

<%@page import="model.User"%>

<%
    User user = (User) request.getSession().getAttribute("user");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Control panel</h1>
        <p>User id: <%= user.getId()%></p>
        <p>User email: <%= user.getEmail()%></p>
        <p>User password: <%= user.getPassword()%></p>
          
    </body>
</html>
