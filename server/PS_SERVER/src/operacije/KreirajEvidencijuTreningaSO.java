/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import model.EvidencijaTreninga;

/**
 *
 * @author Aca
 */
public class KreirajEvidencijuTreningaSO extends ApstraktnaGenerickaOperacija{
    int idKreirana;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        idKreirana = broker.addAndReturnId((EvidencijaTreninga)obj);
    }

    public int getIdKreirana() {
        return idKreirana;
    }
    
    
}
