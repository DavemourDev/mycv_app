<!DOCTYPE html>
<html lang="es-ES">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Formaciones</title>
        
        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        
        <!--Hoja de estilos CSS-->
        <link rel="stylesheet" type="text/css" href="<%ViewUtils.CSS_ROOT;%>estilos-formulario.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        
        
    </head>
    
    <body>
            
        <div class="container">
            
            <div class="row nuevoItem">
                <div class="col-lg-12">
                    <button><a href="#">A�ade una nueva formaci�n</a></button>
                </div>
            </div><br>
            
            <form>
                <div class="row espaciador">
                    <div class="col-lg-3">
                        <label>Nombre del t�tulo</label>
                    </div>
                    <div class="col-lg-12">
                        <input class="form-control" name="nombreTitulo" type="text" placeholder="Nombre del t�tulo...">
                    </div>
                </div>
                
                <div class="row espaciador">
                    <div class="col-lg-2">
                        <label>Sector</label>
                    </div>
                    <div class="col-lg-12">
                        <select name="sector" class="form-control" required>
                            <option value="1">Opci�n 1</option>
                            <option value="2">Opci�n 2</option>
                        </select>
                    </div>
                </div>
                
                <div class="row espaciador">
                   <div class="col-lg-4">
                        <label>Nombre del centro</label>
                    </div>
                    <div class="col-lg-12">
                        <input name="nombre_del_centro" class="form-control" placeholder="Nombre del centro..." required>
                    </div> 
                </div>      
                                
                <div class="row espaciador">
                   <div class="col-lg-6">
                        <label>Pa�s</label>
                        <select name="pais"  class="form-control" required>
                            <option value="1">Opci�n 1</option>
                            <option value="2">Opci�n 2</option>
                        </select>
                    </div>
                    <div class="col-lg-6">
                        <label>Ciudad </label>
                        <input name="ciudad" class="form-control" placeholder="Nombre del ciudad..." required>
                    </div>
                </div>
                
                <div class="row espaciador">
                    <div class="col-lg-4">
                        <label>Fecha Inicio</label>
                        <input name="fecha_inicio" type="date" class="form-control" required>
                    </div>
                    <div class="col-lg-4">
                        <label>Fecha Final</label>
                        <input name="fecha_final" type="date" class="form-control" required>
                    </div>
                    <div class="col-lg-4">
                        <label>Horas (Opcional)</label>
                        <input name="horas" class="form-control">
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
                        <h3>Instituto <small>Pedro Pajares</small></h3>
                        <p>Febrero 2016 - Enero 2017</p>
                        <p>Era un cole superchuli, me sabe mal haber acabado ya</p>
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
                        <h3>Colegio <small>Maria Unpajote</small></h3>
                        <p>Febrero 2016 - Enero 2017</p>
                        <p>Siempre jugabamos a las casitas mientras la profe se emborrachaba bebeiendo whiskey de su termo especial</p>
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