/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author Aca
 */
public class ObradaKlijentskihZahteva extends Thread{
    Socket socket;
    Primalac primalac;
    Posiljalac posiljalac;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        this.primalac = new Primalac(socket);
        this.posiljalac = new Posiljalac(socket);
    }

    
    
    @Override
    public void run() {
        while(!kraj){
            Zahtev zahtev = (Zahtev)primalac.primi();
            Odgovor odgovor = new Odgovor();
            
            switch (zahtev.getOperacija()) {
                default:
                    System.out.println("greska, losa operacija u zahtevu");
            }
            posiljalac.posalji(odgovor);
        }
    }
    
    public void prekini() {
        kraj = true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();
    }
    
}
