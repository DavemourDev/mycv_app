<%@page import="helpers.RequestUtils"%>
<%@page import="model.User"%>
<%@page import="model.Personal"%>
<%
    
    Personal personal = Personal.findBy("user_id", String.valueOf(RequestUtils.getSessionUser(request).getId())).get(0);
            
    ViewUtils.setStylesheets(request, "estilos-formularios", "personal-edit-form");
    ViewUtils.setScripts(request, "form-confirm-cancel");

%>
<%@include file="layout/upper.jsp"%>
        
        <!--Este es el bueno-->
          <form action="Personal" method="POST">
            
            <div class="container form-box">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="titulo">Datos Personales</h1>
                    </div>
                </div><hr><br>
                
                <div class="row espaciador">
                    <div class="col-lg-6">
                        <label>Nombre</label>
                        <input name="name" type="text" placeholder="Tu nombre..." class="form-control" value="<%=personal.getName()%>">
                    </div>
                    <div class="col-lg-6">
                        <label>Apellido</label>
                        <input name="lastname" type="text" placeholder="Tu apellido..." class="form-control" value="<%=personal.getLastname()%>">
                    </div>
                </div>
                
                <div class="row espaciador">
                    <div class="col-lg-6">
                        <label>Fecha de nacimiento</label>
                        <input name="birthdate" type="date" placeholder="Tu fecha de nacimiento..." class="form-control" value="<%=personal.getBirthdate()%>">
                    </div>
                    <div class="col-lg-6">
                        <label>Fotografía (opcional)</label>
                        <input name="picture" type="file" placeholder="Tu fotografia..." class="form-control">
                    </div>
                </div>
                
                <div class="row espaciador">
                    <div class="col-lg-6">
                        <label>País</label>
                        <select name="country" class="form-control">
                            <option value="" disabled selected>(seleccionar)</option>
                            <option value="1">España</option>
                            <option value="2">Francia</option>
                        </select>
                    </div>
                    <div class="col-lg-6">
                        <label>Ciudad</label>
                        <input name="city" type="text" placeholder="Tu pais..." class="form-control">
                    </div>
                </div>
                
                <div class="row espaciador">
                   <div class="col-lg-6">
                        <label>Teléfono móvil</label>
                        <input name="telephone1" type="text" placeholder="Tu teléfono móvil..." class="form-control" value="<%=personal.getTelephone1()%>">
                    </div>
                    <div class="col-lg-6">
                        <label>Teléfono 2 (Opcional)</label>
                        <input name="telephone2" type="text" placeholder="Tu segundo teléfono..." class="form-control"  value="<%=personal.getTelephone2()%>">
                    </div>
                </div>
        <!--        
                <div class="row espaciador">
                    <div class="col-lg-12">
                        <label>E-mail</label>
                        <input name="email" type="email" placeholder="Tu e-mail..." class="form-control">
                    </div>
                </div>
            -->    
            
            
                <input type="hidden" name="u-token" value="<%=user.hashCode()%>"/>
                <input type="hidden" name="_action" value="update"/>
                <div class="row text-center">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-3">
                        <button type="submit">GUARDAR</button>
                    </div>
                    <div class="col-lg-3">
                        <button type="button" id="buttoncancel"><a href="#" class="cancel">CANCELAR</a></button>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
            </div>
        </form>
<%@include file="layout/lower.jsp"%>

    
