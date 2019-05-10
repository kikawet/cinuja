<%-- 
    Document   : portada
    Created on : 18-feb-2019, 20:05:47
    Author     : lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>JSP portada</title>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.js"></script>
        <script type="module" src="js/modules/portada/app-portada.module.js"></script>
        <script src="js/validacion/pelicula.js"></script>
    </head>
    <body>

        <header class="cabecera">
            <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        </header>
        <div data-ng-app="portada.app">
            <app-portada></app-portada>     

        </div>        

        <c:if test="${sesion.usuario.rol.equals('adm')}">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Añadir película</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <form:form id="frmPeli" method="POST" action="pelicula/crear" modelAttribute="peliculaDTO">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Nombre de la película</label>
                                    <form:input id="titulo" cssClass="form-control" path="titulo" placeholder="Título"/>
                                    <div class="invalid-feedback" id="errorTitulo"></div>
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">URL de la película</label>
                                    <form:input id="url" cssClass="form-control" path="url" placeholder="URL"/>
                                    <div class="invalid-feedback" id="errorUrl"></div>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Fecha de estreno</label>
                                    <form:input type="date" path="fecha" class="form-control" placeholder="Año de la película"/>
                                </div>
                                <!--                                                                                    <div class="form-group">
                                                                                                                        <label for="exampleInputPassword1">Director</label>
                                <form:select class="form-control" path="" placeholder="Nombre director"/>
                            </div>-->
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Género</label>
                                    <form:select cssClass="form-control" path="genero" items="${mapGeneros}"/>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Imagen portada</label>
                                    <form:input id="foto" class="form-control" path="foto" placeholder="URL de la imagen"/>
                                    <div class="invalid-feedback" id="errorFoto"></div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <input type="submit" class="btn btn-success" value="Añadir">
                                </div>
                            </form:form>

                        </div>

                    </div>
                </div>
            </div>
        </c:if>
        <!--        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Añadir película</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form  id="frmPeli" method="POST" action="pelicula/crear">
                                        <div class="form-group">
                                            <label>Nombre de la película</label>
                                            <input id="titulo" class="form-control" ng-model="$ctrl.pelicula.titulo" placeholder="Título">
                                        </div>
                                        <div class="form-group">
                                            <label >URL de la película</label>
                                            <input id="url" class="form-control" ng-model="$ctrl.pelicula.url" placeholder="URL"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Fecha de estreno</label>
                                            <input type="date" ng-model="$ctrl.pelicula.fecha" class="form-control"/>
                                        </div>
                                                                        <div class="form-group">
                                                                            <label>Director</label>
                                                                            <select class="form-control">
                                                                        </div>
                                        <div class="form-group">
                                            <label>Género</label>
                                            <select class="form-control" ng-model="$ctrl.pelicula.genero" ng-options="pos as genero for (pos,genero) in $ctrl.generos"></select>
                                        </div>
                                        <div class="form-group">
                                            <label>Imagen portada</label>
                                            <input id="foto" class="form-control" ng-model="$ctrl.pelicula.foto" placeholder="URL de la imagen"/>
                                            <img src="{{$ctrl.pelicula.foto}}" ng-show="$ctrl.pelicula.foto" class="card-img-top" style="max-height: 800px; min-height: 400px;" alt="">
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                            <input type="submit" class="btn btn-success" value="Añadir"/>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>-->
    </body>
</html>
