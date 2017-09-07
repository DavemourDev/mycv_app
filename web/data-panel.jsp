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
                color: #FFF;
                text-align: center;
                color: white;
                padding-top: 42px;
            }

            div.box-principal {
                padding: 30px 30px 30px 30px;
                /*border: 1px solid grey;*/
                width: 800px;
                margin: auto;
                /*--Este centra todo el bloque del formulario horizontalmente--*/
                background-color: #AED6F1;
                border-radius: 10px;
                box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);
                -webkit-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);
                -moz-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);
            }

            .box-principal2 {
                padding: 30px 30px 0px 30px;
                width: 800px;
                margin: auto;
                /*--Este centra todo el bloque del formulario horizontalmente--*/
                background-color: none;
                /*box-shadow: 6px 6px 4px rgba(0, 0, 0, .1); -webkit-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1); -moz-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);  
                */
            }

            div.box-principal button {
                padding: 5px;
                text-transform: uppercase;
                font-weight: bold;
                width: 100%;
            }

            ul {
                list-style-type: none;
                padding-left: 15px;
            }

            li {
                float: left;
                width: 229px;
                background-color: black;
                border-radius: 14px 16px 0 0;
                border-top: 1px solid #000;
                border-left: 1px solid #000;
                border-right: 1px solid #000;
                border-bottom: none;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111;
                border-radius: 15px 15px 0 0;
                border-top: 1px solid #000;
                border-left: 1px solid #000;
                border-right: 1px solid #000;
                border-bottom: none;
                text-decoration: none;
            }

            li.datos a:hover {
                background-color: transparent;
                border: none;
            }

            li.datos {
                background-color: #AED6F1;
                border: 1px solid #000;
                border-bottom: none;
                color: #85C1E9;
            }

            button.botones {
                padding-top: 42px;
                width: 100%;
                margin-bottom: 15px;
                border: none;
                border-radius: 7px;
                color: #FFF;
                font-family: 'Roboto', sans-serif;
                font-weight: 500;
                transition: 0.2s ease;
                cursor: pointer;
                background: #DD4B39;
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

        </style>

    </head>

    <body>



        <div class="box-principal2">

            <div class="container">
                <div class="row caixes">
                    <div class="col-lg-12">
                        <ul class="box">
                            <li><a class="curriculums" href="#home">Ver mis curriculums</a></li>
                            <li class="datos"><a href="">Editar mis datos</a></li>
                            <li><a href="plantilla">Modificar plantilla</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="box-principal">


            <div class="container">
                <div class="row caixes">
                    <div class="col-lg-12">
                        <h1 class="titulo"> QUE DECEAS HACER ? </h1>
                    </div>
                </div>

                <br>
                <br>
                <div class="row caixes">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <button class="botones   ">DATOS PERSONALES</button><br>
                        <button class="botones ">EXPERIENCIA PROFECIONAL</button><br>
                        <button class="botones ">EDUCACIÓN</button><br>
                        <button class="botones ">LENGUAS</button><br>
                        <button class="botones ">AÑADE UN NUEVO APARTADO</button>
                    </div>

                    <div class="col-lg-3"></div>
                </div>
                <br>
            </div>

        </div>



        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

    </body>

</html>