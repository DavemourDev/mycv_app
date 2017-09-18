<%@page import="config.Config"%>
<%@page import="model.User"%>
<%@page import="helpers.RequestUtils"%>
<!--Aparece si el usuario está logueado-->


<nav class="navbar navbar-default navigation-color">

    <div class="container">
        <div class="navbar-header navbar-left">
            <a class="navbar-brand" href="index.jsp">
                <img width="90" src="/mycv_app/assets/img/logo.svg"/>
            </a>
        </div>
        <div class="navbar-header navbar-right">
            <span class="well"><%=RequestUtils.getSessionUser(request).getEmail()%></span>
            <a class="btn btn-info" href="Logout">Desconectar</a>
        </div>
    </div>
</nav>