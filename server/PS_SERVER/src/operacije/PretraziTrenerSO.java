/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.Trener;
import repository.db.impl.TrenerRepository;

/**
 *
 * @author Aca
 */
public class PretraziTrenerSO extends ApstraktnaGenerickaOperacija{

        List<Trener> treneri;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        Trener t = (Trener) obj;
        TrenerRepository repo = new TrenerRepository();
        treneri = repo.pretraziPoImenu(t);
    }

    public List<Trener> getTreneri() {
        return treneri;
    }
    
}
