<%
    ViewUtils.setStylesheets(request, "estilos-formularios");
    ViewUtils.setScripts(request, "form-slides", "formulario-etiquetas");
%>

<%@include file="layout/upper.jsp" %>

<!--Es innecesario añadir una fila con una columna aquí...-->
<a href="#new-item" class="btn btn-info new-item-btn">Añade una nueva experiencia laboral</a>

<form class="form-hidden form-box" id="new-item" action="Experience" method="POST">
    <h2 class="text-center">Nueva experiencia</h2>
    <div class="row">
        <div class="col-lg-12 espaciador">
            <label>Nombre de la empresa</label>
            <input class="form-control" name="nombreEmpresa" type="text" placeholder="Nombre de la empresa..." required>
        </div>
    </div>

    <div class="row">   
        <div class="col-lg-6 espaciador">
            <div class="row">
                <div class="col-lg-12">
                    <label>País</label>
                    <select class="form-control" name="idioma">
                        <option value="" disabled selected>(seleccionar)</option>
                        <option value="espanol">Español</option>
                        <option value="ingles">Inglés</option>
                        <option value="frances">Francés</option>
                        <option value="aleman">Alemán</option>
                        <option value="itaiano">Italiano</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-lg-6 espaciador">
            <div class="row">
                <div class="col-lg-12">
                    <label>Ciudad</label>
                    <input class="form-control" name="ciudadEmpresa" type="text" placeholder="Ciudad...">
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 espaciador">
            <label>Sector</label>
            <select class="form-control" name="idioma">
                <option value="" disabled selected>(seleccionar)</option>
                <option value="ingenieria">Ingenieria</option>
                <option value="sanidad">Sanidad</option>
            </select>
        </div>
    </div>

    <div class="row">   
        <div class="col-lg-6 espaciador">
            <div class="row">
                <div class="col-lg-12">
                    <label>Fecha inicio</label>
                    <input name="fechainicio" type="date" placeholder="Fecha inicio..." class="form-control">
                </div>
            </div>
        </div>
        <div class="col-lg-6 espaciador">
            <div class="row">
                <div class="col-lg-12">
                    <label>Fecha final</label>
                    <input name="fechafinal" type="date" placeholder="Fecha final..." class="form-control">
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 espaciador">
            <label>Puesto</label>
            <input name="puesto" type="text" placeholder="Puesto..." class="form-control">
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 espaciador">
            <label>Descripción</label>
            <textarea name="descripcion" style="width: 100%; height: 80px" placeholder="Breve descripción..." class="form-control"></textarea>
        </div>
    </div>

    <div class="row espaciador">
        <div class="col-lg-3 ">
            <label>Tags</label>
        </div>
        <div class="form-field"><!--Inicio-->
                <div id="tag-listExp" >
                </div>
            </div>
            <div class="form-field">
                <input list="datalistExp" id="current-tagExp">
                <datalist id="datalistExp">
                    <option>hosteleria</option>
                    <option>programacion</option>
                    <option>base-de-datos</option>
                    <option>bar</option>
                </datalist>
                <input id="tagsExp" type="hidden" name="tags"/>
                <button id="add-tag-btnExp">AddTag</button>
            </div><!--fin/-->
    </div>
    <input type="hidden" name="_action" value="insert">
    <div class="row text-center espaciador">
        <div class="col-lg-12">
            <button type="submit">GUARDAR</button>
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
