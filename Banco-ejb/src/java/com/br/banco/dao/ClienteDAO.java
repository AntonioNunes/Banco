package com.br.banco.dao;


import com.br.banco.entity.Cliente;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 31409695
 */
public class ClienteDAO {
    private List<Cliente> clientes;
    
    public ClienteDAO() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente(2, "Antonio", "123", 1000));
    }
    
    public Cliente readById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getNroConta() == id) {
                return cliente;
            }
        }
        return null;
    }
    
    public List<Cliente> read() {
        return clientes;
    }
}
