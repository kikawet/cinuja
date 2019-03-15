

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <a href="../../../../nb-configuration.xml"></a>
    <%@include file="../WEB-INF/jspf/links.jspf" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP pelicula</title>
</head>

<body>

    <header class="cabecera">

        <%@include file="../WEB-INF/jspf/cabecera.jspf" %>

    </header>

    <main class="my-md-3 container justify-content-center" >

        <div class="card mb-3" style="max-width: 1000px; max-height: 1200px;">
            <div class="row no-gutters">
                <div class="col-md-4">
                    <img src="http://es.web.img2.acsta.net/medias/nmedia/18/67/70/14/20077949.jpg" class="card-img" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h2 class="card-title">Uno de los nuestros</h2>
                        <p class="card-text">Un hombre de Brooklyn busca la fama y la fortuna en el crimen organizado, en esta película de Martin Scorsese.</p>

                        <form>
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
                        </form>

                        <div class="card" style="width: 10rem;">
                            <img src="http://d3iln1l77n73l7.cloudfront.net/couch_images/attachments/000/057/537/original/Martin_Scorsese.jpg?2014" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">Martin Scorsese</p>
                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </div>

    </main>

    <ul class="list-unstyled" >
        <li class="media my-4">
            <img src="https://ct.yimg.com/cy/1904/44016886825_e02d29_128sq.jpg" class="mr-4" alt="...">
            <div class="media-body">
                <h3 class="mt-0 mb-1">Maravillosa</h3>
                La mejor pelicula de mi vida.
            </div>
        </li>
        <li class="media my-4">
            <img src="https://66.media.tumblr.com/avatar_ea54a1bd0195_128.pnj" class="mr-4" alt="...">
            <div class="media-body">
                <h3 class="mt-0 mb-1">No está mal</h3>
                Es bastante entretenida pero prefiero ver Salvame.
            </div>
        </li>
        <li class="media my-4">
            <img src="http://pm1.narvii.com/6265/5bba4fd8638ebdea1100eb9b06940944a8913fc0_128.jpg" class="mr-4" alt="...">
            <div class="media-body">
                <h3 class="mt-0 mb-1">Aburrida</h3>
                Yo me aburrí. Preferiría morirme en este momento.
            </div>
        </li>
    </ul>

    <aside class="my-md-4 container justify-content-end">

        <textarea name="comentarios" rows="10" cols="120">Escribe aquí tus comentarios</textarea>

    </aside>


</body>
</html>
