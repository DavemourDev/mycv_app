<%@page import="model.OtherInfoItem"%>
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
            
            <div class="row nuevoItem">
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
            


<%@page import="model.Education"%>
<%@page import="model.EducationLevel"%>
<%@page import="helpers.FormatUtils"%>
<%@page import="helpers.DatabaseUtils"%>
<%@page import="model.Country"%>
<%@page import="model.Sector"%>

<%
    ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formularios");
    ViewUtils.setScripts(request, "form-slides", "formulario-etiquetas");
    
    //Inicializar variables 
    
    List<String> tagsDatalist = new ArrayList<String>();//RequestUtils.getEduTags(request);
    List<OtherInfoItem> otherList = OtherInfoItem.findBy("user_id", String.valueOf(RequestUtils.getSessionUserId(request)));
    
    List<String> tags = new ArrayList<String>();
    String tagInputNS ="New-exp";
    
    int i = 0;
    int n = 0;
%>

<%@include file="layout/upper.jsp" %>

<h1 class="page-header titulo text-center">Otra información</h1>

<a href="#new-item" class="btn btn-info new-item-btn btn-block">Añade una nueva información</a>

<form class="form-hidden form-box" id="new-item" action="Educations" method="POST">
    <h2 class="text-center">Nuevo ítem de otra información</h2>
    <div class="form-group">
        <div class="row">
            <div class="col-lg-4 form-field">
                <label>Nombre del ítem</label>
                <input class="form-control" name="title" type="text" placeholder="Nombre del ítem" required>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label>Descripción</label>
        <textarea name="description" class="form-control" rows="3" placeholder="Breve descripción..." class="form-control"></textarea>
    </div>

    <%@include file="templates/tag-input.jsp"%>
                        
    <input type="hidden" name="_action" value="insert">
    <div class="row text-center espaciador">
        <div class="col-lg-12">
            <input class="btn btn-success btn-block" type="submit" value="Guardar"/>
        </div>
    </div>
</form>

<!--Fin de formulario nuevo-->

<%if(otherList.isEmpty()){%>
    <h2>No tienes educaciones o formaciones guardadas</h2>
<%}else{%>
    <h2 class="text-center">Educaciones y formaciones introducidas</h2>
    <div class="container">
        <%for(OtherInfoItem other : otherList){
            int other_id = other.getId();
            tags = other.getTags();
            tagInputNS = "Edit-item-" + other.getId();
        %>
        <!--Importa la plantilla de item por cada iteración y la rellena con los datos actuales-->
        <%@include file="templates/other_item.jsp"%>
            <!--fin-->
        <%}%>
    </div>
<%}%>
<!--Fin del item-->

<%@include file="layout/lower.jsp" %>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
});
</script>

