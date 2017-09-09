<%@page import="model.User"%>
<%@page import="helpers.RequestUtils"%>
<!--Aparece si el usuario está logueado-->


<nav class="navbar navbar-default navigation-color">

    <div class="container">
        <div class="navbar-header navbar-left">
            <a class="navbar-brand" href="index.jsp">My website</a>
        </div>
        <div class="navbar-header navbar-right">
            <span class="well"><%=user.getEmail()%></span>
            <a class="btn btn-info" href="Logout">Desconectar</a>
        </div>
    </div>
</nav>