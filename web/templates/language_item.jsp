
<article class="cv-section-item">
    <div class="campoyaintroducido row">
        <div class="col-lg-9">    
            <p class="lead"><span class="text-primary"><%=ls.getLanguage().getName()%></span> con nivel <span class="text-muted"><%=level.getName()%></span></p>
            <dl class="dl-horizontal">
                <dt>Escrito</dt>
                <dd class="text-muted"><%=writing.getName()%></dd>
                <dt>Hablado</dt>
                <dd class="text-muted"><%=speech.getName()%></dd>
                <dt>Comprendido</dt>
                <dd class="text-muted"><%=comprehension.getName()%></dd>
            </dl>
            <p><%=description%></p>
        </div>
        <div class="col-lg-3">
            <div class="botonesedel">
                <a class="boton-menu bg-btn-1 btn-edit-item" href="#edit-item-<%=ls_id%>">EDITA</a>
                <a class="boton-menu bg-btn-1" href="Languages?_action=delete&id=<%=ls_id%>">ELIMINA</a>
            </div>
        </div>
    </div>


    <form class="form-hidden form-box" action="Languages" id="edit-item-<%=ls_id%>" method="POST">
        <h2>Editar Idioma</h2>
        <div class="form-group">
        <div class="row">
            <div class="col-lg-8">
                <label>Idioma</label>
                <select name="language" class="form-control" readonly="readonly">
                    <option value="" selected>(seleccionar)</option>
                    <!--Obtener lista. No se permiten idiomas que ese usuario haya introducido, con lo cual éstos no aparecen. Deberá hacerse un filtro-->
                    <%for(Language l : languages){%>
                        <option value="<%=l.getId()%>" <%=l.getId() == ls.getLevel()? "selected":""%>><%=l.getName()%></option>
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
                        
                        <option value="<%=ll.getId()%>" <%=ll.getId() == ls.getSpeech()? "selected":""%>><%=ll.getName()%></option>
                    <%}%>
                </select>
            </div>
            <div class="col-lg-4">
                <label>Escrito</label>
                <select name="writing" class="form-control">
                    <%for(LanguageLevel ll : languageLevelsPartial){%>
                        <option value="<%=ll.getId()%>"  <%=ll.getId() == ls.getWriting()? "selected":""%> ><%=ll.getName()%></option>
                    <%}%>
                </select>
            </div>
            <div class="col-lg-4">
                <label>Leído</label>
                <select name="comprehension" class="form-control">
                    <%for(LanguageLevel ll : languageLevelsPartial){%>
                        <option value="<%=ll.getId()%>"  <%=ll.getId() == ls.getComprehension()? "selected":""%>><%=ll.getName()%></option>
                    <%}%>
                </select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label>Descripción</label>
        <textarea name="description" class="form-control" rows="3" placeholder="Breve descripción..." class="form-control"> <%=description%></textarea>
    </div>

                
    <input type="hidden" name="_action" value="edit">

        <input type="hidden" name="id" value="<%=ls_id%>">
        <input type="hidden" name="user_id" value="<%=user_id%>">
    <div class="row text-center">
        <div class="col-lg-12">
            <button type="submit">GUARDAR</button>
        </div>
    </div>

    </form>

</article>