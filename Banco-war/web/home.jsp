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
            <li><a href="contaPessoal.jsp"><input type="button" value="SaldoCommand" name="saldo" class="saldo"/></a></li>
            <li><input type="button" value="SaqueCommand" name="saque" class="saque"/></li>
            <li><input type="button" value="TransferenciaCommand" name="trans" class="trans"/></li>
            <li><input type="button" value="LogoffCommand" name="logoff" class="logoff"/></li>
        </ul>
    </body>
</html>
