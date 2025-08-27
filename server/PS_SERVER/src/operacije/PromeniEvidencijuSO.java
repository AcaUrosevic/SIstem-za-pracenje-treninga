/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
import model.Vezba;

/**
 *
 * @author Aca
 */
public class PromeniEvidencijuSO extends ApstraktnaGenerickaOperacija{
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        EvidencijaTreninga e = (EvidencijaTreninga) obj;
        
        broker.edit(e);
        
        List<StavkaEvidencijeTreninga> stare =
            broker.getAll(new StavkaEvidencijeTreninga(), 
                                     " JOIN " +new Vezba().vratiNazivTabele() + " on vezba = idVezba" +
                                     " JOIN " + e.vratiNazivTabele() + " on evidencija = idEvidencijaTreninga" +
                                     " WHERE evidencija = " + e.getIdEvidencija());
        for (StavkaEvidencijeTreninga s : stare) {
            broker.delete(s);
        }
        
        if (e.getStavke() != null && !e.getStavke().isEmpty()) {
            int rb = 1;
            for (StavkaEvidencijeTreninga s : e.getStavke()) {
                s.setEvidencijaTreninga(e);
                s.setRb(rb++);
                broker.add(s);
            }
        }
    }
    
}
