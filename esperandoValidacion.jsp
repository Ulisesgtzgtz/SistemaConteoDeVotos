<%-- 
    Document   : esperandoValidacion
    Created on : 22/06/2021, 01:04:01 AM
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
        <title>Esperando</title>
    </head>
    <body>
        <h1 class="titulo">El administrador aun no valida tu cuenta</h1>
        
        <p style="color: #ff0000">${sessionScope['error']}</p>
        <form action="http://localhost:8080/SistemaConteoDeVotos/index.jsp" method="post">
            <input type="submit" class="btn" value="Regresar">
        </form>
    </body>
</html>