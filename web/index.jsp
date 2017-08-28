<%-- 
    Document   : index
    Created on : 28-ago-2017, 19:22:11
    Author     : OSCAR
--%>

<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //String view = request.getAttribute("view").toString();
            List<User> users = User.findAll();
            
            String u1 = users.get(1).getEmail();
        %>
        
        
        <%= u1 %>
        <h1>Login</h1>
        <form action ="MainServlet" method="post">
            <input type="text" name="vista" placeholder="vista"/>
            <input type="email" name="email" placeholder="email"/>
            <input type="password" name="password" placeholder="password"/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
