/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaqueCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       
        double Saldo = Double.parseDouble(request.getParameter("qtd_saldo"));
       
        
    }
    
}
