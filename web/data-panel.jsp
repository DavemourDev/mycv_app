
<%@page import="helpers.ViewUtils"%>

<%ViewUtils.setStylesheets(request, "estilos-panel-de-datos");%>

<%@include file="layout/upper.jsp"%>
    <div class="container">
        <div class="box-principal2">

            <div class="container">
                <div class="row caixes">
                    <div class="col-lg-12">
                        <ul class="box">
                            <li><a class="curriculums" href="#home">Ver mis curriculums</a></li>
                            <li class="datos"><a href="">Editar mis datos</a></li>
                            <li><a href="plantilla">Modificar plantilla</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="box-principal">


            <div class="container">
                <div class="row caixes">
                    <div class="col-lg-12">
                        <h1 class="titulo"> QUE DECEAS HACER ? </h1>
                    </div>
                </div>

                <br>
                <br>
                <div class="row caixes">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <button class="boton-menu   ">DATOS PERSONALES</button><br>
                        <button class="boton-menu ">EXPERIENCIA PROFECIONAL</button><br>
                        <button class="boton-menu ">EDUCACIÓN</button><br>
                        <button class="boton-menu ">LENGUAS</button><br>
                        <button class="boton-menu ">AÑADE UN NUEVO APARTADO</button>
                    </div>

                    <div class="col-lg-3"></div>
                </div>
                <br>
            </div>

        </div>



        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>


<%@include file="layout/lower.jsp"%>