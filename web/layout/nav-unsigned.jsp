<%@page import="config.Config"%>
<!--Aparece si el usuario no está logueado-->

<nav class="navbar navbar-default navigation-color">

    <div class="container">
        <div class="navbar-header navbar-left">
            <a class="navbar-brand" href="index.jsp"><%=Config.APP_NAME%></a>
        </div>
        <form action="Login" method="POST" class="navbar-form navbar-right">
            <!--<div class="form-group">
                <h4>Login</h4>
            </div>-->
            <div class="form-group">
                <label class="text-info">Email</label>
                <input type="email" class="form-control" name="email" placeholder="Log in with your email" required>
            </div>
            <div class="form-group">
                <label class="text-info">Password</label>
                <input type="password" class="form-control" name="password" placeholder="Insert your password" required>
            </div>
            <div class="form-group">
                <input type="submit" name="login" value="Login" class="btn btn-success">
            </div>
        </form>
    </div>
</nav>