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

    <a href="contaPessoal.jsp"><input type="button" value="SaldoCommand" name="Command" class="saldo"/></a>
            
        <a href="SaquePessoal.jsp"><input type="button" value="Saque" name="SaqueCommand" class="saque"/></a>
        <a href="transferencia.jsp"><input type="button" value="Transferencia" name="TransferenciaCommand" class="trans"/></a>

        <form method="POST" action="FrontController">

            <input type="submit" value="Logoff" name="LogoffCommand" />
            <input type="hidden" name="command" value="LogoffCommand"/>

        </form>
    </body>
</html>
