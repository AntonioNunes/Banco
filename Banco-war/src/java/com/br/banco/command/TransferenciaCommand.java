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

public class TransferenciaCommand implements Command {

    ProducerSessionbeanLocal producerSessionbean = lookupProducerSessionbeanLocal();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        
        
        int nroConta = Integer.parseInt(request.getParameter("nro_conta"));
        int nro_trans = Integer.parseInt(request.getParameter("nro_trans"));
        double trans = Double.parseDouble(request.getParameter("qtd_trans"));

        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.readById(nroConta);

        Cliente c2 = new Cliente();
        c2 = dao.readById(nro_trans);

        if (dao.readById(nro_trans) == null) {
        } else if (cliente.getSaldo() < trans) {
        } else if (trans < 0.0) {
        } else {
            cliente.setSaldo(cliente.getSaldo() - trans);
            c2.setSaldo(c2.getSaldo() + trans);
            dao.update(cliente);
            dao.update(c2);

            request.getSession().setAttribute("clienteLogado", cliente);
            producerSessionbean.log("Usuário " + cliente.getNome() + " transferiu " + trans + " para o usuário " + c2.getNome() + " com sucesso.");

            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
            
            try {
                rd.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(TransferenciaCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TransferenciaCommand.class.getName()).log(Level.SEVERE, null, ex);
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
