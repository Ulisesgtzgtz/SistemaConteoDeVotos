<%-- 
    Document   : Candidatos
    Created on : 16/06/2021, 11:08:57 PM
    Author     : lenov
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Presidente Registro</title>
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
        <h1>Presidentes</h1>
        <form action = 'http://localhost:8080/SistemaConteoDeVotos/ConteoVotos' method = 'post'>
            <table border = "1">
                <tr>
                <td>ID de Casilla
                <td><input type = 'text' name = 'CASILLA'>
    </table>
               <br>
               <br>
            <table border = "2">
            <tr>
            <th>Presidentes
            <th>Votos
            <tr>
            <td>PAN
            <td><input type = 'text' name = 'PAN'>
            </tr>
            <tr>
            <td>PRI
            <td><input type = 'text' name = 'PRI'>
            </tr>
            <tr>
            <td>PRD
            <td><input type = 'text' name = 'PRD'>
            </tr>
            <tr>
            <td>HAGAMOS
            <td><input type = 'text' name = 'HAGAMOS'>
            </tr>
            <tr>
            <td>PT
            <td><input type = 'text' name = 'PT'>
            </tr>
            <tr>
            <td>MORENA
            <td><input type = 'text' name = 'MORENA'>
            </tr>
            <tr>
            <td>SOMOS
            <td><input type = 'text' name = 'SOMOS'>
            </tr>
            <tr>
            <td>FUERZAMEXICO
            <td><input type = 'text' name = 'FUERZAMEXICO'>
            </tr>
            <tr>
            <td>FUTURO
            <td><input type = 'text' name = 'FUTURO'>
            </tr>
            <tr>
            <td>MOVIMIENTO CIUDADANO
            <td><input type = 'text' name = 'MC'>
            </tr>
            <tr>
            <td>RSP
            <td><input type = 'text' name = 'RSP'>
            </tr>
            <tr>
            <td>PES
            <td><input type = 'text' name = 'PES'>
            </tr>
            <tr>
            <td>PV
            <td><input type = 'text' name = 'PV'>
            </tr>
            </table>
            <input type = 'submit' class ='btn' value = 'Enviar'>
        </form>
    </body>
</html>
