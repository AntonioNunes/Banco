/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.command;

import com.br.banco.controller.LoginManagerLocal;
import com.br.banco.dao.ClienteDAO;
import com.br.banco.entities.Cliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    LoginManagerLocal loginManager = lookupLoginManagerLocal();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int nroConta = Integer.parseInt(request.getParameter("nro_conta"));
        String senha = request.getParameter("senha");
        String usuario = request.getParameter("usuario");
        
        boolean verifica = loginManager.auth(nroConta, senha);
        
        if (verifica) {
            Cliente cliente = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            cliente = dao.readById(nroConta);
            
            request.getSession().setAttribute("clienteLogado", cliente);
            
            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
            
            request.getSession().setAttribute("username", usuario);
            
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            RequestDispatcher rd1 = request.getRequestDispatcher("/index.jsp");
            try {
                rd1.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private LoginManagerLocal lookupLoginManagerLocal() {
        try {
            Context c = new InitialContext();
            return (LoginManagerLocal) c.lookup("java:global/Banco/Banco-ejb/LoginManager!com.br.banco.controller.LoginManagerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
