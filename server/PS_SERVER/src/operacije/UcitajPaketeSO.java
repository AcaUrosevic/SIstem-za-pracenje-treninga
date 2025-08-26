/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.PaketUsluga;

/**
 *
 * @author Aca
 */
public class UcitajPaketeSO extends ApstraktnaGenerickaOperacija{
    List<PaketUsluga> paketi;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        paketi = broker.getAll((PaketUsluga)obj, kljuc);
    }

    public List<PaketUsluga> getPaketi() {
        return paketi;
    }
    
    
}
