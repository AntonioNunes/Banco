<%-- 
    Document   : index
    Created on : 28/09/2015, 08:05:05
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
        <h1>Banco</h1>
        <section>
            <h3>Login</h3>

            <form action="FrontController" method="POST">
                <input type="hidden" name="command" value="LoginCommand"/>
                <p>Número da conta:<br><input type="text" name="nro_conta" required/>*</p>
                <p>Senha:<br><input type="password" name="senha" required/>*</p>
                <p><input type="submit" value="Login"</p>
                
            </form>
        </section>
    </body>
</html>
