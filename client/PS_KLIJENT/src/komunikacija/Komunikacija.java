/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Trener;

/**
 *
 * @author Aca
 */
public class Komunikacija {
    static Komunikacija instance;
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    
    private Komunikacija(){
        
    }
    
    public static Komunikacija getInstance(){
        if(instance == null)
            instance = new Komunikacija();
        return instance;
    }
    
    public void konekcija(){
        try {
            socket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Trener login(String username, String password) {
        Trener trener = new Trener(username, password);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, trener);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        trener  = (Trener) odgovor.getOdgovor();
        return trener;
    }
    
}
