/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.PaketUsluga;
import model.Sertifikat;
import model.StavkaEvidencijeTreninga;
import model.Trener;
import model.TrenerSertifikat;
import model.Vezba;

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
            try {
                Zahtev zahtev = (Zahtev)primalac.primi();
                Odgovor odgovor = new Odgovor();
                if (zahtev == null) {
                    prekini();
                    return;
                }
                
                switch (zahtev.getOperacija()) {
                    case Operacija.LOGIN:
                        Trener trener = (Trener) zahtev.getParametar();
                        trener = Controller.getInstance().login(trener);
                        odgovor.setOdgovor(trener);
                        break;
                    case Operacija.UCITAJ_CLANOVE:
                        List<ClanTeretane> clanovi = Controller.getInstance().vratiListuClanova();
                        odgovor.setOdgovor(clanovi);
                        break;
                    case Operacija.OBRISI_CLANA:
                        boolean obrisan = Controller.getInstance().obrisiClanaTeretane((ClanTeretane)zahtev.getParametar());
                        odgovor.setOdgovor(obrisan);
                        break;
                    case Operacija.UCITAJ_PAKETE:
                        List<PaketUsluga> paketi = Controller.getInstance().vratiListuPaketa();
                        odgovor.setOdgovor(paketi);
                        break;
                    case Operacija.DODAJ_CLANA:
                        odgovor.setOdgovor(false);
                        odgovor.setOdgovor(Controller.getInstance().kreirajClanaTeretane((ClanTeretane)zahtev.getParametar()));
                        break;
                    case Operacija.PROMENI_CLANA:
                        odgovor.setOdgovor(false);
                        odgovor.setOdgovor(Controller.getInstance().promeniClanaTeretane((ClanTeretane)zahtev.getParametar()));
                        break;
                    case Operacija.VRATI_EVIDENCIJE:
                        List<EvidencijaTreninga> evidencije = Controller.getInstance().vratiListuEvidencija();
                        odgovor.setOdgovor(evidencije);
                        break;
                    case Operacija.UCITAJ_TRENERE:
                        List<Trener> treneri = Controller.getInstance().vratiListuTrenera();
                        odgovor.setOdgovor(treneri);
                        break;
                    case Operacija.VRATI_VEZBE:
                        List<Vezba> vezbe = Controller.getInstance().vratiListuVezbi();
                        odgovor.setOdgovor(vezbe);
                        break;
                    case Operacija.KREIRAJ_EVIDENCIJU:
                        int idKreiraneEvidencije = Controller.getInstance().kreirajEvidencijuTreninga((EvidencijaTreninga)zahtev.getParametar());
                        odgovor.setOdgovor(idKreiraneEvidencije);
                        break;
                    case Operacija.PROMENI_EVIDENCIJU:
                        odgovor.setOdgovor(false);
                        boolean promenjena = Controller.getInstance().promeniEvidenciju((EvidencijaTreninga) zahtev.getParametar());
                        odgovor.setOdgovor(promenjena);
                        break;
                        case Operacija.PRETRAZI_EVIDENCIJE_PO_VEZBI:
                            Vezba v = (Vezba) zahtev.getParametar();
                            List<EvidencijaTreninga> lst = Controller.getInstance().pretraziEvidencijePoVezbi(v);
                            odgovor.setOdgovor(lst);
                            break;
                        case Operacija.UCITAJ_SERTIFIKATE:
                            List<TrenerSertifikat> sertifikati = Controller.getInstance().vratiListuSertifikata((Trener)zahtev.getParametar());
                            odgovor.setOdgovor(sertifikati);
                            break;
                        case Operacija.UBACI_SERTIFIKAT:
                            odgovor.setOdgovor(false);
                            boolean ubacen = Controller.getInstance().ubaciSertifikat((TrenerSertifikat)zahtev.getParametar());
                            odgovor.setOdgovor(ubacen);
                            break;
                    default:
                        System.out.println("greska, losa operacija u zahtevu");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                if(kraj) return;
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    public void prekini() {
        kraj = true;
        try {
            socket.close();
        } catch (IOException ex) {
        }
        interrupt();
    }
    
}
