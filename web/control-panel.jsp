<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>
<%@page import="helpers.ViewUtils"%>

<%ViewUtils.setStylesheets(request, "estilos-panel-principal");%>

<%@include file="layout/upper.jsp"%>

    <div class="box-principal">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header titulo text-center">BIENVENIDO AL GESTOR DE CV COMOSELLAME</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <h2 class="titulo-seccion">¿QUÉ DESEA HACER?</h2>
                    <div class="well well-lg">
                        <a class="boton-menu bg-btn-1" href="UserData">Mis Datos</a>
                        <a class="boton-menu bg-btn-2" href="Profiles">Mis Plantillas</a>
                        <a class="boton-menu bg-btn-3" href="CV">Mis CV</a>
                    </div>
                </div>

                <div class="col-lg-3"></div>
            </div>
        </div>
    </div>



<%@include file="layout/lower.jsp"%>
