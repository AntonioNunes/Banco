package com.br.banco.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31409695
 */
public interface Command {
    
    public void execute(HttpServletRequest request, HttpServletResponse response);
}
