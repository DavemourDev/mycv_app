<%@page import="model.Tag"%>
<%@page import="model.OtherInfo"%>
<%@page import="helpers.DatabaseUtils"%>

<%
    ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formularios");
    ViewUtils.setScripts(request, "form-slides", "formulario-etiquetas");
    
    //Inicializar variables 
    
    User user = RequestUtils.getSessionUser(request);
    
    int user_id = user.getId();
    
    List<String> tagsDatalist = new ArrayList<String>();
    List<OtherInfo> otherList = user.getOtherInfo();
    
    List<Tag> tags = new ArrayList<Tag>();
    String tagInputNS ="New-other";
    
    int i = 0;
    int n = 0;
%>

<%@include file="layout/upper.jsp" %>

<h1 class="page-header titulo text-center"><%=Dictionary.vocab("otherinfo-section-title")%></h1>

<a href="#new-item" class="btn btn-info new-item-btn btn-block"><%=Dictionary.vocab("otherinfo-add-new-description")%></a>

<form class="form-hidden form-box" id="new-item" action="otherinfo" method="POST">
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
        <label><%=Dictionary.vocab("description-form-label")%></label>
        <textarea name="description" class="form-control" rows="3" placeholder="Breve descripción..." class="form-control"></textarea>
    </div>

    <%@include file="templates/tag-input.jsp"%>
                        
    <input type="hidden" name="user_id" value="<%=user_id%>">
    <input type="hidden" name="_action" value="insert">
    <div class="row text-center espaciador">
        <div class="col-lg-12">
            <input class="btn btn-success btn-block" type="submit" value="Guardar"/>
        </div>
    </div>
</form>

<%--Fin de formulario nuevo--%>

<%if(otherList.isEmpty()){%>
    <h2>No tienes ítems de otra información</h2>
<%}else{%>
    <h2 class="text-center">Otra información añadida</h2>
    <div class="container">
        <%for(OtherInfo other : otherList){
            int other_id = other.getId();
            tags = other.getTags();
            tagInputNS = "Edit-item-" + other.getId();
        %>
        <%--Importa la plantilla de item por cada iteración y la rellena con los datos actuales--%>
        <%@include file="templates/other_item.jsp"%>
            <%--fin--%>
        <%}%>
    </div>
<%}%>
<%--Fin del item--%>

<%@include file="layout/lower.jsp" %>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
});
</script>

