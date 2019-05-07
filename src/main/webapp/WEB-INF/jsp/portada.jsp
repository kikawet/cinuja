<%-- 
    Document   : portada
    Created on : 18-feb-2019, 20:05:47
    Author     : lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>JSP portada</title>

    </head>
    <body>

        <header class="cabecera">
            <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        </header>
        <form class="form-inline ml-4 my-2">
            <input class="form-control mr-sm-2" type="text" placeholder="Buscar película" aria-label="Search">
            <button class="btn btn-outline-primary btn-rounded btn-sm my-0" type="submit">Buscar</button>
        </form>
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

                <c:if test="${sesion.usuario.rol eq 'adm'}">

                    <button type="button" class="btn btn-success my-lg-5 px-4" style="margin-left:80px;" data-toggle="modal" data-target="#exampleModal" id="boton3">Añadir</button>





                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Añadir película</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">

                                    <form>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Nombre de la película</label>
                                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Título">
                                            
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Año</label>
                                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Año de la película">
                                                   </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Director</label>
                                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Nombre director">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Género</label>
                                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Ej: Acción, Drama...">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleFormControlInput1">Imagen portada</label>
                                            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="URL de la imagen">
                                        </div>
                                        

                                    </form>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-success">Añadir</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
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
                                    <img href= pelicula/${p.url}" src="${p.foto}" class="card-img-top" style="max-height: 800px; min-height: 400px;" alt="..."> 
                                </a>
                                <div class="card-body">
                                    <a href="pelicula/${p.url}">
                                        <h6 class="card-title"><i>${p.titulo} </i></h6><%-- Calendar.YEAR = 1 --%>
                                    </a>
                                    <p class="card-text">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">${p.fecha.year + 1900}</li>
                                        <li class="list-group-item">${p.director.nombre}</li>
                                        <li class="list-group-item">${generos[p.genero]}</li>
                                        <li class="list-group-item"><b><fmt:formatNumber type="number" maxFractionDigits="1" value="${p.nota}"/></b>/5</li>
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
