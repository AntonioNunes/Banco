<%-- 
    Document   : SaquePessoal
    Created on : 15/10/2015, 13:02:31
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
                <input type="submit" value="Logoff Command" />

            </form>
        </header>
        <section>

            <form method="POST" action="FrontController">
                s<input type="hidden" name="command" value="SaqueCommand"/>
                <p>Quantidade a ser sacada:<br><input type="text" name="qtd_saldo" required/>*</p>  
                <p><input type="submit" value="Sacar"</p> 
            </form>

        </section>
        <a href="home.jsp"><input type="button" value="Voltar"/></a>

    </body>
</html>
