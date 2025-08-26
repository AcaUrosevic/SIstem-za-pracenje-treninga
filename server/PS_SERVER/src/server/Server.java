/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author Aca
 */
public class Server extends Thread{
    boolean kraj = false;
    ServerSocket serverSocket;
    List<ObradaKlijentskihZahteva> klijenti;
    
    public Server(){
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        try{
            serverSocket = new ServerSocket(9000);
            while(!kraj){
                Socket s = serverSocket.accept();
                System.out.println("Klijent je povezan");
            
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                klijenti.add(okz);
                okz.start();
            }
        } catch (IOException ex){
            if(kraj == true) return;
            ex.printStackTrace();
        } 
    }
    
    public void zaustaviServer(){
        kraj = true;
        try {
            for (ObradaKlijentskihZahteva klijent : klijenti) {
                klijent.prekini();
            }
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
