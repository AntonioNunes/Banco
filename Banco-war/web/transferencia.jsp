<%-- 
    Document   : transferencia
    Created on : 17/10/2015, 13:16:32
    Author     : User
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
                <input type="submit" value="Logoff Command" />

            </form>
        </header>
            
            <section>

            <form method="POST" action="FrontController">
                <input type="hidden" name="command" value="TransferenciaCommand"/>
                
                <p>Numero da conta á ser transferida:<br><input type="text" name="nro_trans" required/>*</p> 
                <p>Quantidade a ser transferida:<br><input type="text" name="qtd_trans" required/>*</p> 
                
                <input type="hidden" name="nro_conta" value="${clienteLogado.nroConta}"/>
                <p><input type="submit" value="Transferir"</p> 
            </form>

        </section>
        <a href="home.jsp"><input type="button" value="Voltar"/></a>
    </body>
</html>
