/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.command;

import com.br.banco.dao.ClienteDAO;
import com.br.banco.entities.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaqueCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

       int nroConta = Integer.parseInt(request.getParameter("nro_conta"));
       
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.readById(nroConta);
        
        
        double saque = Double.parseDouble(request.getParameter("qtd_saldo"));

        if(cliente.getSaldo()<saque){}
    }

}
