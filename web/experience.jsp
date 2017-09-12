<%@page import="helpers.DatabaseUtils"%>
<%@page import="model.Country"%>
<%@page import="model.Sector"%>


<%
    ViewUtils.setStylesheets(request, "estilos-formularios");
    ViewUtils.setScripts(request, "form-slides", "formulario-etiquetas");
%>

<%@include file="layout/upper.jsp" %>


<h1 class="page-header titulo text-center">Experiencia profesional</h1>


<!--Es innecesario añadir una fila con una columna aquí...-->
<a href="#new-item" class="btn btn-info new-item-btn">Añade una nueva experiencia laboral</a>

<form class="form-hidden form-box" id="new-item" action="Experiences" method="POST">
    <h2 class="text-center">Nueva experiencia</h2>
    <div class="form-group">
        <div class="row">
            <div class="col-lg-4 form-field">
                <label>Nombre de la empresa</label>
                <input class="form-control" name="enterprise" type="text" placeholder="Nombre de la empresa..." required>
            </div>

            <div class="col-lg-4 form-field">
                <label>Puesto</label>
                <input name="job" type="text" placeholder="Puesto..." class="form-control">
            </div>
            <div class="col-lg-4">
                <label>Sector</label>
                <select class="form-control" name="sector">
                    <option value="" disabled selected>(seleccionar)</option>
                    <%for(Sector s : Sector.findAll()){%>
                        <option value="<%=s.getId()%>"><%=s.getName()%></option>
                    <%}%>
                </select>
            </div>

        </div>
    </div>
    <div class="form-group">
        <div class="row">   
            <div class="col-lg-6">
                <div class="row">
                    <div class="col-lg-12">
                        <label>País</label>
                        <select class="form-control" name="country" required>
                            <option value="" disabled>(seleccionar)</option>
                            <%for(Country c : Country.findAll()){%>
                                <option value="<%=c.getId()%>"<%=c.getId() == RequestUtils.getSessionUser(request).getPersonal().getLocation().getCountry().getId()?" selected":""%>><%=c.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="form-field">
                    <label>Ciudad</label>
                    <input class="form-control" name="ciudadEmpresa" type="text" placeholder="Ciudad...">
                 
                </div>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="row">   
            <div class="col-lg-6">
                <label>Fecha inicio</label>
                <input name="startdate" type="date" placeholder="Fecha inicio..." class="form-control">
            </div>
            <div class="col-lg-6">
                <label>Fecha final</label>
                <input name="enddate" type="date" placeholder="Fecha final..." class="form-control">  
            </div>
        </div>
    </div>
    
    <div class="form-group">  
        <div class="row">
            <div class="col-lg-12">
                <label>Descripción de la experiencia</label>
                <textarea name="description" style="width: 100%; height: 80px" placeholder="Breve descripción..." class="form-control"></textarea>
            </div>
        </div>
    </div>
        
    <div class="form-group">
        <div class="row">
            <div class="col-lg-1 ">
                <label>Tags</label>
            </div>
            <div class="col-lg-3">
                <div class="form-field"><!--Inicio-->
                    <input list="datalistExp" id="current-tagExp">
                    <datalist id="datalistExp">
                        <%
                            for(String tag: RequestUtils.getExpTags(request)){

                            }
                        %>
                    </datalist>
                    <input id="tagsExp" type="hidden" name="tags"/>
                    <button id="add-tag-btnExp" type="button">AddTag</button>
                </div>
            </div>
            <div class="col-lg-8">
                <div id="tag-listExp" class="well well"></div>
            </div>
        </div>
    </div>
    <input type="hidden" name="_action" value="insert">
    <div class="row text-center espaciador">
        <div class="col-lg-12">
            <input class="btn btn-success btn-block" type="submit" value="Guardar"/>
        </div>
    </div>
</form>

<!--Fin de formulario nuevo-->

<hr><br>
<h2 class="text-center">Experiencias introducidas</h2>
<div class="row"><!--Un item-->
    
    <div class="col-lg-10">
        <div class="campoyaintroducido">    
            <h3>Ayudante en <small>Moke Architekten</small></h3>
            <p>Febrero 2016 - Enero 2017</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
    </div>
    <div class="col-lg-2">
        <div class="row botonesedel">
            <div class="col-lg-12">
                <a class="btn btn-warning edit-item-btn" href="#edit-item-1">EDITA</a></button>
            </div>
            <div class="col-lg-12">
                <!--Este formulario solamente tiene un campo de enviar y un campo oculto que guarda la id... ideas raras mías-->
                <form action="Experience" method="POST">
                    <input type="hidden" name="_action" value="delete"/>
                    <input type="hidden" name="id" value="1"/>
                    <button class="btn btn-danger delete-item-btn" href="#delete-item-1">ELIMINA</button>
                </form>
            </div>
        </div>
    </div>
    
</div>
<div class="row">
    <form class="form-hidden" id="edit-item-1">
        <h3 class="text-center">Editar item 1</h3>

    </form>
</div>
<br><hr><br>
<!--Fin del item-->
<div class="row">
    <div class="col-lg-10">
        <div class="campoyaintroducido">    
            <h3>Ayudante en <small>Moke Architekten</small></h3>
            <p>Febrero 2016 - Enero 2017</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
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
<%@include file="layout/lower.jsp" %>
