package com.br.banco.controller;

import javax.ejb.Local;

/**
 *
 * @author 31440983
 */
@Local
public interface LoginManagerLocal {
    
    public boolean auth(int username,String senha);
}
