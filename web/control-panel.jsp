<%-- 
    Document   : control-panel
    Created on : 31-ago-2017, 12:54:52
    Author     : mati
--%>

<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>

<%
    User user = RequestUtils.getSessionUser(request);
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
        <p>User id: ${user.id}</p>
        <p>User email: ${user.email}</p>
        <p>User password: ${user.password}</p>
          
        <p><a href="Logout">Logout</a></p>
        <p><a href="PersonalUpdate">Personal edit</a></p>
        
    </body>
</html>
