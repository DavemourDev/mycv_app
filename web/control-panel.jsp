<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>
<%@page import="helpers.ViewUtils"%>
<%@page import="config.Config"%>

<%ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formularios");%>
<%ViewUtils.setScripts(request, "panel-de-control");%>

<%@include file="layout/upper.jsp"%>

<h1 class="page-header titulo text-center">Panel de control <%=Config.APP_NAME%></h1>

<div class="row">
    <div class="col-lg-12">
        <ul class="nav nav-tabs nav-tabs-hidden" id="control-panel">
            <!--<li class="active"><a href="#home">Principal</a></li>-->
            <li><a class="panel-link" href="#curriculum">Mis curriculums</a></li>
            <li><a class="panel-link" href="#my-data">Mis datos</a></li>
            <li><a class="panel-link" href="#profiles">Crea un nuevo perfil</a></li>
        </ul>
    </div>
</div>
<div class="box-principal">
    <div class="container">
        <div id="home" class="panel-section">
            <div class="row">
                <div class="col-lg-3"><!--COLUMNA VACÍA--></div>
                <div class="col-lg-6">
                    <a class="boton-menu panel-link bg-btn-1" href="#my-data">Mis datos</a>
                    <a class="boton-menu panel-link bg-btn-2" href="#profiles">Crea un nuevo perfil</a>
                    <a class="boton-menu panel-link bg-btn-3" href="#curriculum">Mis curriculums</a>
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
                    <a href="Educations" class="boton-menu bg-btn-3">Formación y educación</a>
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

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-1">
                                <select  name="orden" class="form-control">
                                    <option value="No">No</option>
                                    <option selected value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>DATOS PERSONALES</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2">
                                <select  name="orden" class="form-control">
                                    <option value="No">No</option>
                                    <option selected value="der">Derecha</option>
                                    <option value="izq">Izquierda</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>FOTOGRAFÍA</label>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-1">
                                <select  name="orden" class="form-control">
                                    <option value="No">No</option>
                                    <option value="1">1</option>
                                    <option selected value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>EXPERIENCIA PROFESSIONAL</label>
                            </div>
                            <div class="col-md-8">
                            <%@include file="templates/tag-input.jsp"%>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">    
                        <div class="row">
                            <div class="col-md-1">
                                <select  name="orden" class="form-control">
                                    <option value="No">No</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option selected value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>EDUCACIÓN</label>
                            </div>
                            <div class="col-md-8">
                            <%@include file="templates/tag-input.jsp"%>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-1">
                                <select  name="orden" class="form-control">
                                    <option value="No">No</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option selected value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>LENGUAS</label>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-1">
                                <select  name="orden" class="form-control">
                                    <option value="No">No</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option selected value="5">5</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label>OTROS</label>
                            </div>
                            <div class="col-md-8">
                            <%@include file="templates/tag-input.jsp"%>
                            </div>
                        </div>
                    </div>
                        
                    <div class="col-lg-3"><button>Siguiente</button></div>
                </div>
            </form>
        </div>
    </div>
</div>



<%@include file="layout/lower.jsp"%>
