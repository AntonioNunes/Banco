/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.banco.jms.mdbs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author 31440983
 */
@MessageDriven(mappedName = "jms/banco", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConsummerMDB implements MessageListener {

    final String caminho = "C:\\Temp\\arquivobanco.txt";

    public ConsummerMDB() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;

        try {
            System.out.println(tm.getText());
            salvar(caminho,tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(ConsummerMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvar(String caminho, String conteudo) {
        File f = new File(caminho);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ConsummerMDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("[* d/M/Y -- h:m:s *]  ");
        
        String msg = df.format(c.getTime());
        msg += conteudo +"\r\n";
    
        try {
            Files.write(Paths.get(caminho), msg.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(ConsummerMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
