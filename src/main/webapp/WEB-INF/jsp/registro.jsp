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
                            <form:input cssClass="form-control ${err}" id="idCtrs1" placeholder="Contraseña" path="contrasena" />
                           
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
                                Acepto los terminos de condición
                            </label>                            
                        </div>
                    </div>


                    <div class="text-center col-md-1 d-flex f-center m-4">
                        <input class="btn btn-primary" type="submit" value="Regístrame"/>
                        <a class="btn btn-danger btn-block" role="button" href="${pageContext.request.contextPath}/portada" ><h5>Cancelar</h5></a>
                    </div>
                </form:form>
                <form:errors path="usuarioDTO.*" cssClass="alert alert-danger" element="div"/>
                <div id="idErrores"></div>
            </div>
    </body>
</html>
