<%@page import="model.Tag"%>
<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>
<%@page import="helpers.ViewUtils"%>
<%@page import="config.Config"%>
<%
    ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formularios");
    ViewUtils.setScripts(request, "panel-de-control", "formulario-etiquetas");

    User user = RequestUtils.getSessionUser(request);
    
    int user_id = user.getId();
    
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
                <li><a class="panel-link" href="#my-data" title="Aquí puedes insertar y modificar la información de tu currículum. Puedes tenerla toda guardada aquí, de hecho, es la idea.">Mis datos</a></li>
                <li><a class="panel-link" href="#profiles" title="Aquí puedes crear un nuevo perfil. Los perfiles no son más que configuraciones en las que personalizas la información que aparece y cómo lo hace, así como el aspecto de tu currículum. Al crear un perfil, también tendrás disponible un currículum.">Crea un nuevo perfil</a></li>
                <li><a class="panel-link" href="#curriculum" title="Aquí puedes ver y editar los perfiles creados, así como ver el resultado final de todo ello.">Mis currículums</a></li>
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
            <h2 class="titulo-seccion">MIS CURRICULUMS</h2>
            <div class="row">
                <div class="col-lg-1"><!--COLUMNA VACÍA--></div>
                <div class="col-lg-2">
                    <div class="row">
                        <div class="col-lg-12 cvthumb"><a href="Profiles?_action=view"><img width=100% src="/mycv_app/assets/img/cv_ej.jpg"/></a></div>
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
                <h2 class="titulo-seccion">MIS DATOS</h2>
                <div class="well well-lg">
                    <a href="personal" class="boton-menu bg-btn-3">Datos personales</a>
                    <a href="experience" class="boton-menu bg-btn-3">Experiencia profesional</a>
                    <a href="education" class="boton-menu bg-btn-3">Formación y educación</a>
                    <a href="languages" class="boton-menu bg-btn-3">Idiomas</a>
                    <a href="otherinfo" class="boton-menu bg-btn-3">Otros datos de interés</a>
                </div>
            </div>
            <div class="col-lg-3"><!--Columna vacía--></div>
        </div>
        <div id="profiles" class="panel-section">
            <h2 class="titulo-seccion text-center">CREA UN NUEVO PERFIL</h2>
            <%@include file="templates/new-profile-form.jsp"%>
        </div>
    </div>
</div>



<%@include file="layout/lower.jsp"%>
