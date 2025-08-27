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
public class VratiListuStavkiSO extends ApstraktnaGenerickaOperacija{
    List<StavkaEvidencijeTreninga> stavke;
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        EvidencijaTreninga evidencija = (EvidencijaTreninga)obj;
        
        stavke = broker.getAll(new StavkaEvidencijeTreninga(),
                                                " JOIN " +new Vezba().vratiNazivTabele() + " on vezba = idVezba" +
                                                " JOIN " + evidencija.vratiNazivTabele() + " on evidencija = idEvidencijaTreninga" + 
                                                " WHERE " + "evidencija = " + evidencija.getIdEvidencija());
    }

    public List<StavkaEvidencijeTreninga> getStavke() {
        return stavke;
    }

    
    
    
}
