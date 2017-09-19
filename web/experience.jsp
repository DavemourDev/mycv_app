<%@page import="helpers.FormatUtils"%>
<%@page import="model.Experience"%>
<%@page import="helpers.DatabaseUtils"%>
<%@page import="model.Country"%>
<%@page import="model.Sector"%>

<%
    ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formularios");
    ViewUtils.setScripts(request, "form-slides", "formulario-etiquetas");
    
    //Inicializar variables 
    
    List<Sector> sectors = RequestUtils.getSectors(request);
    List<Country> countries = RequestUtils.getCountries(request);
    List<String> tagsDatalist = new ArrayList<String>();//RequestUtils.getExpTags(request);
    List<Experience> experienceList = Experience.findBy("user_id", String.valueOf(RequestUtils.getSessionUserId(request)));
    int user_country_id = RequestUtils.getSessionUser(request).getPersonal().getLocation().getCountry().getId();
    
    List<String> tags = new ArrayList<String>();
    String tagInputNS ="New-exp";
    
    int i = 0;
    int n = 0;
%>

<%@include file="layout/upper.jsp" %>

<h1 class="page-header titulo text-center">Experiencia profesional</h1>

<a href="#new-item" class="btn btn-info new-item-btn btn-block">Añade una nueva experiencia laboral</a>

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
                    <%for(Sector s : sectors){%>
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
                <label>Descripción</label>
                <textarea name="description" class="form-control" rows="3" placeholder="Breve descripción..." class="form-control"></textarea>
            </div>
        </div>
    </div>
        
    <%@include file="templates/tag-input.jsp" %>
                 
    <input type="hidden" name="_action" value="insert">
    <div class="row text-center espaciador">
        <div class="col-lg-12">
            <input class="btn btn-success btn-block" type="submit" value="Guardar"/>
        </div>
    </div>
</form>

<!--Fin de formulario nuevo-->

<%if(experienceList.isEmpty()){%>
    <h2>No tienes experiencias guardadas</h2>
<%}else{%>
    <h2 class="text-center">Experiencias introducidas</h2>
    <div class="container">
        <%for(Experience exp : experienceList){
            int exp_id = exp.getId();
            String startdate = exp.getStartdate();
            String enddate = exp.getEnddate();
            
            tags = exp.getTags();
            tagInputNS = "Edit-item-" + exp.getId();
            i = 0;
            n = tags.size();
        %>
        <!--Importa la plantilla de item por cada iteración y la rellena con los datos actuales-->
        <%@include file="templates/experience_item.jsp"%>
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