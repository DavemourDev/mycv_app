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
            //List<User> users = User.findAll();
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if(email != null && password != null)
            {
                User u1 = new User();
                u1.setEmail(email);
                u1.setPassword(password);
                %>
                    
                    <p>Existe? <%= u1.exists() %></p>
                    <p>Autentificado? <%= u1.authentication()%></p>
        
                <%
            }
        %>
        
        <h1>Login</h1>
        <form>
            <input type="email" name="email" placeholder="email"/>
            <input type="password" name="password" placeholder="password"/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
