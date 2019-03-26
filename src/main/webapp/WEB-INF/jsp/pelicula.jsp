<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%--a href="../../../../nb-configuration.xml"></a--%>
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>JSP pelicula</title>



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

                top: 40px;
            }

        </style>



    </head>

    <body>
        <header class="cabecera">
            <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        </header>

        <main class="my-md-3 container justify-content-center" >

            <div class="card mb-3" style="max-width: 1000px; max-height: 1200px;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <img src="${pelicula.foto}" class="card-img" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h2 class="card-title">${pelicula.titulo}</h2>
                            <p class="card-text">${not empty pelicula.descripcion ? pelicula.descripcion += ', en esta' : ''} película de ${pelicula.director.nombre}.</p>

                            <form method="POST">
                                <p class="clasificacion">
                                
                                    <input id="radio1" type="radio" name="estrellas" value="5"><!--
                                    --><label for="radio1">★</label><!--
                                    --><input id="radio2" type="radio" name="estrellas" value="4"><!--
                                    --><label for="radio2">★</label><!--
                                    --><input id="radio3" type="radio" name="estrellas" value="3"><!--
                                    --><label for="radio3">★</label><!--
                                    --><input id="radio4" type="radio" name="estrellas" value="2"><!--
                                    --><label for="radio4">★</label><!--
                                    --><input id="radio5" type="radio" name="estrellas" value="1"><!--
                                    --><label for="radio5">★</label>
                                </p>
                                 <button id="boton2" type="submit" class="btn btn-primary" form-control value="estrellas">Valorar</button>
                                 
                            </form>
                      
                       
                            <div id="carta" class="card" style="width: 10rem;">
                                <c:if test="${not empty pelicula.director.foto}">
                                    <img src="${pelicula.director.foto}" class="card-img-top" alt="...">
                                </c:if>
                                <div class="card-body">
                                    <p class="card-text">${pelicula.director.nombre}</p>
                                </div>

                            </div>



                            
                        </div>
                    </div>
                </div>
            </div>

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
                    </div>
                </li>
            </c:forEach>
        </ul>

        <c:forEach items="${errores}" var="error">
            <div class="alert alert-danger">
                ${error.message}
            </div>
        </c:forEach>

        <aside class="my-md-4 container input-group justify-content-end">
            <form  method="POST">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon3">Titulo</span>
                    </div>
                    <input type="text" class="form-control" id="basic-url" name="titulo" value="${titulo}">
                </div>
                <textarea class="input-group-text form-control text-left" name="comentario" rows="10" cols="120" placeholder="Escribe aquí tus comentario" >${texto}</textarea>
                <input class="btn btn-primary form-control" type="submit" value="Comentar">
            </form>
        </aside>


    </body>
</html>
