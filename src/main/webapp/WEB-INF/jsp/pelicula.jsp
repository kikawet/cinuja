<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<a href="nb-configuration.xml"></a>-->
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>JSP pelicula</title>
        <script src="${pageContext.request.contextPath}/js/validacion/comentario.js"></script>
        <style>


            #form {
                width: 250px;
                margin: 0 auto;
                height: 50px;

            }

            #form p {
                text-align: center;

            }

            #form label {

                font-size: 30px;
                font-size: 2rem;
            }

            input[type="radio"] {
                display: none;

            }

            label {
                color: grey;
                font-size: 32px;
                font-size: 2rem;
            }

            .clasificacion {
                direction: rtl;
                unicode-bidi: bidi-override;

            }

            label:hover,
            label:hover ~ label {

                color: orange;
            }

            input[type="radio"]:checked ~ label {

                color: orange;
            }

            #boton2 {

                position:relative;
                right: 1px;
                top: 1px;
                width: 100px;
                height: 40px;
            }

            #carta {

                position:relative;
                top: -30px;
                left: 300px;

            }

        </style>

        <script>
            let frm = '#frmStar';
            let btn = '#btnStar';
            let idVotos = '#votos';
            let votos = ${pelicula.nVotos};

            $(() => {
                $(idVotos).text(votos);

                $(frm).on('submit', (event) => {
                    event.preventDefault();
                    votos++;
                    $(idVotos).text(votos);
                    $(btn).prop("disabled", true);
                });
            });

        </script>

    </head>

    <body>

        <header class="cabecera">
            <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        </header>

        <main class="my-md-3 container justify-content-center" >

            <div class="card mb-3" style="max-width: 1000px; max-height: 1200px;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <img src="${pelicula.foto}" class="card-img" style="max-height: 556px; min-height: 560px;" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h2 class="card-title">${pelicula.titulo}</h2>
                            <p class="card-text">${not empty pelicula.descripcion ? pelicula.descripcion += ', en esta' : ''} película de ${pelicula.director.nombre}.</p>

                            <div><h2 style="display: inline"><b><fmt:formatNumber type="number" maxFractionDigits="1" value="${pelicula.nota}"/></b></h2><h5 style="color: gray; display: inline">/5</h5 > de <span id="votos"></span> votos</div>
                                        <c:if test="${not empty sesion.usuario}"> 

                                <form action="${pelicula.url}" id="frmStar" method="POST">
                                    <p class="clasificacion">

                                        <input id="radio1" type="radio" name="estrellas" value="5"><!--
                                        --><label for="radio1">★</label><!--
                                        --><input id="radio2" type="radio" name="estrellas" value="4"><!--
                                        --><label for="radio2">★</label><!--
                                        --><input id="radio3" type="radio" name="estrellas" value="3"><!--
                                        --><label for="radio3">★</label><!--
                                        --><input id="radio4" type="radio" name="estrellas" value="2"><!--
                                        --><label for="radio4">★</label><!--
                                        --><input id="radio5" type="radio" name="estrellas" value="1" checked><!--
                                        --><label for="radio5">★</label>
                                    </p>
                                    <button id="btnStar" type="submit" class="btn btn-primary" form-control value="estrellas">Valorar</button>
                                </form>
                            </c:if>

                            <div id="carta" class="card" style="width: 12rem;">
                                <c:if test="${not empty pelicula.director.foto}">
                                    <img src="${pelicula.director.foto}" class="card-img-top" style="max-height: 190px; min-height: 190px;" alt="...">
                                </c:if>
                                <div class="card-body">
                                    <p class="card-text">${pelicula.director.nombre}</p>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div> 

            <c:if test="${sesion.usuario.rol eq 'adm'}">
                <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/perfil/salir">Editar</a>
                <a role="button" class="btn btn-danger" href="${pelicula.url}/borrar">Borrar</a>
            </c:if>

        </main>

        <ul class="list-unstyled" >

            <c:if test="${empty comentarios}">
                <p> No hay comentarios deja el tuyo </p>
            </c:if>

            <c:forEach items="${comentarios}" var="comentario">
                <li class="media my-4">
                    <img src="${comentario.usuario.foto}" class="mr-4" alt="...">
                    <div class="media-body">
                        <h3 class="mt-0 mb-1"> ${fn:escapeXml(comentario.titulo)} </h3>
                        ${fn:escapeXml(comentario.texto)}
                        <button type="button" class="btn btn-light">👍</button>
                    </div>
                </li>
            </c:forEach>
        </ul>

        <!--c:forEach items="${errores}" var="error">
            <div class="alert alert-danger">
        ${error.message}
    </div>
        <!--/c:forEach-->

        <aside class="my-md-4 container input-group justify-content-center">                

            <c:if test="${empty sesion.usuario}">
                <div class="alert alert-danger ">Inicia sesión para comentar</div>
            </c:if>

            <c:if test="${not empty sesion.usuario}">    





                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Comentario no válido</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form:errors path="comentarioDTO.*" cssClass="alert alert-danger" element="div"/>
                                <div id="errores"></div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                            </div>
                        </div>
                    </div>
                </div>


                <form:form id="frmcmt" method="POST" modelAttribute="comentarioDTO">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon3">Titulo</span>
                        </div>
                        <form:input path="titulo" cssClass="form-control" id="tittle"/>
                    </div>
                    <form:textarea path="texto" cssClass="input-group-text form-control text-left" id="texto" rows="10" cols="120" placeholder="Escribe aquí tu comentario"/>
                    <input class="btn btn-primary form-control" type="submit" data-toggle="modal" data-target="#exampleModal" value="Comentar" >
                </form:form>

            </c:if>
        </aside>

    </body>
</html>
