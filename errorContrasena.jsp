<%-- 
    Document   : errorContrasena
    Created on : 22/06/2021, 12:38:10 AM
    Author     : Ulisesgtz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- En caso de que exista una sesion iniciada redirecciono a index.jsp. "NO tiene caso mostrar este formulario cuando hay una sesion iniciada --%>
<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("index.jsp");%>
</t:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css">
        <title>Error</title>
    </head>
    <body>
        <h1 class="titulo">Error</h1>
        <h2 class="titulo">Contraseñas diferentes</h2>
        
        <p style="color: #ff0000">${sessionScope['error']}</p>
        <form action="http://localhost:8080/SistemaConteoDeVotos/register.jsp" method="post">
            <input type="submit" class="btn" value="Aceptar">
        </form>
    </body>
</html>
