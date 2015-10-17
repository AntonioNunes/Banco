/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.command;

import com.br.banco.dao.ClienteDAO;
import com.br.banco.entities.Cliente;
import com.br.banco.jms.sessionbeans.ProducerSessionbeanLocal;
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

/**
 *
 * @author 31409695
 */
public class SaldoCommand implements Command {
    ProducerSessionbeanLocal producerSessionbean = lookupProducerSessionbeanLocal();

    
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
         int nroConta = Integer.parseInt(request.getParameter("nro_conta"));

        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.readById(nroConta);
        
        request.getSession().setAttribute("clienteLogado", cliente);
        
        producerSessionbean.log("Usuario "+ cliente+ " verificou saldo");
        
        System.out.println("passei por aqui");
    }

    private ProducerSessionbeanLocal lookupProducerSessionbeanLocal() {
        try {
            Context c = new InitialContext();
            return (ProducerSessionbeanLocal) c.lookup("java:global/Banco/Banco-ejb/ProducerSessionbean!com.br.banco.jms.sessionbeans.ProducerSessionbeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

  
    
}
