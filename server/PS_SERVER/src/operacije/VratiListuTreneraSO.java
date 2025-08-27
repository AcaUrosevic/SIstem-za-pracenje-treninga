/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.Trener;

/**
 *
 * @author Aca
 */
public class VratiListuTreneraSO extends ApstraktnaGenerickaOperacija{
    List<Trener> treneri;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        treneri = broker.getAll((Trener) obj, "");
    }

    public List<Trener> getTreneri() {
        return treneri;
    }
}
