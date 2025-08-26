/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClanTeretane;
import model.PaketUsluga;
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

    public List<ClanTeretane> ucitajClanove() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_CLANOVE, null);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        return (List<ClanTeretane>) odgovor.getOdgovor();
    }

    public boolean obrisiPacijenta(ClanTeretane clan) {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_CLANA, clan);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        return (boolean) odgovor.getOdgovor();
    }

    public List<PaketUsluga> ucitajPakete() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_PAKETE,null);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        return (List<PaketUsluga>) odgovor.getOdgovor();
    }

    public boolean dodajClanaTeretane(ClanTeretane noviClan) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_CLANA,noviClan);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        return (boolean) odgovor.getOdgovor();
    }

    public boolean promeniClanaTeretane(ClanTeretane clan) {
        Zahtev zahtev = new Zahtev(Operacija.PROMENI_CLANA, clan);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        return (boolean) odgovor.getOdgovor();
    }
    
}
