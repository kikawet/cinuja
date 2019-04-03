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
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>JSP portada</title>
        <style>

            #boton{
                position:relative;
                left:25px;
            }

            #boton3 {

                position:relative;
                right: -70px;
                top: 100px;
                width: 120px;
                height: 60px;
            }

        </style>

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
                            <li class="list-group-item text-truncate text-md-center"> <a class="navbar-bar nav-link" href="portada?genero=${genero.hashCode()}" > ${genero}</a> </li>
                            </c:forEach>
                    </ul>
                </nav>

                <button id="boton3" type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal">
                   ⚙
                </button>


                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Editar portada</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <button type="button" class="btn btn-primary">Editar</button>
                                <button type="button" class="btn btn-success">Añadir</button>
                                <button type="button" class="btn btn-danger">Borrar</button>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                            </div>
                        </div>
                    </div>
                </div>
            </aside>



            <section class="my-md-3 container d-flex justify-content-start">
                <div class="my-md-3 row d-flex justify-content-start">   

                    <c:if test="${empty peliculas}">
                        <p>No hay películas de ese género</p>
                    </c:if>

                    <c:forEach items="${peliculas}" var="p">           

                        <nav class="col-md my-md-3">
                            <div class="card" style="width: 15rem;">
                                <a href="pelicula/${p.url}">
                                    <img href= pelicula/${p.url}" src="${p.foto}"  class="card-img-top" alt="..."  > 
                                </a>
                                <div class="card-body">
                                    <a href="pelicula/${p.url}">
                                        <h5 class="card-title"><i>${p.titulo} </i></h5><%-- Calendar.YEAR = 1 --%>
                                    </a>
                                    <p class="card-text">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">${p.fecha.get(1)}</li>
                                        <li class="list-group-item">${p.director.nombre}</li>
                                        <li class="list-group-item">${generos[p.genero]}</li>
                                    </ul>

                                </div>
                            </div>
                        </nav>


                    </c:forEach>

                </div>
            </section>
        </main>
    </body>
</html>