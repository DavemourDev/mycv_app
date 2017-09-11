
<%@page import="helpers.ViewUtils"%>

<%ViewUtils.setStylesheets(request, "estilos-panel-principal");%>

<%@include file="layout/upper.jsp"%>
<%@include file="templates/control-panel-menu.jsp"%>
<div class="box-principal box-principal-tabs">

    <div class="container">
        
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header titulo text-center">DATOS DE USUARIO</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-3"><!--Columna vacía--></div>
            <div class="col-lg-6">
                <div class="well well-lg">
                    <h2 class="titulo-seccion">DATOS DE USUARIO</h2>
                    <a href="PersonalData" class="boton-menu bg-btn-3">Datos personales</a>
                    <a class="boton-menu bg-btn-3">Experiencia profesional</a>
                    <a class="boton-menu bg-btn-3">Formación y educación</a>
                    <a class="boton-menu bg-btn-3">Lenguas</a>
                    <a class="boton-menu bg-btn-3">Otros datos de interés</a>
                </div>
            </div>

            <div class="col-lg-3"><!--Columna vacía--></div>
        </div>
    </div>

</div>



<%@include file="layout/lower.jsp"%>