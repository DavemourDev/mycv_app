<%//No os preocupéis si abrís esto y salen cosas en rojo. Es normal. De hecho, no toquéis este archivo si no sabéis lo que estáis haciendo%>

<article class="cv-section-item">
    <div class="campoyaintroducido row">
        <div class="col-lg-9">
            <h3><%=educationLevel%></h3>
            <p class="lead"><span class="text-primary"><%=edu.getTitlename()%></span> en <span class="text-muted"><%=edu.getCenter()%>, <%=edu.getLocation().getCity()%></span></p>
            <p>Desde <time datetime="<%=startdate%>" class="text-info"><%=FormatUtils.formatDateMonthYear(startdate)%></time> hasta <time datetime="<%=enddate%>" class="text-info"><%=FormatUtils.formatDateMonthYear(enddate)%></time></p>
            <p><%=edu.getDescription()%> </p>
            
            <dl class="dl-horizontal">
                <dt>Tags: </dt>
                <%for(Tag t : tags){%>
                    <dd><%=t.getTagtext()%></dd>
                <%}%>
            </dl>
        </div>
        <div class="col-lg-3">
            <div class="botonesedel">
                <a class="boton-menu bg-btn-1 btn-edit-item" href="#edit-item-<%=edu_id%>">EDITA</a>
                <a class="boton-menu bg-btn-1" href="Educations?_action=delete&id=<%=edu_id%>">ELIMINA</a>
            </div>
        </div>
    </div>


    <form class="form-hidden form-box" action="Educations" id="edit-item-<%=edu_id%>" method="POST">
        <h2>Editar Educación/Formación</h2>
        <div class="form-group">
            <div class="row">
                <div class="col-lg-4 form-field">
                    <label>Nombre del centro</label>
                    <input class="form-control" name="center" type="text" placeholder="Nombre de la empresa..." value="<%=edu.getCenter()%>" required>
                </div>

                <div class="col-lg-4 form-field">
                    <label>Título o nombre de la acción educativa</label>
                    <input name="titlename" type="text" placeholder="Puesto..."  value="<%=edu.getTitlename()%>"class="form-control">
                </div>

                <div class="col-lg-4">
                    <label>Sector</label>
                    <select class="form-control" name="sector">
                        <option value="" disabled selected>(seleccionar)</option>
                        <%for (Sector s : sectors)
                        {%>
                        <option value="<%=s.getId()%>" <%=edu.getSector().getId() == s.getId() ? " selected='selected'" : ""%>><%=s.getName()%></option>
                        <%}%>
                    </select>
                </div>

                <div class="col-lg-4">
                    <label>Nivel</label>
                    <select class="form-control" name="level">
                        <option value="" disabled selected>(seleccionar)</option>
                        <%for (EducationLevel el : educationLevels)
                        {%>
                        <option value="<%=el.getId()%>" <%=edu.getLevel().getId() == el.getId() ? " selected='selected'" : ""%>><%=el.getName()%></option>
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
                                <%for (Country c : countries)
                                {%>
                                <option value="<%=c.getId()%>"<%=c.getId() == user_country_id ? " selected" : ""%>><%=c.getName()%></option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-field">
                        <label>Ciudad</label>
                        <input class="form-control" name="city" type="text" placeholder="Ciudad..." value="<%=edu.getLocation().getCity()%>"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">   
                <div class="col-lg-6">
                    <label>Fecha inicio</label>
                    <input name="startdate" pattern="\d{4}-\d{2}-\d{2}" type="date" placeholder="Fecha inicio..." class="form-control" value="<%=startdate%>">
                </div>
                <div class="col-lg-6">
                    <label>Fecha final</label>
                    <input name="enddate" type="date" pattern="\d{4}-\d{2}-\d{2}" placeholder="Fecha final..." class="form-control" value="<%=enddate%>">  
                </div>
            </div>
        </div>

        <div class="form-group">  
            <div class="row">
                <div class="col-lg-12">
                    <label>Descripción</label>
                    <textarea name="description" class="form-control" rows="3" placeholder="Breve descripción..." class="form-control"><%=edu.getDescription()%></textarea>
                </div>
            </div>
        </div>
        
        
        <%@include file="tag-input.jsp"%>
                
        <input type="hidden" name="_action" value="edit">
        <input type="hidden" name="id" value="<%=edu.getId()%>">
        <input type="hidden" name="user_id" value="<%=edu.getUser_id()%>">
        <div class="row text-center espaciador">
            <div class="col-lg-12">
                <input class="btn btn-success btn-block" type="submit" value="Guardar"/>
            </div>
        </div>
    </form>

</article>