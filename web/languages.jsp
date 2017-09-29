<%@page import="model.LanguageSkill"%>
<%@page import="model.LanguageLevel"%>
<%@page import="model.Language"%>
<%
    ViewUtils.setStylesheets(request, "estilos-panel-principal", "estilos-formularios");
    ViewUtils.setScripts(request, "form-slides", "formulario-etiquetas");

    User user = RequestUtils.getSessionUser(request);
    
    //Inicializar variables 
    List<Language> languages = RequestUtils.getLanguages(request);
    List<LanguageLevel> languageLevelsPartial = RequestUtils.getLanguageLevelsPartial(request);
    //List<LanguageLevel> languageLevelsGlobal = RequestUtils.getLanguageLevelsGlobal(request);
    
    List<LanguageSkill> languageSkills = user.getLanguageSkills();
    
    int user_id = user.getId();
%>

<%@include file="layout/upper.jsp" %>

<h1 class="page-header titulo text-center">Idiomas</h1>
<a href="#new-item" class="btn btn-info new-item-btn btn-block">Añade un nuevo idioma</a>

<form class="form-hidden form-box" id="new-item" action="languages" method="POST">
    <div class="form-group">
        <div class="row">
            <div class="col-lg-8">
                <label>Idioma</label>
                <select name="language" class="form-control">
                    <option value="" disabled selected>(seleccionar)</option>
                    <!--Obtener lista. No se permiten idiomas que ese usuario haya introducido, con lo cual éstos no aparecen. Deberá hacerse un filtro-->
                    <%for(Language l : languages){%>
                        <option value="<%=l.getId()%>"><%=l.getName()%></option>
                    <%}%>
                </select>
            </div>
            <div class="col-lg-4">
                <label>Nivel global</label>
                <select name="level" class="form-control">
                    <%for(LanguageLevel ll : languageLevelsPartial){%>
                        <option value="<%=ll.getId()%>"><%=ll.getName()%></option>
                    <%}%>
                </select>
            </div>
        </div>
    </div>
    
    <div class="form-group">
        <div class="row">
            <div class="col-lg-4">
                <label>Hablado</label>
                <select name="speech" class="form-control">
                    <%for(LanguageLevel ll : languageLevelsPartial){%>
                        <option value="<%=ll.getId()%>"><%=ll.getName()%></option>
                    <%}%>
                </select>
            </div>
            <div class="col-lg-4">
                <label>Escrito</label>
                <select name="writing" class="form-control">
                    <%for(LanguageLevel ll : languageLevelsPartial){%>
                        <option value="<%=ll.getId()%>"><%=ll.getName()%></option>
                    <%}%>
                </select>
            </div>
            <div class="col-lg-4">
                <label>Leído</label>
                <select name="comprehension" class="form-control">
                    <%for(LanguageLevel ll : languageLevelsPartial){%>
                        <option value="<%=ll.getId()%>"><%=ll.getName()%></option>
                    <%}%>
                </select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label>Descripción</label>
        <textarea name="description" class="form-control" rows="3" placeholder="Breve descripción..." class="form-control"></textarea>
    </div>

    <input type="hidden" name="user_id" value="<%=user_id%>">
    <input type="hidden" name="_action" value="insert">

    <div class="row text-center">
        <div class="col-lg-12">
            <button type="submit">GUARDAR</button>
        </div>
    </div>

</form>

<%if(languageSkills.isEmpty()){%>
    <h2>No tienes información relativa a idiomas</h2>
<%}else{%>
    <h2 class="text-center">Idiomas introducidos</h2>
    <div class="container">
        <%for(LanguageSkill ls : languageSkills){
            int ls_id = ls.getId();
            //Esto se puede hacer mejor
            LanguageLevel speech = LanguageLevel.findBy("id", String.valueOf(ls.getSpeech())).get(0);
            LanguageLevel writing = LanguageLevel.findBy("id", String.valueOf(ls.getWriting())).get(0);
            LanguageLevel comprehension = LanguageLevel.findBy("id", String.valueOf(ls.getComprehension())).get(0);
            LanguageLevel level = LanguageLevel.findById(ls.getLevel());
            String description = ls.getDescription();
        %>
        <!--Importa la plantilla de item por cada iteración y la rellena con los datos actuales-->
        <%@include file="templates/language_item.jsp"%>
            <!--fin-->
        <%}%>
    </div>
<%}%>




<%@include file="layout/lower.jsp" %>
<script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
</script>