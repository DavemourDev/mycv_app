
<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>
<%@page import="model.Personal"%>
<%
    Personal personal = Personal.findById(RequestUtils.getSessionUser(request).getId());
    User user = RequestUtils.getSessionUser(request);
%>

<!DOCTYPE html>
<html lang="es-ES">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Datos Personales</title>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        
        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        
        
        <style>
            
            body { 
                padding:60px;
                background-color: #F8F8FF;
                /*font-family: 'Dosis';*/
            }

            h1.titulo {
                /*font-family: 'Baloo Bhaijaan';*/
                color:black;
                text-align: center;
                margin-bottom: 5px;
            }
            
            
            
            form.miformulario {
                padding: 30px 30px 30px 30px;
                /*border: 1px solid grey;*/
                width: 700px;
                margin: auto; /*--Este centra todo el bloque del formulario horizontalmente--*/
                background-color: white;
                border-radius: 10px;
                box-shadow: 6px 6px 4px rgba(0, 0, 0, .1); -webkit-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1); -moz-box-shadow: 6px 6px 4px rgba(0, 0, 0, .1);  
            }            
            
            .myinbox {
                width: 100%;
            }
            
            form.miformulario button {
                padding: 5px;
                text-transform: uppercase;
                font-weight: bold;
                width: 100%;
            }
            
            #buttoncancel {
                background-color: #F8F8FF;
                border-radius: 5px;                
            }
            
            a.cancel {
                text-decoration: none;
                color: initial;
                text-transform: uppercase; 
            }
                        
        </style>
        
    </head>
    
    <body>
        
        <form class="miformulario" action="http://vcms.vadesan.com/inputs" method="get">
            <div class="container">
                <div class="row caixes">
                    <div class="col-lg-12">
                <h1 class="titulo">Datos Personales</h1>
                    </div>
                    </div><hr><br>
                <div class="row caixes">
                    <div class="col-lg-2">
                        <label>Nombre</label>
                    </div>
                    <div class="col-lg-4">
                        <input name="nombre" type="text" placeholder="Tu nombre..." class="myinbox" value="<%=personal.getName()%>">
                    </div>
                    <div class="col-lg-2">
                        <label>Apellido</label>
                    </div>
                    <div class="col-lg-4">
                        <input name="apellido" type="text" placeholder="Tu apellido..." class="myinbox" value="<%=personal.getLastname()%>">
                    </div>
                </div>
                <br><br>
                <div class="row caixes">
                    <div class="col-lg-2">
                        <label>Fecha de nacimiento</label>
                    </div>
                    <div class="col-lg-4">
                        <input name="fechanacimiento" type="date" placeholder="Tu fecha de nacimiento..." class="myinbox" value="<%=personal.getBirthdate()%>">
                    </div>
                    <div class="col-lg-2">
                        <label>Fotografía (opcional)</label>
                    </div>
                    <div class="col-lg-4">
                        <input name="fotografia" type="file" placeholder="Tu fotografia..." class="myinbox">
                    </div>
                </div>
                <br>
                <div class="row caixes">
                   <div class="col-lg-2">
                        <label>Teléfono móvil</label>
                    </div>
                    <div class="col-lg-4">
                        <input name="telephone1" type="number" placeholder="Tu teléfono móvil..." class="myinbox" value="<%=personal.getName()%>">
                    </div>
                    <div class="col-lg-2">
                        <label>Teléfono 2 (Opcional)</label>
                    </div>
                    <div class="col-lg-4">
                        <input name="telephone2" type="number" placeholder="Tu segundo teléfono..." class="myinbox">
                    </div>
                </div>
                <br>
                <div class="row caixes">
                    <div class="col-lg-2">
                        <label>E-mail</label>
                    </div>
                    <div class="col-lg-10">
                        <input name="email" type="email" placeholder="Tu e-mail..." class="myinbox">
                    </div>
                </div>
                <br><br>
                <input type="hidden" name="u-token" value="<%=user.hashCode()%>"/>
                <div class="row caixes text-center">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-3">
                        <button type="submit" name="submit" value="guardar">guardar</button>
                    </div>
                    <div class="col-lg-3">
                        <button id="buttoncancel"><a href="index.jsp" class="cancel">cancelar</a></button>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
            </div>
        </form>
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        
    </body>
</html>