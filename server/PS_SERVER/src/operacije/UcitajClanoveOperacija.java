/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.ClanTeretane;

/**
 *
 * @author Aca
 */
public class UcitajClanoveOperacija extends ApstraktnaGenerickaOperacija{
    List<ClanTeretane> clanovi;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        clanovi = broker.getAll((ClanTeretane)obj, kljuc);
    }

    public List<ClanTeretane> getClanovi() {
        return clanovi;
    }

}
