
<article class="cv-section-item">
    <div class="campoyaintroducido">
        <div class="row">
            <div class="col-lg-9">    
                <p class="lead"><span class="text-primary"><%=other.getTitle()%></span></span></p>
                <p><%=other.getDescription()%></p>
            </div>
            <div class="col-lg-3">
                <div class="botonesedel">
                    <a class="boton-menu bg-btn-1 btn-edit-item" href="#edit-item-<%=other_id%>">EDITA</a>
                    <a class="boton-menu bg-btn-1" href="otherinfo?_action=delete&id=<%=other_id%>">ELIMINA</a>
                </div>
            </div>
        </div>
        <dl class="dl-horizontal">
            <dt>Tags: </dt>
            <%for(Tag t : tags){%>
                <dd><%=t%></dd>
            <%}%>
        </dl>
    </div>


    <form class="form-hidden form-box" action="otherinfo" id="edit-item-<%=other_id%>" method="POST">
        <h2>Editar otra información</h2>
        <div class="form-group">
            <div class="row">
                <div class="col-lg-4 form-field">
                    <label>Nombre del ítem</label>
                    <input class="form-control" name="title" type="text" placeholder="Nombre del ítem" value="<%=other.getTitle()%>" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label>Descripción</label>
            <textarea name="description" class="form-control" rows="3" placeholder="Breve descripción..." class="form-control"><%=other.getDescription()%></textarea>
        </div>

        <%@include file="tag-input.jsp"%>

        <input type="hidden" name="id" value="<%=other_id%>">
        <input type="hidden" name="_action" value="edit">
        <div class="row text-center espaciador">
            <div class="col-lg-12">
                <input class="btn btn-success btn-block" type="submit" value="Guardar"/>
            </div>
        </div>
    </form>

</article>