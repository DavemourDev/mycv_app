<%--Archivo de prueba para exportar a pdf--%>

<!DOCTYPE html>
<html lang="es-ES">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Datos Personales</title>
        
        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        
        <!--Hoja de estilos CSS-->
        <link rel="stylesheet" type="text/css" href="estilosFormularios.css">
        
        <style>
            
            /*FORMULARIO DATOS PERSONALES*/
            h4.titulo {
                color:black;
                text-align: center;
                margin-bottom: 5px;}
            
            #buttoncancel {
                background-color: #F8F8FF;
                border-radius: 5px;}
            
            a.cancel {
                text-decoration: none;
                color: initial;}
            
            /*HERRAMIENTA SEPARADOR*/
            div.espaciador {
                margin-bottom: 15px;}
            
            
            /*RECUADRO DE LOS APARTADOS*/
            div.limitline{
                border: solid #F2F2F2 1px;
                border-radius: 5px;
                padding-top: 20px;
                padding-bottom: 20px;}
                        
        </style>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js">
        </script>
        
    </head>
    
    <body>
        
        
        <div id="lacosa">
            
            <h2>Hola</h2>
        </div>
        <form id="elform">
            
            <div class="container the-content">
                <div class="row">
                    <div class="col-lg-12">
                        <h4 class="titulo">Ahora marca los campos que no deseas que aparezcan en tu CV</h4>
                    </div>
                </div><hr><br>
                
                <div class="row espaciador limitline">
                    <div class="col-lg-12">
                        <label>DATOS PERSONALES</label>
                    </div>
                    <div class="col-lg-8">
                        <div class="col-lg-12">
                            <input type="checkbox" name="name" value="name">
                            <label>Antonio Perez</label>
                        </div>
                        <div class="col-lg-12">
                            <input type="checkbox" name="birthdate" value="birthdate">
                            <label>03/Enero/1990</label>
                        </div>
                        <div class="col-lg-12">
                            <input type="checkbox" name="city" value="city">
                            <label>Hospitalet. España</label>
                        </div>
                        <div class="col-lg-12">
                            <input type="checkbox" name="telephone1" value="telephone1">
                            <label>584 777 382</label>
                        </div>
                        <div class="col-lg-12">
                            <input type="checkbox" name="email" value="email">
                            <label>antonioperez@gmail.com</label>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div style="float: right">
                        <input type="checkbox" name="picture" value="picture">
                        <img src="http://lorempixel.com/150/150" alt="profile picture">
                        </div>
                    </div>
                </div>
                
                
                
                <div class="row espaciador limitline">
                    <div class="col-lg-12">
                        <label>EXPERIENCIA LABORAL</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="exper1" value="exper1">
                        <label>Ayudante en Moke Architecten. 2015-2017</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="exper2" value="exper2">
                        <label>Diseñador jefe en IKEA. 2014-2016</label>
                    </div>
                </div>
                
                
                <div class="row espaciador limitline">
                    <div class="col-lg-12">
                        <label>FORMACIÓN</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="formacion1" value="formacion1">
                        <label>Grado en Telecomunicaciones. Universidad de Barcelona. 2013-2017</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="formacion2" value="formacion2">
                        <label>Grado medio en Mecànica. 2011-2013</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="formacion3" value="formacion3">
                        <label>Curso de programación orientada a objetos con JAVA. 2015</label>
                    </div>
                </div>
                
                
                <div class="row espaciador limitline">
                    <div class="col-lg-12">
                        <label>IDIOMAS</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="idioma1" value="idioma1">
                        <label>Inglés. Hablado: Avanzado, Escrito: Medio, Leído: Excelente</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="idioma2" value="idioma2">
                        <label>Francés. Hablado: Avanzado, Escrito: Medio, Leído: Excelente</label>
                    </div>    
                </div>
                
                
                <div class="row espaciador limitline">
                    <div class="col-lg-12">
                        <label>OTROS</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="otro1" value="otro1">
                        <label>Carnet de conducir: B</label>
                    </div>
                    <div class="col-lg-12">
                        <input type="checkbox" name="otro2" value="otro2">
                        <label>Primer premio de pintura Arameo</label>
                    </div>    
                </div>
                
                
                
                <div class="row text-center">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-4">
                        <button type="submit">GUARDAR CONFIGURACIÓN</button>
                    </div>
                    <div class="col-lg-4">
                        <button type="button" id="buttoncancel"><a href="#" class="cancel">CANCELAR</a></button>
                    </div>
                    <div class="col-lg-2">
                        <button onclick="fes();">Baixar PDF</button>
                    </div>
                </div>
            </div>
        </form>
        
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <script>
            
            window.evitaMarxar=true;
            
            window.onbeforeunload = function(){
                if (window.evitaMarxar)
                {return "Si sales sin guardar tu datos los perderas.";}};
            
            
            $('form#elform').submit(function(e) {
                window.evitaMarxar=false;
            });
            
        </script>
        <script>
             
             
        function fes() {
            
            var specialElementHandlers = {
                '#editor': function(element, renderer) {
                    return true;
                }
            };


            var doc = new jsPDF();

            doc.fromHTML($('#lacosa').html(), 15, 15, {
                'width': 170,
                'elementHandlers': specialElementHandlers
            });

            doc.save('sample-file.pdf');
            }

    

    </script>
        
    </body>
</html>