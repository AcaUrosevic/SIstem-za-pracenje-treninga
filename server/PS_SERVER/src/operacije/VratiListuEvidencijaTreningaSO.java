/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
import model.Trener;
import model.Vezba;
import repository.db.impl.EvidencijaTreningaRepository;
import repository.db.impl.StavkaEvidencijeRepository;

/**
 *
 * @author Aca
 */
public class VratiListuEvidencijaTreningaSO extends ApstraktnaGenerickaOperacija{
    List<EvidencijaTreninga> evidencije;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        EvidencijaTreningaRepository evidencijaRepo = new EvidencijaTreningaRepository();
        evidencije = evidencijaRepo.vratiSve();
        for (EvidencijaTreninga evidencija : evidencije) {
            StavkaEvidencijeRepository stavkaRepo = new StavkaEvidencijeRepository();
            List<StavkaEvidencijeTreninga> stavke = stavkaRepo.pretraziPoEvidenciji(evidencija);
            evidencija.setStavke(stavke);
        }
    }

    public List<EvidencijaTreninga> getEvidencije() {
        return evidencije;
    }
    
    
    
}
