/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aca
 */
public class Posiljalac {
    Socket socket;
    ObjectOutputStream oos;

    public Posiljalac(Socket socket) {
        this.socket = socket;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Posiljalac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void posalji(Object obj){
        try {
            oos.reset();
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
