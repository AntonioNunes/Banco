/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31409695
 */
public class SaldoCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/contaPessoal.jsp");
    
    }
    
}
