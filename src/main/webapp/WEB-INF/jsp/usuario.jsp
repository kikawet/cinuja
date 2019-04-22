<%-- 
    Document   : usuario
    Created on : 19-feb-2019, 0:36:55
    Author     : lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <title>JSP Usuario</title>
    </head>

    <header>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
    </header>

    <body>
        <div class="card">
            <img class="card-img justify-content-center mx-auto mt-5 " style="max-width: 128px" src="${perfil.foto}">
            <div class="card-body mx-auto">
                <p class="card-text ">Nick: ${fn:escapeXml(perfil.nick)} </p>
                <p class="card-text ">Nombre: ${fn:escapeXml(perfil.nombre)} </p>

               
                <a role="button" class="btn btn-success" href="perfil/cc" >Cambiar contraseña</a>

            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Director favorito: ${perfil.dFavorito.nombre}</li>
                <li class="list-group-item">Pelicula favorita: ${perfil.pFavorita.titulo}</li>
            </ul>

            <div class="card-body col-xs-6">
                <div class=" d-block">
                    <h2 class="sub-header col-xs-6">Comentarios (prototipo) </h2>
                    <div class="table-responsive col-xs-6">

                        <c:if test="${empty comentarios}">
                            <p>Todavia no has escrito ningun comentario</p>
                        </c:if>

                        <c:if test="${not empty comentarios}">
                            <table class="table table-striped col-xs-6">
                                <tr> 
                                    <th>Calificación</th>
                                    <th>Película</th>
                                    <th>Comentario</th>                               

                                </tr>
                                <c:forEach items="${comentarios}" var="comentario">
                                    <tr>
                                        <td>${comentario.valoracion}</td>
                                        <td>
                                            <div class="card" style="width: 14rem;">
                                                <a href="pelicula/${comentario.pelicula.url}">
                                                    <img href= pelicula/${comentario.pelicula.url}" src="${comentario.pelicula.foto}"  class="card-img-top" alt="..."> 
                                                </a>
                                                <div class="card-body">
                                                    <h5 class="card-title">${comentario.pelicula.titulo} (1990)</h5>
                                                    <p class="card-text">
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">${comentario.pelicula.director.nombre}</li>
                                                        <li class="list-group-item">${generos[comentario.pelicula.genero]}</li>
                                                    </ul>
                                                    <div class="card-body">
                                                        <a href="pelicula/${comentario.pelicula.url}" class="card-link">Ver/hacer criticas</a>
                                                    </div>
                                                </div>
                                        </td>
                                        <td>
                                            <div class="media-body">
                                                <h3 class="mt-0 mb-1"> ${fn:escapeXml(comentario.titulo)} </h3>
                                                <p>${fn:escapeXml(comentario.texto)}</p>
                                                <form method="post" action="perfil/borrar/comentario?com=${comentario.texto.hashCode()}&pel=${comentario.pelicula.titulo.hashCode()}"> 
                                                    <input type="submit" class="btn btn-success" value="Editar"/>
                                                    <input type="submit" class="btn btn-danger" value="Eliminar"/>
                                                </form>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                    </div>
                </div>               
            </div>
    </body>
</html>
