<%-- 
    Document   : inicio
    Created on : 25-feb-2019, 16:10:00
    Author     : lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP inicio</title>
    </head>
    <body class="bg-secondary">
        <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
        <div class="bg-light m-auto">
            <form >
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <label for="validationServer01">Nombre</label>
                        <input type="text" class="form-control is-valid" id="validationServer01" placeholder="Nombre" value="${us.nombre}" required>
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="validationServer02">Apellidos</label>
                        <input type="text" class="form-control is-valid" id="validationServer02" placeholder="Apellidos" value="${us.apellido}" required>
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="validationServerUsername">Nick</label>      
                        <input type="text" class="form-control input-group is-invalid" id="validationServerUsername" placeholder="Nick" aria-describedby="inputGroupPrepend3" required>
                        <div class="invalid-feedback">
                            Please choose a username.
                        </div>
                    </div>
                </div>
                <div class="form-row ">
                    <div class="col-md-3 mb-3 ml-auto">
                        <label for="validationServer04">Contraseña</label>
                        <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="Contraseña" required>
                        <div class="invalid-feedback">
                            Please provide a valid state.
                        </div>
                    </div>
                    <div class="col-md-3 mb-3 mr-auto">
                        <label for="validationServer05">Repetir Contraseña</label>
                        <input type="text" class="form-control is-invalid" id="validationServer05" placeholder="Contraseña" required>
                        <div class="invalid-feedback">
                            Please provide a valid zip.
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" required>
                        <label class="form-check-label" for="invalidCheck3">
                            Agree to terms and conditions
                        </label>
                        <div class="invalid-feedback">
                            You must agree before submitting.
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Submit form</button>
            </form>
        </div>
    </body>
</html>
