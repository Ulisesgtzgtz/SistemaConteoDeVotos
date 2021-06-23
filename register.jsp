<%-- 
    Document   : register
    Created on : 18/06/2021, 01:01:14 PM
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
        <title>Register</title>
    </head>
    <body>
        <h1 class="titulo">Registro</h1>
        
        <p style="color: #ff0000">${sessionScope['error']}</p>
        <form action="http://localhost:8080/SistemaConteoDeVotos/Register" method="post">
            <input type="text" name="nombre" placeholder="Nombre" required>
            <input type="text" name="apellido" placeholder="Apellido" required>
            <input type="text" name="correo" placeholder="Email" required>
            <input type="password" name="contrasena" placeholder="Contraseña" minlength="6" required>
            <input type="password" name="confirmarContrasena" placeholder="Confirmar Contraseña" minlength="6" required>
            <input type="text" name="domicilio" placeholder="Domicilio" required>
            <input type="text" name="colonia" placeholder="Colonia" required>
            <input type="text" name="codigoPostal" placeholder="Codigo Postal" minlength="5" maxlength="5" required>
            <input type="text" name="municipio" placeholder="Municipio" required>
            <input type="text" name="telefono" placeholder="Telefono" minlength="10" maxlength="10" required>
            <input type="submit" class="btn" value="Registrarse">
            <a href="login.jsp" class="btn3">Iniciar sesion</a>
        </form>
    </body>
</html>