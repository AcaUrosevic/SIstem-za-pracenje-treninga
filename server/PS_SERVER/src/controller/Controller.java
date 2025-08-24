/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Trener;
import operacije.LoginOperacija;

/**
 *
 * @author Aca
 */
public class Controller {
    static Controller instance;
    
    private Controller(){
        
    }
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public Trener login(Trener trener) throws Exception {
        LoginOperacija lo = new LoginOperacija();
        lo.izvrsi(trener, null);
        return lo.getTrener();
    }
}
