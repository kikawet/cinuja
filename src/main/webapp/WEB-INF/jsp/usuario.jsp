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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Usuario</title>
    </head>
    <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
    <body>
        <div class="card">
            <img class="card-img justify-content-center mx-auto mt-5 " style="max-width: 128px" src=https://pictures-of-cats.org/wp-content/uploads/images/fat-cat.jpg">
            <div class="card-body mx-auto">
                <p class="card-text ">Nick: ${perfil.nick} </p>
                <p class="card-text ">Nombre: ${perfil.nombre} </p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Director favorito: ${perfil.dFavorito}</li>
                <li class="list-group-item">Pelicula favorita: ${perfil.pFavorita}</li>
            </ul>

            <div class="card-body col-xs-6">
                <div class=" d-block">
                    <h2 class="sub-header col-xs-6">Comentarios</h2>
                    <div class="table-responsive col-xs-6">
                        <table class="table table-striped col-xs-6">
                            <tr> 
                                <th>Calificación</th>
                                <th>Película</th>
                                <th>Comentario</th>
                            </tr>
                        </table>
                    </div>
                </div>               
            </div>
    </body>
</html>
