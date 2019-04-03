<%-- 
    Document   : Login
    Created on : 12-mar-2019, 20:54:14
    Author     : axpos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <a href="../../../../nb-configuration.xml"></a>
    <%@include file="/WEB-INF/jspf/links.jspf" %>
    <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
    <title>JSP pelicula</title>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>HTML and CSS Form with Bootstrap 4</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <style type="text/css">
            body {
                background: #eee;
            }
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
        </style>
    </head>

    <body>
        <header class="cabecera">
            <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        </header>

        <div class="wrapper">

            <form class="form-signin">
                <h2 class="form-signin-heading text-center">CinUJA</h2>
                <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
                <input type="password" class="form-control is-invalid" name="password" placeholder="Password" required="" />
                <div class="invalid-feedback">La contraseña no puede estar vacia</div>
                <label class="checkbox">
                    <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe">
                    Recuerdame
                </label>
                <button class="btn btn-lg btn-primary btn-block" href="Portada">Entrar</button>
                <button class="btn btn-lg btn-primary btn-block" href="inicio.jsp" >Registrarse</button>

            </form>

        </div>
    </body>
</html>