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
            
            <form method="POST" action="FrontController">
            <input type="hidden" name="command" value="LogoffCommand"/>
            <input type="hidden" name="nro_conta" value="${clienteLogado.nroConta}"/>
            <input type="submit" value="Logoff Command" />
            
            </form>
        </header>
            <nav>
                <div class="saldo">R$ ${clienteLogado.saldo}0</div>
            
            </nav>
                <a href="home.jsp"><input type="button" value="Voltar"/></a>
    </body>
</html>
