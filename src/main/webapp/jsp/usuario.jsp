<%-- 
    Document   : usuario
    Created on : 19-feb-2019, 0:36:55
    Author     : lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Usuario</title>
    </head>
    <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
    <body>
        <div class="card">
            <img class="card-img-top" src="<%--c:out value="${perfil.foto}" escapeXml="true" default="https://placeimg.com/200/300/animals"--%>">
            <div class="card-body">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Director favorito</li>
                <li class="list-group-item">Pelicula favorita</li>
            </ul>

            <div class="card-body col-xs-6">
                <div class="col-xs-6">
                    <h2 class="sub-header col-xs-6">Subtitle</h2>
                    <div class="table-responsive col-xs-6">
                        <table class="table table-striped col-xs-6">
                        </table>
                    </div>
                </div>
                <div class="col-xs-6">
                    <h2 class="sub-header">Latest Incidents</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                        </table></div>
                </div>
            </div>
    </body>
</html>
