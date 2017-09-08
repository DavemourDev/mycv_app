<%@page import="java.util.ArrayList"%>
<%@page import="config.Config"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>

<!DOCTYPE html>
<html lang="<%=Config.LANGUAGE%>">
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

        <link rel="stylesheet" type="text/css" href="/java_servlet/assets/css/base-layout.css"/>

    </head>
    <body>

        <nav class="navbar navbar-default navigation-color">

            <div class="container">
                <div class="navbar-header navbar-left">
                    <a class="navbar-brand" href="index.jsp">My website</a>
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

        <% if (request.getAttribute("notification-error") != null) {%>
        <div class="alert alert-danger text-center" role="alert"><%= request.getAttribute("notification-error")%></div>
        <%}%>

        <% if (request.getAttribute("notification-success") != null) {%>
        <div class="alert alert-success text-center" role="alert"><%= request.getAttribute("notification-success")%></div>
        <%}%>
