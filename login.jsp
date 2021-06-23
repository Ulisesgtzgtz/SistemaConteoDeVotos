<%-- 
    Document   : login
    Created on : 18/06/2021, 01:00:55 PM
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
        <title>Login</title>
    </head>
    <body>
        <h1 class="titulo">Iniciar sesion</h1>
        
        <p style="color: #ff0000">${sessionScope['error']}</p>
        <form action="Login" method="post">
            <input type="text" name="correo" placeholder="Email">
            <input type="password" name="contrasena" placeholder="Contraseña"><br>
            <input type="submit" class="btn" value="Iniciar sesion">
            <a href="register.jsp" class="btn2">Registrarse</a>
        </form>
    </body>
</html>