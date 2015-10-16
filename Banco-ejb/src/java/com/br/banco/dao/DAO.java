/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.dao;

import java.util.Collection;

/**
 *
 * @author User
 */
public interface DAO<E> {
    
    public void insert(E e);
    public void update(E e);
    public void remove(E e);
    public Collection<E> read();
}
