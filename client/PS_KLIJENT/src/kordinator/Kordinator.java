/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import forme.LoginForma;
import kontroleri.LoginController;

/**
 *
 * @author Aca
 */
public class Kordinator {
    static Kordinator instance;
    LoginController loginController;
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
}
