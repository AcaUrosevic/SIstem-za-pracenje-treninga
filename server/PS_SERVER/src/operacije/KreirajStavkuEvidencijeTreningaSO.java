/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import model.StavkaEvidencijeTreninga;

/**
 *
 * @author Aca
 */
public class KreirajStavkuEvidencijeTreningaSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        broker.add((StavkaEvidencijeTreninga)obj);
    }
    
}
