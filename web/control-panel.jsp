<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>
<%@page import="helpers.ViewUtils"%>
<%@page import="config.Config"%>

<%ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formulario");%>
<%ViewUtils.setScripts(request, "panel-de-control");%>

<%@include file="layout/upper.jsp"%>

<h1 class="page-header titulo text-center">Panel de control <%=Config.APP_NAME%></h1>

<div class="row">
    <div class="col-lg-12">
        <ul class="nav nav-tabs nav-tabs-hidden" id="control-panel">
            <!--<li class="active"><a href="#home">Principal</a></li>-->
            <li><a class="panel-link" href="#curriculum">Ver mis curriculums</a></li>
            <li><a class="panel-link" href="#my-data">Mis datos</a></li>
            <li><a class="panel-link" href="#profiles">Perfiles</a></li>
        </ul>
    </div>
</div>
<div class="box-principal">
    <div class="container">
        <div id="home" class="panel-section">
            <div class="row">
                <div class="col-lg-3"><!--COLUMNA VACÍA--></div>
                <div class="col-lg-6">
                    <a class="boton-menu panel-link bg-btn-1" href="#my-data">Mis Datos</a>
                    <a class="boton-menu panel-link bg-btn-2" href="#profiles">Mis Plantillas</a>
                    <a class="boton-menu panel-link bg-btn-3" href="#curriculum">Mis CV</a>
                </div>

                <div class="col-lg-3"><!--COLUMNA vacia--></div>
            </div>
        </div>
        <div id="curriculum" class="panel-section">

            <div class="row">

            </div>


        </div>
        <div id="my-data" class="panel-section">
            <div class="col-lg-3"><!--Columna vacía--></div>
            <div class="col-lg-6">
                <h2 class="titulo-seccion">DATOS DE USUARIO</h2>
                <div class="well well-lg">
                    <a href="PersonalData" class="boton-menu bg-btn-3">Datos personales</a>
                    <a href="Experiences" class="boton-menu bg-btn-3">Experiencia profesional</a>
                    <a class="boton-menu bg-btn-3">Formación y educación</a>
                    <a class="boton-menu bg-btn-3">Lenguas</a>
                    <a class="boton-menu bg-btn-3">Otros datos de interés</a>
                </div>
            </div>

            <div class="col-lg-3"><!--Columna vacía--></div>
        </div>
        <div id="profiles" class="panel-section">
            <form action="Profiles" method="POST">
                <div class="container">
                    <h1 class="titulo page-title"> Ordena y filtra tus datos </h1>

                    <br>

                    <div class="row caixes">
                        <div class="col-lg-6 campo">
                            <label>DATOS PERSONALES</label>
                            <select  name="orden">
                                <option value="No">(No)</option>
                                <option value="1"  disabled selected>1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        <br>
                    </div>
                    <br>
                    <div class="row caixes">
                        <div class="col-lg-6 campo">
                            <label>FOTOGRAFÍA</label>
                            <select  name="orden">
                                <option value="No" disabled selected>(No)</option>
                                <option value="der" >Derecha</option>
                                <option value="izq">Izquierda</option>
                            </select>
                        </div>
                    </div>
                    <br>
                    <div class="row caixes">
                        <div class="col-lg-6 campo">
                            <label>EXPERIENCIA PROFESSIONAL</label>
                            <select  name="orden">
                                <option value="No" disabled selected>(No)</option>
                                <option value="1" >1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>

                        </div>
                        <br>
                    </div>
                    <br>
                    <div class="row caixes">
                        <div class="col-lg-6 campo">
                            <select  name="orden">
                                <option value="No">(No)</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                            <label>EDUCACIÓN</label>
                        </div>
                        Aquí irían los tags
                        <br>
                    </div>
                    <br>
                    <div class="row caixes">
                        <div class="col-lg-6 campo">
                            <label>LENGUAS</label>
                            <select  name="orden">
                                <option value="No" disabled selected>(No)</option>
                                <option value="1" >1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>

                        </div>
                        <br>
                    </div>
                    <br>
                    <div class="row caixes">
                        <div class="col-lg-6 campo">
                            <label>OTROS</label>
                            <select  name="orden">
                                <option value="No" disabled selected>(No)</option>
                                <option value="1" >1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        
                        <%@include file="templates/tag-input.jsp"%>
                        
                        <br><br>
                    </div>
                    <div class="col-lg-3"><button>Siguiente</button></div>

                </div>
            </form>
        </div>
    </div>
</div>



<%@include file="layout/lower.jsp"%>
