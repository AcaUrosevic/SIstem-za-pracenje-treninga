/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.util.List;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
import model.Vezba;

/**
 *
 * @author Aca
 */
public class StavkaEvidencijeRepository extends DbRepositoryGeneric{
    
    @SuppressWarnings("unchecked")
    public List<StavkaEvidencijeTreninga> pretraziPoEvidenciji(EvidencijaTreninga evidencija) throws Exception {
        List<?> tmp = getAll(new StavkaEvidencijeTreninga(), " JOIN " +new Vezba().vratiNazivTabele() + " on vezba = idVezba" +
                                                " JOIN " + evidencija.vratiNazivTabele() + " on evidencija = idEvidencijaTreninga" + 
                                                " WHERE " + "evidencija = " + evidencija.getIdEvidencija());
        return (List<StavkaEvidencijeTreninga>)(List<?>) tmp;
    }
}
