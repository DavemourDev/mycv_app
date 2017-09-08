<%@page import="helpers.RequestUtils"%>


<!DOCTYPE html>
<html lang="es-ES">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Otros</title>
        
        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        
        <!--Hoja de estilos CSS-->
        <link rel="stylesheet" type="text/css" href="<%ViewUtils.CSS_ROOT;%>estilos-formulario.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){$(".nuevaExper").children("div").click(function(){$("form").slideToggle();});});
        </script>
        
    </head>
    
    <body>
            
        <div class="container">
            
            <div class="row nuevaExper">
                <div class="col-lg-12">
                    <button><a href="#">Añade un nuevo dato de interés</a></button>
                </div>
            </div><br>
            
            <form action="OtherInfo" method="POST">
                <div class="row espaciador">
                    <div class="col-lg-3 ">
                        <label>Título</label>
                    </div>
                    <div class="col-lg-12">
                        <input name="titulo" type="text" class="form-control" required>
                    </div>
                </div>
                
                <div class="row espaciador">
                    <div class="col-lg-2">
                        <label>Descripción</label>
                    </div>
                    <div class="col-lg-12">
                       <textarea class="form-control" name="comentario" style="width: 100%; height: 100px" placeholder="Breve descripción..."></textarea>
                       
                    </div>
                </div>
                
                <div class="row espaciador">
                    <div class="col-lg-3 ">
                        <label>Categoría</label>
                    </div>
                    <div class="col-lg-12">
                        <input name="categoria" type="text" class="form-control" required>
                    </div>
                </div>   
           
                <div class="row espaciador">
                    <div class="col-lg-3 ">
                        <label>Tags</label>
                    </div>
                    <div class="col-lg-12">
                        <input name="tagOtros" type="text" class="form-control" required>
                    </div>
                </div>
                
                <div class="row text-center">
                    <div class="col-lg-12">
                        <button>GUARDAR</button>
                    </div>
                </div>
            
            </form>
            
            <hr><br>
            
            <div class="row">
                <div class="col-lg-10">
                    <div class="campoyaintroducido">    
                        <h3>Carnet <small>A2</small></h3>
                        <p>Carnets</p>
                        
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
                        <h3>Lenguage programación <small>C++</small></h3>
                        <p>lenguajes de programacion</p>
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