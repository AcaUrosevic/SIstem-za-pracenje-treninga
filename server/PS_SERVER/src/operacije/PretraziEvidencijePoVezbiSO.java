/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
import model.Vezba;

/**
 *
 * @author Aca
 */
public class PretraziEvidencijePoVezbiSO extends ApstraktnaGenerickaOperacija{
    List<EvidencijaTreninga> lista;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        Vezba v = (Vezba) obj;
        lista = broker.getAll(new EvidencijaTreninga(),
            " JOIN trener ON evidencija_treninga.trener = trener.idTrener" +
            " JOIN clan_teretane ON evidencija_treninga.clanTeretane = clan_teretane.idClanTeretane" +
            " JOIN stavka_evidencije_treninga s ON s.evidencija = evidencija_treninga.idEvidencijaTreninga" +
            " JOIN vezba ON s.vezba = vezba.idVezba" +
            " WHERE vezba.idVezba = " + v.getIdVezba()
        );
        
        for (EvidencijaTreninga evidencija : lista) {
            List<StavkaEvidencijeTreninga> stavke = broker.getAll(new StavkaEvidencijeTreninga(),
                                                " JOIN " +new Vezba().vratiNazivTabele() + " on vezba = idVezba" +
                                                " JOIN " + evidencija.vratiNazivTabele() + " on evidencija = idEvidencijaTreninga" + 
                                                " WHERE " + "evidencija = " + evidencija.getIdEvidencija());
            evidencija.setStavke(stavke);
        }
    }

    public List<EvidencijaTreninga> getLista() {
        return lista;
    }
    
    
}
