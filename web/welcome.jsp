<%@page import="model.Country"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Country> countryList = RequestUtils.getCountries(request);
%>


<%@include file="layout/upper.jsp" %>

        <div class="container">
            <section>
                <div class="row">
                    <div class="col-md-8">
                        <div class="jumbotron text-center">
                            <img width="250" src="/mycv_app/assets/img/cv_ej.jpg"/>
                            <h1 class="page-header layout-color-main">¡Crea tu propio CV fácilmente!</h1>
                            <p>
                                ¡Deja de perder el tiempo gestionando tus varios currículums!<br>
                                Con MyCV podrás mantener actualizada tu información y tus perfiles en pocos minutos.
                            </p>

                        </div>
                    </div>
                    <div class="col-md-4 subtitle-welcome">
                        <h2>No tienes cuenta? Regístrate</h2>
                        <form action="Register" method="POST">
                            <div class="form-group">
                                <label class="control-label">Email</label>
                                <input type="email" class="form-control"  name="email"  placeholder="email" required>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Password</label>
                                <input pattern="\w{6,50}" type="password" class="form-control" name="password"  placeholder="password (mínimo: 6 caracteres)" required>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Nombre</label>
                                <input class="form-control" name="name"  placeholder="nombre" required>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Apellidos</label>
                                <input class="form-control" name="lastname"  placeholder="apellidos" required>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Género</label>
                                <div class="radio-group">
                                    <label class="radio-inline"><input type="radio" name="gender" value="1" checked="true">Hombre</label>
                                    <label class="radio-inline"><input type="radio" name="gender" value="2">Mujer</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Fecha de nacimiento</label>
                                <input class="form-control" type="date" pattern="\d{4}-\d{2}-\d{2}" name="birthdate" placeholder="Fecha de nacimiento(aaaa-mm-dd)" required>
                            </div>
                            <div class="form-group">
                                <label class="control-label">País</label>
                                <select class="form-control" name="country">
                                    <option value="">(seleccione una opción)</option>
                                    <%for(Country c : countryList){%>
                                        <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Ciudad</label>
                                <input class="form-control" name="city"  placeholder="Ciudad" required>
                            </div>
                            <div class="button-group">    
                                <input type="submit" name="register" value="Register" class="btn btn-success">
                            </div>
                        </form>
                    </div>

                </div>

                <div class="row">
                    <h2 class="text-center">¡Disfruta de nuestros servicios!</h2>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="well text-center">
                            <h3>¡Actualiza tu información una única vez!</h3>
                            <p>Tienes disponible toda tu información en un único punto. ¿Para qué invertir tiempo de más actualizando varios archivos para introducir lo mismo una y otra vez?</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="well text-center">
                            <h3>¡Perfiles personalizables para tu puesto ideal en dos pasos!</h3>
                            <p>Puedes adaptar el formato para cada perfil, controlar la información que aparece, cómo lo hace y todo esto sin tener que editarla directamente del lugar donde la tienes almacenada.</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="well text-center">
                            <h3>¡Descarga tu perfil desde donde quieras!</h3>
                            <p>Ya no necesitas buscar tus CV para diferentes perfiles. Los tienes todos aquí y puedes descargarlos en formato PDF cuando los necesites desde cualquier dispositivo.</p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
                                    
<%@include file="layout/lower.jsp" %>
   