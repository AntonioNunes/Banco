package com.br.banco.dao;

import com.br.banco.entities.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31409695
 */
public class ClienteDAO implements DAO<Cliente> {

    public Cliente readById(int nro_conta) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco-ejbPU");
        EntityManager em = emf.createEntityManager();
        
        Cliente cliente = em.find(Cliente.class, nro_conta);        
        
        return cliente;
    }

    public List<Cliente> read() {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco-ejbPU");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT e From cliente e");
        
        List<Cliente> clientes = query.getResultList();
        
        em.close();
        
        return clientes;
    }

    @Override
    public void insert(Cliente e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco-ejbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Cliente e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco-ejbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Cliente e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco-ejbPU");
        EntityManager em = emf.createEntityManager();
        Cliente c = em.find(Cliente.class, e.getNroConta());
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();

    }
}
