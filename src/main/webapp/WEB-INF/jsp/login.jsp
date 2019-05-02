<%-- 
    Document   : Login
    Created on : 12-mar-2019, 20:54:14
    Author     : axpos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>JSP pelicula</title>
        <!--        <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <title>HTML and CSS Form with Bootstrap 4</title>
        <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>-->
        <style type="text/css">
            .wrapper {
                margin: 80px;
            }
            .form-signin {
                max-width: 380px;
                margin: 0 auto;
                background-color: #fff;
                padding: 15px 40px 50px;
                border: 1px solid #e5e5e5;
                border-radius: 10px;
            }
            .form-signin .form-signin-heading, .form-signin .checkbox {
                margin-bottom: 30px;
            }
            .form-signin input[type="text"], .form-signin input[type="password"] {
                margin-bottom: 20px;
            }
            .form-signin .form-control {
                padding: 10px;
            }

            #cuadro{

                position:relative;
                top: 60px;
            }
        </style>
    </head>

    <body background="https://s2.best-wallpaper.net/wallpaper/1920x1200/1711/Warm-light-circles-glare_1920x1200.jpg">
        <!--        <header class="cabecera">
        <%--<%@include file="/WEB-INF/jspf/cabecera.jspf" %>--%>
    </header>-->



        <div id="cuadro" class="wrapper">
            <form class="form-signin" action="j_security_check" method="post">               

                <h1 class="form-signin-heading text-center"><b>🍿 CinUJA 🍿</b></h1>
                <input type="text" class="form-control" name="j_username" placeholder="Nick"  autofocus="" />
                <input type="password" class="form-control" name="j_password" placeholder="Contraseña"  />
                <c:if test="${param.error}">
                    <div class="invalid-feedback">Los campos son erroneos</div>
                </c:if>
                <!--label class="checkbox">
                    <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe">
                    Recuerdame
                </label-->
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Entrar"/>
                <a class="btn btn-lg btn-primary btn-block" role="button" href="${pageContext.request.contextPath}/perfil/registro" >Registrarse</a>
                <a class="btn btn-danger btn-block my-2 py-2 " role="button" aria-pressed="true" href="portada" ><h5>Cancelar</h5></a>
            </form>

        </div>
    </body>
</html>
