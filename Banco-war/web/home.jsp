<%-- 
    Document   : home
    Created on : 28/09/2015, 09:55:18
    Author     : 31440983
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bem-vindo ${clienteLogado.nome}</h1>
        <ul>
            <li><input type="button" value="Saldo" name="saldo" class="saldo"/></li>
            <li><input type="button" value="Saque" name="saque" class="saque"/></li>
            <li><input type="button" value="Transferencia" name="trans" class="trans"/></li>
            <li><input type="button" value="Logoff" name="logoff" class="logoff"/></li>
        </ul>
    </body>
</html>
