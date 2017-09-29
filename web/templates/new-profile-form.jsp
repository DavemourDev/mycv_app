<%@page import="model.Tag"%>
<%@page import="java.util.List"%>

<%
    List<Tag> experienceTags = user.getExperienceTags();
    List<Tag> educationTags = user.getEducationTags();
    List<Tag> otherinfoTags = user.getOtherInfoTags();
%>

<form action="Profiles" method="POST">
    <h3 class="text-center subtitulo">Ordena y filtra tus datos</h3>
    <div class="form-group">
        <h4>Información del perfil</h4>
        <div class="row">
            <div class="col-md-4">
                <label>Marca personal</label>
                <input type="text" name="personal-mark" class="form-control" title="La marca personal es un identificador para tu perfil. " required/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <h4>Datos personales</h4>
        <div class="row">
            <div class="col-md-1">
                <label>Orden</label>
                <select name="personal-order" class="form-control" title="Selecciona el orden en el que quieres que aparezca esta sección en tu perfil. Si dos secciones tienen el mismo orden, prevalece el orden en el que aparecen aquí.">
                    <option value="0">No aparece</option>
                    <option selected value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <div class="col-md-6"></div>
            <div class="col-md-4">
                <label>Posición de la fotografía</label>
                <select name="picture-display" class="form-control">
                    <option value="0">No aparece</option>
                    <option selected value="1">Derecha</option>
                    <option value="2">Izquierda</option>
                </select>
            </div>

        </div>
    </div>

    <div class="form-group">
        <h4>Experiencia profesional</h4>
        <div class="row">
            <div class="col-md-1">
                <label>Orden</label>
                <select name="experience-order" class="form-control" title="Selecciona el orden en el que quieres que aparezca esta sección en tu perfil. Si dos secciones tienen el mismo orden, prevalece el orden en el que aparecen aquí.">
                    <option value="0">No aparece</option>
                    <option value="1">1</option>
                    <option selected value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <div class="col-md-6"></div>
            <div class="col-md-4">
                <label>Etiquetas Experiencia</label>
                <select class="form-control" multiple name="experience-tags">
                    <%for (Tag t : experienceTags)
                                    {%>
                    <option><%=t.getTagtext()%></option>
                    <%}%>
                </select> 
            </div>
        </div>
    </div>

    <div class="form-group">
        <h4>Educación y formación</h4>    
        <div class="row">
            <div class="col-md-1">
                <label>Orden</label>
                <select  name="education-order" class="form-control" title="Selecciona el orden en el que quieres que aparezca esta sección en tu perfil. Si dos secciones tienen el mismo orden, prevalece el orden en el que aparecen aquí.">
                    <option value="0">No aparece</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option selected value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <div class="col-md-6"></div>
            <div class="col-md-4">
                <label>Etiquetas educación/formación</label>
                <select class="form-control" multiple name="education-tags">
                    <%for (Tag t : educationTags)
                                    {%>
                    <option><%=t.getTagtext()%></option>
                    <%}%>
                </select> 
            </div>
        </div>
    </div>

    <div class="form-group">
        <h4>Lenguas</h4>
        <div class="row">
            <div class="col-md-1">
                <label>Orden</label>
                <select  name="language-order" class="form-control"  title="Selecciona el orden en el que quieres que aparezca esta sección en tu perfil. Si dos secciones tienen el mismo orden, prevalece el orden en el que aparecen aquí.">
                    <option value="0">No aparece</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option selected value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
        </div>
    </div>

    <div class="form-group">
        <h4>Otra información</h4>
        <div class="row">
            <div class="col-md-1">
                <label>Orden</label>
                <select  name="otherinfo-order" class="form-control"  title="Selecciona el orden en el que quieres que aparezca esta sección en tu perfil. Si dos secciones tienen el mismo orden, prevalece el orden en el que aparecen aquí.">
                    <option value="0">No aparece</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option selected value="5">5</option>
                </select>
            </div>
            <div class="col-md-6"></div>
            <div class="col-md-4">
                <label>Etiquetas otros</label>
                <select class="form-control" multiple name="otherinfo-tags">
                    <%for (Tag t : otherinfoTags)
                                    {%>
                    <option><%=t.getTagtext()%></option>
                    <%}%>
                </select> 
            </div>
        </div>
    </div>
    <input type="hidden" name="_action" value="_insert"/>
    <div class="col-lg-3"><button class="btn btn-success">Siguiente</button></div>

</form>