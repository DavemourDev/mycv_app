<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>
<%@page import="helpers.ViewUtils"%>
<%@page import="config.Config"%>
<%
    ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formularios");
    ViewUtils.setScripts(request, "panel-de-control");
    
    List<String> tagsDatalist = new ArrayList<String>();
    List<String> tags = new ArrayList<String>();
    String tagInputNS ="New-exp";
    
    int i = 0;
    int n = tags.size();
%>
<%@include file="layout/upper.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header titulo text-center">Panel de control</h1>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <ul class="nav nav-tabs nav-tabs-hidden" id="control-panel">
                <!--<li class="active"><a href="#home">Principal</a></li>-->
                <li><a class="panel-link" href="#my-data">Mis datos</a></li>
                <li><a class="panel-link" href="#profiles">Crea un nuevo perfil</a></li>
                <li><a class="panel-link" href="#curriculum">Mis currículums</a></li>
            </ul>
        </div>
    </div>
</div>




<div class="box-principal">
    
    <div class="container">
        <div id="home" class="panel-section">
            <div class="row">
                <div class="col-lg-3"><!--COLUMNA VACÍA--></div>
                <div class="col-lg-6">

                    <a class="boton-menu panel-link bg-btn-1 mostratext" href="#my-data " >Mis Datos</a>
                    <div id="text" class="ocult">
                        ¡Introduce toda tu información!
                    </div>

                    <a class="boton-menu panel-link bg-btn-2 mostratext" href="#profiles" >Crea un nuevo perfil</a>
                    <div id="text" class="ocult">
                        ¡Ordena y filtra tu información!
                    </div>

                    <a class="boton-menu panel-link bg-btn-3 mostratext" href="#curriculum">Mis currículums</a>
                    <div id="text" class="ocult">
                        ¡Accede a tus currículums!
                    </div>
                </div>
                <div class="col-lg-3"><!--COLUMNA vacia--></div>
            </div>
        </div>
        
    </div>
    
    <div class="container">
            
        <div id="curriculum" class="panel-section">

            <div class="row">
                <div class="col-lg-1"><!--COLUMNA VACÍA--></div>
                <div class="col-lg-2">
                    <div class="row">
                        <div class="col-lg-12 cvthumb"><img width=100% src="/mycv_app/assets/img/cv_ej.jpg"/></div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_EDITAR.png"/></a></div>
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_DESCARGAR.png"/></a></div>
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_ELIMINAR.png"/></a></div>
                    </div>
                </div>
                <div class="col-lg-1"><!--COLUMNA VACÍA--></div>
                <div class="col-lg-2">
                    <div class="row">
                        <div class="col-lg-12 cvthumb"><img width=100% src="/mycv_app/assets/img/cv_ej.jpg"/></div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_EDITAR.png"/></a></div>
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_DESCARGAR.png"/></a></div>
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_ELIMINAR.png"/></a></div>
                    </div>
                </div>
                <div class="col-lg-1"><!--COLUMNA VACÍA--></div>
                <div class="col-lg-2">
                    <div class="row">
                        <div class="col-lg-12 cvthumb"><img width=100% src="/mycv_app/assets/img/cv_ej.jpg"/></div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_EDITAR.png"/></a></div>
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_DESCARGAR.png"/></a></div>
                        <div class="col-lg-4 boton-icon-cv"><a href="#"><img width=100% src="/mycv_app/assets/img/icon_ELIMINAR.png"/></a></div>
                    </div>
                </div>
                <div class="col-lg-2"><!--COLUMNA VACÍA--></div>
            </div>
            
        </div>
            
    </div>
    <div class="container">
            
        <div id="my-data" class="panel-section">
            <div class="col-lg-3"><!--Columna vacía--></div>
            <div class="col-lg-6">
                <h2 class="titulo-seccion">DATOS DE USUARIO</h2>
                <div class="well well-lg">
                    <a href="PersonalData" class="boton-menu bg-btn-3">Datos personales</a>
                    <a href="Experiences" class="boton-menu bg-btn-3">Experiencia profesional</a>
                    <a href="Educations" class="boton-menu bg-btn-3">Formación y educación</a>
                    <a href="Languages" class="boton-menu bg-btn-3">Idiomas</a>
                    <a href="OtherInfo" class="boton-menu bg-btn-3">Otros datos de interés</a>
                </div>
            </div>
            <div class="col-lg-3"><!--Columna vacía--></div>
        </div>
        <div id="profiles" class="panel-section">
            <form action="Profiles" method="POST">
                
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
                                <label>EXPERIENCIA PROFESIONAL</label>
                            </div>
                            <div class="col-md-7">
                            <%@include file="templates/tag-input.jsp"%>
                            </div>
                            <div class="col-md-1"><!--Columna vacia--></div>
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
                            <div class="col-md-7">
                            <%@include file="templates/tag-input.jsp"%>
                            </div>
                            <div class="col-md-1"><!--Columna vacia--></div>
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
                            <div class="col-md-7">
                            <%@include file="templates/tag-input.jsp"%>
                            </div>
                            <div class="col-md-1"><!--Columna vacia temporal--></div>
                        </div>
                    </div>
                        
                    <div class="col-lg-3"><button>Siguiente</button></div>
                
            </form>
        </div>
    </div>
</div>



<%@include file="layout/lower.jsp"%>
