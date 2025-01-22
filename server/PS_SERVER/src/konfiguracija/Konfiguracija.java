/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aca
 */
public class Konfiguracija {
    private static Konfiguracija instance;
    private Properties config;
    
    private Konfiguracija() {
        config = new Properties();
        try {
            config.load(new FileInputStream("D:\\cetvrta godina\\prvi semestar\\Projektovanje softvera\\PROJEKAT\\server\\config\\config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Konfiguracija getInstance(){
        if(instance == null)
            instance = new Konfiguracija();
        return instance;
    }

    public String getProperty(String key) {
        return config.getProperty(key, "N/A");
    }

    public void setProperty(String key, String value) {
        config.setProperty(key, value);
    }
    
    public void sacuvajIzmene(){
        try {
            config.store(new FileOutputStream("D:\\cetvrta godina\\prvi semestar\\Projektovanje softvera\\PROJEKAT\\server\\config\\config.properties"), null);
        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
