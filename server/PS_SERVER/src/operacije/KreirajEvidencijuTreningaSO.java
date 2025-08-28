/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.time.LocalDate;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;

/**
 *
 * @author Aca
 */
public class KreirajEvidencijuTreningaSO extends ApstraktnaGenerickaOperacija{
    int idKreirana;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
        EvidencijaTreninga e = (EvidencijaTreninga) obj;
        Exception exception = new Exception();
        if(e.getDatumTreninga() == null ||  e.getDatumTreninga().isAfter(LocalDate.now()))
                throw exception;
        
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        EvidencijaTreninga e = (EvidencijaTreninga) obj;
        int id = broker.addAndReturnId(e);
        e.setIdEvidencija(id);
        
        if(e.getStavke() != null && !e.getStavke().isEmpty()){
            int rb = 1;
            for (StavkaEvidencijeTreninga stavka : e.getStavke()) {
                stavka.setEvidencijaTreninga(e);
                stavka.setRb(rb++);
                broker.add(stavka);
            }
        }
        idKreirana = id;
    }

    public int getIdKreirana() {
        return idKreirana;
    }
    
    
}
