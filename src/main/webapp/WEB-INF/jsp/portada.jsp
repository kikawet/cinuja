<%-- 
    Document   : portada
    Created on : 18-feb-2019, 20:05:47
    Author     : lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP portada</title>
    </head>
    <body>

        <header class="cabecera">
            <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        </header>

        <main class="row">
            <aside class="col-md-2">
                <nav class="ml-md-auto">
                    <h1 class="text-truncate text-md-center">Géneros</h1>                    
                    <ul class="list-group list-group-flush">
                        <c:forEach items="${generos}" var="genero">
                            <li class="list-group-item text-truncate text-md-center"> <a href="portada?genero=${genero.hashCode()}" > ${genero}</a> </li>
                            </c:forEach>
                    </ul>
                </nav>
            </aside>

            <section class="my-md-3 container justify-content-center" >
                <div class="my-md-3 row">   

                    <c:forEach items="${peliculas}" var="p">                    
                        <nav class="col-md my-md-3">
                            <div class="card" style="width: 14rem;">
                                <img src="${p.foto}"  class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">${p.titulo} (1990)</h5>
                                    <p class="card-text">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">${p.director.nombre}</li>
                                        <li class="list-group-item">${generos[p.genero]}</li>
                                    </ul>
                                    <div class="card-body">
                                        <a href="pelicula.jsp" class="card-link">Favoritas</a>
                                        <a href="pelicula.jsp" class="card-link">Ver/hacer criticas</a>
                                    </div>
                                </div>
                        </nav>                        
                    </c:forEach>

                </div>
            </section>
        </main>
    </body>
</html>