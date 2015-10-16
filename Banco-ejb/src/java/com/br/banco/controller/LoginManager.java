package com.br.banco.controller;

import com.br.banco.dao.ClienteDAO;
import com.br.banco.entities.Cliente;
import com.br.banco.jms.sessionbeans.ProducerSessionbeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.JMSException;

/**
 *
 * @author 31440983
 */
@Stateless
public class LoginManager implements LoginManagerLocal {

    @EJB
    private ProducerSessionbeanLocal producerSessionbean;

    @Override
    public boolean auth(int nro_conta, String senha) {
        
        boolean resposta = false;

        ClienteDAO dao = new ClienteDAO();
        Cliente c = new Cliente(nro_conta, senha);
        Cliente encontrado = dao.readById(nro_conta);

        if (encontrado != null && encontrado.getSenha().equals(c.getSenha())) {
            resposta = true;
        }

        
        if (resposta) {
            try {
                producerSessionbean.sendMessageToQueue("Usuario " + nro_conta + " Logado");
            } catch (JMSException ex) {
                Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                producerSessionbean.sendMessageToQueue("Errou no login");
            } catch (JMSException ex) {
                Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resposta;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
