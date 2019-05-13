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

        <div id="cuadro" class="wrapper">
            <form class="form-signin" action="j_security_check" method="post">               

                <h1 class="form-signin-heading text-center"><b>🍿 CinUJA 🍿</b></h1>
                <input type="text" class="form-control" name="j_username" placeholder="Nick"  autofocus="" />
                <input type="password" class="form-control" name="j_password" placeholder="Contraseña"  />
                <c:if test="${param.error}">
                    <div class="invalid-feedback">Los campos son erroneos</div>
                </c:if>
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Entrar"/>
                <a class="btn btn-danger btn-block my-2 py-2 " role="button" aria-pressed="true" href="portada" ><h5>Cancelar</h5></a>
                 <a class="text-center" role="link" style="color: seagreen;" href="${pageContext.request.contextPath}/perfil/registro" >¿Aún no tienes cuenta? Registrate pinchando aquí</a>
            </form>
        </div>
    </body>
</html>
