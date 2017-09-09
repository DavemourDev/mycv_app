<!DOCTYPE html>
<html lang="es-ES">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Idiomas</title>

        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

        <!--Hoja de estilos CSS-->
        <link rel="stylesheet" type="text/css" href="<%ViewUtils.CSS_ROOT;%>estilos-formulario.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $(".nuevaExper").children("div").click(function () {
                    $("form").slideToggle();
                });
            });
        </script>

    </head>

    <body>

        <div class="container">

            <div class="row nuevoItem">
                <div class="col-lg-12">
                    <button><a href="#">Añade un nuevo idioma</a></button>
                </div>
            </div><br>

            <form>
                <div class="row">
                    <div class="col-lg-12 espaciador">
                        <label>Idioma</label>
                        <select name="idioma" class="form-control">
                            <option value="" disabled selected>(seleccionar)</option>
                            <option value="espanol">Español</option>
                            <option value="ingles">Inglés</option>
                            <option value="frances">Francés</option>
                            <option value="aleman">Alemán</option>
                            <option value="itaiano">Italiano</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-4">
                        <label>Hablado</label>
                    </div>
                    <div class="col-lg-4">
                        <label>Escrito</label>
                    </div>
                    <div class="col-lg-4">
                        <label>Leído</label>
                    </div>
                </div>

                <div class="row espaciador">
                    <div class="col-lg-4">
                        <select name="nivelhablado" class="form-control">
                            <option value="" disabled selected>(seleccionar)</option>
                            <option value="1">Nulo</option>
                            <option value="2">Básico</option>
                            <option value="3">Intermedio</option>
                            <option value="4">Avanzado</option>
                            <option value="5">Excelente</option>
                        </select>
                    </div>

                    <div class="col-lg-4">
                        <select name="nivelescrito" class="form-control">
                            <option value="" disabled selected>(seleccionar)</option>
                            <option value="1">Nulo</option>
                            <option value="2">Básico</option>
                            <option value="3">Intermedio</option>
                            <option value="4">Avanzado</option>
                            <option value="5">Excelente</option>
                        </select>
                    </div>

                    <div class="col-lg-4">
                        <select name="nivelleido" class="form-control">
                            <option value="" disabled selected>(seleccionar)</option>
                            <option value="1">Nulo</option>
                            <option value="2">Básico</option>
                            <option value="3">Intermedio</option>
                            <option value="4">Avanzado</option>
                            <option value="5">Excelente</option>
                        </select>
                    </div>
                </div>

                <div class="row text-center">
                    <div class="col-lg-12">
                        <button type="submit">GUARDAR</button>
                    </div>
                </div>

            </form>

            <hr><br>

            <div class="row">
                <div class="col-lg-10">
                    <div class="campoyaintroducido">    
                        <h3>Idioma <small>Español</small></h3>
                        <p>Hablado:Nativo, Escrito:Nativo, Leído:Nativo</p>

                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="row botonesedel">
                        <div class="col-lg-12">
                            <button><a href="#">EDITA</a></button>
                        </div>
                        <div class="col-lg-12">
                            <button><a href="#">ELIMINA</a></button>
                        </div>
                    </div>
                </div>
            </div>

            <br><hr><br>

            <div class="row">
                <div class="col-lg-10">
                    <div class="campoyaintroducido">    
                        <h3>Idioma <small>Inglés</small></h3>
                        <p>Hablado:Nativo, Escrito:Nativo, Leído:Nativo</p>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="row botonesedel">
                        <div class="col-lg-12">
                            <button><a href="#">EDITA</a></button>
                        </div>
                        <div class="col-lg-12">
                            <button><a href="#">ELIMINA</a></button>
                        </div>
                    </div>
                </div>
            </div>

            <br><hr><br>

        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>       
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

    </body>
</html>