/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import forme.DodajClanaForma;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazClanovaForma;
import kontroleri.DodajClanaController;
import kontroleri.GlavnaController;
import kontroleri.LoginController;
import kontroleri.PrikazClanovaController;
import model.Trener;

/**
 *
 * @author Aca
 */
public class Kordinator {
    static Kordinator instance;
    Trener ulogovani;
    LoginController loginController;
    GlavnaController glavnaController;
    PrikazClanovaController pcController;
    DodajClanaController dcController;
    
    private Kordinator(){
        
    }
    
    public static Kordinator getInstance(){
        if(instance == null)
            instance = new Kordinator();
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaController = new GlavnaController(new GlavnaForma());
        glavnaController.otvoriFormu();
    }
    
    public void otvoriPrikazClanovaFormu(){
        pcController = new PrikazClanovaController(new PrikazClanovaForma());
        pcController.otvoriFormu();
    }
    
    public void orvoriFormuDodajClana() {
         dcController = new DodajClanaController(new DodajClanaForma());
         dcController.otvoriFormu();
    }

    public Trener getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Trener ulogovani) {
        this.ulogovani = ulogovani;
    }

    
}
