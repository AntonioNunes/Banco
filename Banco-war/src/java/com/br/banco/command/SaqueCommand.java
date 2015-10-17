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
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaqueCommand implements Command {
    ProducerSessionbeanLocal producerSessionbean = lookupProducerSessionbeanLocal();

    
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int nroConta = Integer.parseInt(request.getParameter("nro_conta"));

        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.readById(nroConta);

        double saque = Double.parseDouble(request.getParameter("qtd_saldo"));

        if (cliente.getSaldo() < saque) {

        } else if (saque < 0.0) {
        } else {
            cliente.setSaldo(cliente.getSaldo() - saque);
            dao.update(cliente);
            //dao.updateSaldo(cliente);
            request.getSession().setAttribute("clienteLogado", cliente);
            producerSessionbean.log("Usuário "+cliente.getNome()+" sacou "+ saque + "0 com sucesso");
            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(SaqueCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SaqueCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
