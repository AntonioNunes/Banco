<%-- 
    Document   : contaPessoal
    Created on : 15/10/2015, 09:22:18
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
        <header>
            <h1>Conta pessoal, ${clienteLogado.nome}.</h1>
            <input type="button" value="LogoffCommand" name="logoff" class="logoff"/>
        </header>
            <nav>
                <div class="saldo">${saldo}</div>
            
            </nav>
    </body>
</html>
