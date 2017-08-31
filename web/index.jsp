<%-- 
    Document   : index
    Created on : 28-ago-2017, 19:22:11
    Author     : David
--%>

<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Título de la página</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--JQuery-->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <style>
            nav.navigation-color
            {
                background: #eee;
            }

            .alert{
                position:absolute;
            }

        </style>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-static-top navigation-color">

            <div class="container">
                <div class="navbar-header navbar-left">
                    <a class="navbar-brand" href="#">My website</a>
                </div>
                <form action="Login" method="POST" class="navbar-form navbar-right">
                    <!--<div class="form-group">
                        <h4>Login</h4>
                    </div>-->
                    <div class="form-group">
                        <label class="text-info">Email</label>
                        <input type="email" class="form-control" name="email" placeholder="Log in with your email">
                    </div>
                    <div class="form-group">
                        <label class="text-info">Password</label>
                        <input type="password" class="form-control" name="password" placeholder="Insert your password">
                    </div>
                    <div class="form-group">
                        <input type="submit" name="login" value="Login" class="btn btn-success">
                    </div>
                </form>
            </div>
        </nav>

        <% if (request.getAttribute("notification") != null) {%>
        <div class="alert alert-danger" role="alert"><%= request.getAttribute("notification")%></div>
        <%}%>


        <div class="container">
            <section>
                <div class="row">
                    <div class="col-md-8">
                        <div class="jumbotron text-center">
                            <h1>Haz tu propio CV fácilmente</h1>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                            </p>

                        </div>
                    </div>
                    <div class="col-md-4">
                        <h2>No tienes cuenta? Regístrate</h2>
                        <form action="Register" method="POST">
                            <div class="form-group">
                                <label class="control-label">Email</label>
                                <input type="email" class="form-control"  name="email"  placeholder="email">
                            </div>
                            <div class="form-group">
                                <label class="control-label">Password</label>
                                <input type="password" class="form-control" name="password"  placeholder="password">
                            </div>
                            <div class="form-group">
                                <label class="control-label">Nombre</label>
                                <input class="form-control" name="nombre"  placeholder="nombre">
                            </div>
                            <div class="form-group">
                                <label class="control-label">Apellidos</label>
                                <input class="form-control" name="apellidos"  placeholder="apellidos">
                            </div>
                            <div class="form-group">
                                <label class="control-label">Género</label>
                                <div class="radio-group">
                                    <label class="radio-inline"><input type="radio" name="genero" value="h">Hombre</label>
                                    <label class="radio-inline"><input type="radio" name="genero" value="m">Mujer</label>
                                    <label class="radio-inline"><input type="radio" name="genero" value="x">Otro</label>
                                </div>
                            </div>
                            <div class="button-group">    
                                <input type="submit" name="register" value="Register" class="btn btn-success">
                            </div>
                        </form>
                    </div>

                </div>

                <div class="row">
                    <h2 class="text-center">¡Disfruta de nuestros servicios!</h2>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="well text-center">
                            <h3>Toda tu información en un único punto</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="well text-center">
                            <h3>Plantillas personalizables para tu puesto ideal</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="well text-center">
                            <h3>¡Gestionar tus perfiles nunca fue tan fácil!</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script>
            $(function(){
                $(document).on("click", ".alert", function(){
                    $(this).fadeOut();
                });
            });
        </script>
    </body>
</html>
