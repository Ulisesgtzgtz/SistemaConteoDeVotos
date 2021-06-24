<%-- 
    Document   : Consulta_Votos
    Created on : 23/06/2021, 02:24:35 PM
    Author     : lenov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PODC</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css">
        <link href="CSS/CSS2.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav>
        <ul>
        <li>
            <a href=Logout>Cerrar sesion</a>
        </li>
        <li style=float:left>
            <a href="http://localhost:8080/SistemaConteoDeVotos/Registro_Consulta.jsp"><img src="IMAGENES/logo.png" alt="Logo PREP" width="30" height="30"></a>
        <li>
        </ul>
        </nav>
        <hr size="2px" width="90%" noshade="noshade" align="center">
        <h1 class="titulo">Consultas</h1>
        <img src="IMAGENES/logo.png" alt="Logo PREP" width="300" height="300">
        <div class="inicio">
            <div class="inicio2">
        <a href="http://localhost:8080/SistemaConteoDeVotos/ConsultaPresidente" class = 'btn'>Presidente</a>
        <a href="http://localhost:8080/SistemaConteoDeVotos/ConsultaDiputados"class = 'btn'>Diputado</a>
            </div>
        </div>
    </body>
</html>
