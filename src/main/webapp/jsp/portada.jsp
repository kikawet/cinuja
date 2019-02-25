<%-- 
    Document   : portada
    Created on : 18-feb-2019, 20:05:47
    Author     : lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <a href="../../../../nb-configuration.xml"></a>
        <%@include file="../WEB-INF/jspf/links.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP portada</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/cabecera.jspf" %>
        
        <section class="d-inline-flex">
            <h1>Películas</h1>
            <%--
            No tengo claro como mostrar los datos de las películas
            @TODO
            --%>
            <ul>
            <c:forEach var="variable" begin="1" end="10" step="1">
                <li class="d-inline"> ${variable} </li> 
            </c:forEach>
            </ul>
          
        </section>
        
        <!--aside class="d-inline-flex">

            <h2>LATERAL</h2>
            
        </aside-->

    </body>
</html>
  