<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <%@include file="/WEB-INF/jspf/links.jspf" %>
        <style>

            body{
                background-size: 100%;
                background-color: #f96805;
            }

        </style>

    </head>

    <body class="bg-secondary">
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <div style="height: 700px; ">
            <div class="bg-white m-auto mh-700" style="height: 700px">
                <form method="POST">
                    <div class="form-row">
                    </div>

                    <div class="form-row ">
                        <div class="col-md-3 mb-3 ml-auto">
                            <p class="text-md-center" >Contraseña</p>
                            <input type="text" class="form-control" placeholder="Contraseña" required name="contrase">
                        </div>

                        <div class="col-md-3 mb-3 mr-auto">
                            <p class="text-md-center">Repetir Contraseña</p>
                            <input type="text" class="form-control" id="validationServer05" placeholder="Contraseña" required >
                        </div>

                    </div>

                    <div class="text-center">
                        <input  class="btn btn-primary" type="submit" value="Aceptar">
                        <a  class="btn btn-danger" role="button" href="${pageContext.request.contextPath}/perfil">Volver</a>
                    </div>

                    <c:forEach items="${errores}" var="error">
                        <div class="alert alert-danger">
                            ${error.message}
                        </div>
                    </c:forEach>

                </form>
            </div>
        </div>
    </body>
</html>