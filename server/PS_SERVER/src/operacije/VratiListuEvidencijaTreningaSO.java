/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.Trener;

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
        String clanTabela = new ClanTeretane().vratiNazivTabele();
        String evidencijaTabela = new EvidencijaTreninga().vratiNazivTabele();
        String trenerTabela = new Trener().vratiNazivTabele();
        String uslov = " JOIN " + trenerTabela +" on " + evidencijaTabela + ".trener = " + trenerTabela + ".idTrener "
                            + "JOIN " + clanTabela + " on " + evidencijaTabela + ".clanTeretane = " + clanTabela + ".idClanTeretane";
        evidencije = broker.getAll((EvidencijaTreninga) obj, uslov);
    }

    public List<EvidencijaTreninga> getEvidencije() {
        return evidencije;
    }
    
    
    
}
