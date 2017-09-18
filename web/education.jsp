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
    
    List<Sector> sectors = RequestUtils.getSectors(request);
    List<EducationLevel> educationLevels = RequestUtils.getEducationLevels(request);
    List<Country> countries = RequestUtils.getCountries(request);
    List<String> eduTags = RequestUtils.getEduTags(request);
    List<Education> educationList = Education.findBy("user_id", String.valueOf(RequestUtils.getSessionUserId(request)));
    int user_country_id = RequestUtils.getSessionUser(request).getPersonal().getLocation().getCountry().getId();
%>

<%@include file="layout/upper.jsp" %>

<h1 class="page-header titulo text-center">Formaci�n y educaci�n</h1>

<a href="#new-item" class="btn btn-info new-item-btn">A�ade una nueva formaci�n o educaci�n</a>

<form class="form-hidden form-box" id="new-item" action="Educations" method="POST">
    <h2 class="text-center">Nueva educaci�n</h2>
    <div class="form-group">
        <div class="row">
            <div class="col-lg-4 form-field">
                <label>Nombre del centro</label>
                <input class="form-control" name="center" type="text" placeholder="Nombre del centro de estudios..." required>
            </div>

            <div class="col-lg-4 form-field">
                <label>T�tulo o nombre de la acci�n educativa</label>
                <input name="titlename" type="text" placeholder="Titulaci�n/Nombre acci�n educativa" class="form-control">
            </div>
            
            <div class="col-lg-4">
                <label>Sector</label>
                <select class="form-control" name="sector">
                    <option value="" disabled selected>(seleccionar)</option>
                    <%for(Sector s : sectors){%>
                        <option value="<%=s.getId()%>"><%=s.getName()%></option>
                    <%}%>
                    
                </select>
            </div>
            
            <div class="col-lg-4">
                <label>Nivel acad�mico</label>
                <select class="form-control" name="level">
                    <option value="" disabled selected>(seleccionar)</option>
                    <%for(EducationLevel el : educationLevels){%>
                        <option value="<%=el.getId()%>"><%=el.getName()%></option>
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
                        <label>Pa�s</label>
                        <select class="form-control" name="country" required>
                            <option value="" disabled>(seleccionar)</option>
                            <%for(Country c : countries){%>
                                <option value="<%=c.getId()%>"<%=c.getId() == user_country_id?" selected='selected'":""%>><%=c.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="form-field">
                    <label>Ciudad</label>
                    <input class="form-control" name="city" type="text" placeholder="Ciudad...">
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
                <label>Descripci�n</label>
                <textarea name="description" class="form-control" rows="3" placeholder="Breve descripci�n..." class="form-control"></textarea>
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
                    <input list="datalistEdu" id="current-tagExp" data-toggle="tooltip" title="Una tag debe empezar con una letra y puede contener letras, n�meros, guiones y guiones bajos.">
                    <datalist id="datalistEdu">
                        <%
                            for(String tag: eduTags){
                                //Consulta vista de tags para obtener las opciones
                                //Tag.
                            }
                        %>
                    </datalist>
                    <input id="tagsEdu" type="hidden" name="tags"/>
                    <button id="add-tag-btnEdu" type="button">AddTag</button>
                </div>
            </div>
            <div class="col-lg-8">
                <div id="tag-listEdu" class="well"></div>
            </div>
            <script>
                //Copiar de la de experiencias
            </script>
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

<%if(educationList.isEmpty()){%>
    <h2>No tienes educaciones o formaciones guardadas</h2>
<%}else{%>
    <h2 class="text-center">Educaciones y formaciones introducidas</h2>
    <div class="container">
        <%for(Education edu : educationList){
            int edu_id = edu.getId();
            String startdate = edu.getStartdate();
            String enddate = edu.getEnddate();
        %>
        <!--Importa la plantilla de item por cada iteraci�n y la rellena con los datos actuales-->
        <%@include file="templates/education_item.jsp"%>
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