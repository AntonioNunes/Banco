/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoffCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        request.getSession().invalidate();
       
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LogoffCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LogoffCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
