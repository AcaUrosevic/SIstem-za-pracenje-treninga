/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.PaketUsluga;
import model.StavkaEvidencijeTreninga;
import model.Trener;
import model.Vezba;
import operacije.KreirajClanaTeretaneSO;
import operacije.KreirajEvidencijuTreningaSO;
import operacije.KreirajStavkuEvidencijeTreningaSO;
import operacije.LoginOperacija;
import operacije.ObrisiClanaTeretaneSO;
import operacije.PromeniClanaTeretaneSO;
import operacije.UcitajClanoveSO;
import operacije.UcitajPaketeSO;
import operacije.VratiListuEvidencijaTreningaSO;
import operacije.VratiListuTreneraSO;
import operacije.VratiListuVezbiSO;

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
        UcitajClanoveSO operacija = new UcitajClanoveSO();
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

    public List<PaketUsluga> vratiListuPaketa() throws Exception {
        UcitajPaketeSO operacija = new UcitajPaketeSO();
        operacija.izvrsi(new PaketUsluga(), "");
        return operacija.getPaketi();
    }

    public boolean kreirajClanaTeretane(ClanTeretane clanTeretane) {
        KreirajClanaTeretaneSO operacija = new KreirajClanaTeretaneSO();
        try {
            operacija.izvrsi(clanTeretane, "");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean promeniClanaTeretane(ClanTeretane clanTeretane) {
        PromeniClanaTeretaneSO operacija = new PromeniClanaTeretaneSO();
        try {
            operacija.izvrsi(clanTeretane, "");
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<EvidencijaTreninga> vratiListuEvidencija() throws Exception {
        VratiListuEvidencijaTreningaSO operacija = new VratiListuEvidencijaTreningaSO();
        operacija.izvrsi(new EvidencijaTreninga(), "");
        return operacija.getEvidencije();
    }

    public List<Trener> vratiListuTrenera() throws Exception {
        VratiListuTreneraSO operacija = new VratiListuTreneraSO();
        operacija.izvrsi(new Trener(), "");
        return operacija.getTreneri();
    }

    public List<Vezba> vratiListuVezbi() throws Exception {
        VratiListuVezbiSO operacija = new VratiListuVezbiSO();
        operacija.izvrsi(new Vezba(), "");
        return operacija.getVezbe();
    }

    public int kreirajEvidencijuTreninga(EvidencijaTreninga evidencijaTreninga) throws Exception {
        KreirajEvidencijuTreningaSO operacija = new KreirajEvidencijuTreningaSO();
        operacija.izvrsi(evidencijaTreninga, "");
        return operacija.getIdKreirana();
    }

    public boolean kreirajStavku(StavkaEvidencijeTreninga parametar) {
        KreirajStavkuEvidencijeTreningaSO operacija = new KreirajStavkuEvidencijeTreningaSO();
        try {
            operacija.izvrsi(parametar, "");
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
