<%-- 
    Document   : login
    Created on : 28-ago-2017, 20:43:42
    Author     : OSCAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action ="MainServlet" method="post">
    <input type="text" name="vista" placeholder="vista"/>
    <input type="email" name="email" placeholder="email"/>
    <input type="password" name="password" placeholder="password"/>
    <input type="submit" value="Login"/>
</form>