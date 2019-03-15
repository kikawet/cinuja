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
                    <li class="list-group-item text-truncate text-md-center">Acción y aventura</li>
                    <li class="list-group-item text-truncate text-md-center">Adultos (+18)</li>
                    <li class="list-group-item text-truncate text-md-center">Bélico</li>
                    <li class="list-group-item text-truncate text-md-center">Ciencia ficción</li>
                    <li class="list-group-item text-truncate text-md-center">Comedia</li>
                    <li class="list-group-item text-truncate text-md-center">Deportes</li>
                    <li class="list-group-item text-truncate text-md-center">Dibujos animados</li>
                    <li class="list-group-item text-truncate text-md-center">Documentales</li>
                    <li class="list-group-item text-truncate text-md-center">Drama</li>
                    <li class="list-group-item text-truncate text-md-center">Familiar</li>
                    <li class="list-group-item text-truncate text-md-center">Mafia</li>
                    <li class="list-group-item text-truncate text-md-center">Música</li>
                    <li class="list-group-item text-truncate text-md-center">Romántica</li>
                    <li class="list-group-item text-truncate text-md-center">Terror</li>
                    <li class="list-group-item text-truncate text-md-center">Thriller</li>
                    <li class="list-group-item text-truncate text-md-center"></li>
                </ul>
            </nav>
        </aside>

        <section class="my-md-3 container justify-content-center" >
            <div class="my-md-3 row">
                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="http://es.web.img2.acsta.net/medias/nmedia/18/67/70/14/20077949.jpg"  class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Uno de los nuestros (1990)</h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Martin Scorsese</li>
                                <li class="list-group-item">Mafia</li>
                            </ul>
                            <div class="card-body">
                                <a href="pelicula.jsp" class="card-link">Favoritas</a>
                                <a href="pelicula.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/09/pulp-fiction_0.jpg"   class="card-img-top" alt="">
                        <div class="card-body">
                            <h5 class="card-title">Pulp Fiction 
                                <p>(1997)
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Quentin Tarantino</li>
                                <li class="list-group-item">Mafia</li>
                            </ul>
                            <div class="card-body">
                                <a href="login.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                </nav>



                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://twistedsifter.files.wordpress.com/2015/10/53-saving-private-ryan.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Salvar al soldado Bryan (1998)</h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Steven Spielberg</li>
                                <li class="list-group-item">Bélico</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>
                </nav>


                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://educayaprende.com/wp-content/uploads/2014/05/ratatouille-cover-caratula-dvd-disney-pixar.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Ratatouille <p>
                                    (2007)
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Pixar</li>
                                <li class="list-group-item">Dibujos animados</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="login.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>

                <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>
                
           <nav class="col-md my-md-3">
                    <div class="card" style="width: 14rem;">
                        <img src="https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Bohemian Rhapsody (2018) <p>
                                </p></h5>
                            <p class="card-text">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Bryan Singer</li>
                                <li class="list-group-item">Música</li>
                            </ul>
                            <div class="card-body">
                                <a href="usuario.jsp" class="card-link">Favoritas</a>
                                <a href="usuario.jsp" class="card-link">Ver/hacer criticas</a>
                            </div>
                        </div>
                    </div>   
                </nav>
            </div>
        </section>
    </main>
</body>
</html>