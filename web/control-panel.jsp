<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>

<%
    User user = RequestUtils.getSessionUser(request);
%>

<!DOCTYPE html>
<html lang="es-ES">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Mis datos</title>
        <link rel="stylesheet" type="text/css" href="estilos.css">

        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">


        <style>
            body {
                padding: 0px;
                background-color: #F8F8FF;
                /*font-family: 'Dosis';*/
            }

            h1.titulo {
                display: block;
                margin-bottom: 10px;
                font-size: 300%;
                text-align: center;
                color: #2980B9;
                padding-top: 30px;
            }

            h2 {
                display: block;
                font-size: 280%;
                text-align: center;
                color: #5DADE2;
                padding-top: 42px;
                font-weight: lighter;
            }

            .box-principal {
                padding: 30px 30px 30px 30px;
                /*border: 1px solid grey;*/
                width: 800px;
                margin: auto;
                margin-top: 20px;
                /*--Este centra todo el bloque del formulario horizontalmente--*/
                background-color: #BFC9CA;
                border-radius: 10px;
                box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);
                -webkit-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);
                -moz-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);
            }

            .box-principal button {
                text-transform: uppercase;
                font-weight: bold;
                width: 100%;
            }

            button.botones {
                margin-bottom: 20px;
                width: 100%;
                height: 38px;
                border: none; border-radius: 2px;
                color: #FFF;
                font-family: 'Roboto', sans-serif;
                font-weight: 500;
                transition: 0.2s ease;
                position: relative;
                cursor: pointer;
            }

            button a{
                color:white;
            }

            button.botones:hover,
            button.botones:focus {
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
                transition: 0.2s ease;
            }

            button.botones:active {
                box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
                transition: 0.2s ease;
            }

            button.botones.datos {
                background: #32508E;
            }

            button.botones.plantillas {
                background: #55ACEE;
            }

            button.botones.cvs {
                background: #DD4B39;
            }

        </style>

    </head>

    <body>

        <div class="box-principal">
            <div class="container">
                <div class="row caixes">
                    <div class="col-lg-12">
                        <h1 class="titulo"> BIENVENIDO AL GESTOR </h1>
                        <hr>
                        <h2>QUE DECEAS HACER?</h2>
                    </div>
                </div>

                <br>
                <br>
                <div class="row caixes">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">


                        <button class="botones datos  "> <a href="UserData">MIS DATOS</a></button>

                        <button class="botones plantillas"><a href="Profiles">MIS PLANTILLAS</a></button>

                        <button class="botones cvs"><a href="#">MIS CVs</a></button>

                    </div>

                    <div class="col-lg-3"></div>
                </div>
                <br>
                <br>
                <br>
            </div>
        </div>



        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

    </body>

</html>
