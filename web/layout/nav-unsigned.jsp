<%@page import="config.Config"%>
<!--Aparece si el usuario no está logueado-->

<nav class="navbar navbar-default navigation-color">

    <div class="container">
        <div class="navbar-header navbar-left">
            <a class="navbar-brand" href="home">
                <img width="95" src="/mycv_app/assets/img/logo_blanco.svg"/>
            </a>
        </div>
        <form action="home" method="POST" class="navbar-form navbar-right">
            <div class="form-group">
                <label class="text-info"><%=Dictionary.vocab("email-form-label")%></label>
                <input type="email" class="form-control" name="email" placeholder="Log in with your email" required>
            </div>
            <div class="form-group">
                <label class="text-info"><%=Dictionary.vocab("password-form-label")%></label>
                <input type="password" class="form-control" name="password" placeholder="Insert your password" required>
            </div>
            <input type="hidden" name="_action" value="login"/>
            <div class="form-group">
                <input type="submit" name="login" value="<%=Dictionary.vocab("login")%>" class="btn btn-success">
            </div>
        </form>
    </div>
</nav>