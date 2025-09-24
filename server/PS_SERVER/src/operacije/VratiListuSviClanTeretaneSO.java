/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.ClanTeretane;
import model.PaketUsluga;
import repository.db.impl.ClanTeretaneRepository;

/**
 *
 * @author Aca
 */
public class VratiListuSviClanTeretaneSO extends ApstraktnaGenerickaOperacija{
    List<ClanTeretane> clanovi;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        ClanTeretaneRepository repo = new ClanTeretaneRepository();
        clanovi = repo.vratiSve();
    }

    public List<ClanTeretane> getClanovi() {
        return clanovi;
    }

}
