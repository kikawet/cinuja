<%--
    Document   : inicio
    Created on : 25-feb-2019, 16:10:00
    Author     : lopez
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>JSP inicio</title>
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <script src="${pageContext.request.contextPath}/js/validacion/usuario.js"></script>
    </head>

    <body class="">
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div class="my-xl-5 mx-lg-5">
            <div class="bg-white m-auto mh-700" style="height: 700px">

                <form:form method="POST" id="frmreg" modelAttribute="usuarioDTO">
                    <div class="form-row">
                        <div class="col-md-5 mb-3">
                            <c:set var="err" value=""/>
                            <c:if test="${errors.contains('nombre')}">
                                <c:set var="err" value="is-invalid"/>
                            </c:if>
                            <label for="validationServer01">Nombre</label>
                            <form:input  cssClass="form-control ${err}" id="idNombre" placeholder="Nombre" path="nombre" />
                        </div>

                        <div class="col-md-5 mb-3">
                            <c:set var="err" value=""/>
                            <c:if test="${errors.contains('apellidos')}">
                                <c:set var="err" value="is-invalid"/>
                            </c:if>
                            <label for="validationServer02">Apellidos</label>
                            <form:input cssClass="form-control ${err}" id="idApellidos" placeholder="Apellidos" path="apellidos" />
                            <div class=""></div>                            
                        </div>

                        <div class="col-md-2 mb-3">
                            <c:set var="err" value=""/>
                            <c:if test="${errors.contains('nick')}">
                                <c:set var="err" value="is-invalid"/>
                            </c:if>
                            <label for="validationServerUsername">Nick</label>      
                            <form:input cssClass="form-control ${err}" id="idNick" placeholder="Nick" path="nick"/>

                        </div>

                    </div>

                    <div class="form-row ">
                        <div class="col-md-4 mb-3 ml-auto">
                            <c:set var="err" value=""/>
                            <c:if test="${errors.contains('contrasena')}">
                                <c:set var="err" value="is-invalid"/>
                            </c:if>
                            <label for="validationServer04">Contraseña</label>
                            <form:input cssClass="form-control ${err}"  id="idCtrs1" placeholder="Contraseña" path="contrasena" />

                        </div>

                        <div class="col-md-4 mb-3 mr-auto">
                            <label for="validationServer05">Repetir Contraseña</label>
                            <input type="text" class="form-control ${err}" id="idCtrs2" name="contrasena2" placeholder="Contraseña" value="${contrasena2}" >

                        </div>

                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <c:set var="err" value=""/>
                            <c:if test="${errors.contains('terminos')}">
                                <c:set var="err" value="is-invalid"/>
                            </c:if>
                            <form:checkbox cssClass="form-check-input ${err}" path="terminos" id="idTrm" />
                            <label class="form-check-label" for="invalidCheck3">
                                <a href="#" data-toggle="modal" data-target="#exampleModal">
                                    Acepto los terminos de condición
                                </a>
                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title" id="exampleModalLabel"><b>Términos y condiciones</b></h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">

                                                <br><b>LICENCIA</b><br>

                                                <br>Cinuja  a través de su sitio web concede una licencia para que los usuarios utilicen  los productos que son vendidos en este sitio web de acuerdo a los Términos y Condiciones que se describen en este documento.<br>

                                                <br><b>USO NO AUTORIZADO</b><br>

                                                <br> En caso de que aplique (para venta de software, templetes, u otro producto de diseño y programación) usted no puede colocar uno de nuestros productos, modificado o sin modificar, en un CD, sitio web o ningún otro medio y ofrecerlos para la redistribución o la reventa de ningún tipo.<br>

                                                <br><b>PROPIEDAD</b><br>


                                                <br> <br>Usted no puede declarar propiedad intelectual o exclusiva a ninguno de nuestros productos, modificado o sin modificar. Todos los productos son propiedad  de los proveedores del contenido. En caso de que no se especifique lo contrario, nuestros productos se proporcionan  sin ningún tipo de garantía, expresa o implícita. En ningún esta compañía será  responsables de ningún daño incluyendo, pero no limitado a, daños directos, indirectos, especiales, fortuitos o consecuentes u otras pérdidas resultantes del uso o de la imposibilidad de utilizar nuestros productos.<br>



                                                <br>Cinuja reserva los derechos de cambiar o de modificar estos términos sin previo aviso.<br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </label>

                        </div>
                    </div>


                    <div class="text-center">
                        <button class="btn btn-primary" type="submit">Regístrame</button>
                        <a class="btn btn-danger" role="button" href="${pageContext.request.contextPath}/portada" >Cancelar</a>
                    </div>
                </form:form>
                <br>
                <form:errors path="usuarioDTO.*" cssClass="alert alert-danger" element="div"/>
                <div id="idErrores"></div>
            </div>
    </body>
</html>





