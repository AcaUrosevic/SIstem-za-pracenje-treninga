/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.Vezba;

/**
 *
 * @author Aca
 */
public class VratiListuVezbiSO extends ApstraktnaGenerickaOperacija{

    public List<Vezba> getVezbe() {
        return vezbe;
    }
    List<Vezba> vezbe;

    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        vezbe = broker.getAll((Vezba)obj, "");
    }
    
    
}
