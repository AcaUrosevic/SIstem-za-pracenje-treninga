/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
import model.Vezba;
import repository.db.impl.EvidencijaTreningaRepository;
import repository.db.impl.StavkaEvidencijeRepository;

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
        EvidencijaTreningaRepository evidencijaRepo = new EvidencijaTreningaRepository();
        lista = evidencijaRepo.pretraziPoVezbi(v);
        StavkaEvidencijeRepository stavkaRepo = new StavkaEvidencijeRepository();
        for (EvidencijaTreninga evidencija : lista) {
            List<StavkaEvidencijeTreninga> stavke = stavkaRepo.pretraziPoEvidenciji(evidencija);
            evidencija.setStavke(stavke);
        }
    }

    public List<EvidencijaTreninga> getLista() {
        return lista;
    }
    
    
}
