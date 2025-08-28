/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import forme.DodajClanaForma;
import forme.DodajEvidencijuForma;
import forme.DodajSertifikatForma;
import forme.DodajStavkuForma;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazClanovaForma;
import forme.PrikazEvidencijaForma;
import forme.PrikazSertifikataForma;
import java.util.ArrayList;
import java.util.List;
import kontroleri.DodajClanaController;
import kontroleri.DodajEvidencijuController;
import kontroleri.DodajSertifikatController;
import kontroleri.DodajStavkuController;
import kontroleri.GlavnaController;
import kontroleri.LoginController;
import kontroleri.PrikazClanovaController;
import kontroleri.PrikazEvidencijaController;
import kontroleri.PrikazSertifikataController;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
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
    PrikazEvidencijaController peController;
    DodajEvidencijuController deController;
    DodajStavkuController dsController;
    PrikazSertifikataController psController;
    DodajSertifikatController dSertifikatController;
    
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
         dcController = new DodajClanaController(new DodajClanaForma(),null);
         dcController.otvoriFormu();
    }
    
      public void otvoriIzmenaFormu(ClanTeretane clanZaIzmenu) {
          dcController = new DodajClanaController(new DodajClanaForma(), clanZaIzmenu);
          dcController.otvoriFormuIzmena();
      }
      
       public void otvoriPrikazEvidencijaFormu() {
        peController = new PrikazEvidencijaController(new PrikazEvidencijaForma());
        peController.otvoriFormu();
    }

    public void otvoriFormuDodajEvidenciju() {
        deController = new DodajEvidencijuController(new DodajEvidencijuForma(), null, new ArrayList<StavkaEvidencijeTreninga>());
        deController.otvoriFormu();
    }
    
     public void otvoriFormuDodajStavku() {
        dsController = new DodajStavkuController(new DodajStavkuForma());
        dsController.otvoriFormu();
    }

     public void otvoriFormuIzmenaEvidencije(EvidencijaTreninga evidencija, List<StavkaEvidencijeTreninga> stavke) {
        deController = new DodajEvidencijuController(new DodajEvidencijuForma(), evidencija, stavke);
        deController.otvoriFormuIzmena();
     }
    

    public Trener getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Trener ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    public void osveziTabeluClanovi(){
        pcController.ucitajTabelu();
    }

    public boolean dodajStavku(StavkaEvidencijeTreninga stavka) {
        return deController.dodajStavku(stavka);
    }

    public void osveziTabeluEvidencija() {
        peController.ucitajTabeluEvidencija();
    }

    public void osveziTabeluStavkiPrikaz() {
        peController.osveziTabeluStavki(new ArrayList<>());
    }

    public void osveziTabeluSertifikati() {
        psController.ucitajTabeluSertifikata();
    }

    public void otvoriFormuPrikazSertifikata() {
        psController = new PrikazSertifikataController(new PrikazSertifikataForma());
        psController.otvoriFormu();
    }

    public void otvoriFOrmuDodajSertifikat() {
        dSertifikatController = new DodajSertifikatController(new DodajSertifikatForma());
        dSertifikatController.otvoriFormu();
    }

   

   

   
}
