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
public class LoginOperacija extends ApstraktnaGenerickaOperacija{
    Trener trener;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception{
        List<Trener> sviTreneri = broker.getAll((Trener) obj, kljuc);
        for (Trener t : sviTreneri) {
            if(t.equals((Trener) obj)){
                trener = t;
                return;
            }
        }
        trener = null;
    }

    public Trener getTrener() {
        return trener;
    }
}
