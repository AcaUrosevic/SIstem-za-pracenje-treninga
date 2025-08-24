/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClanTeretane;
import model.Trener;
import operacije.LoginOperacija;
import operacije.ObrisiClanaTeretaneSO;
import operacije.UcitajClanoveOperacija;

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
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(trener, null);
        return operacija.getTrener();
    }

    public List<ClanTeretane> vratiListuClanova() throws Exception {
        UcitajClanoveOperacija operacija = new UcitajClanoveOperacija();
        operacija.izvrsi(new ClanTeretane(), "");
        return operacija.getClanovi();
    }

    public boolean obrisiClanaTeretane(ClanTeretane clanTeretane) {
        ObrisiClanaTeretaneSO operacija = new ObrisiClanaTeretaneSO();
        try {
            operacija.izvrsi(clanTeretane, "");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
