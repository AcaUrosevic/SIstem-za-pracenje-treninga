/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.util.List;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.Trener;
import model.Vezba;

/**
 *
 * @author Aca
 */
public class EvidencijaTreningaRepository extends DbRepositoryGeneric{
    @SuppressWarnings("unchecked")
    public List<EvidencijaTreninga> pretraziPoVezbi(Vezba v) throws Exception {
        String e = new EvidencijaTreninga().vratiNazivTabele();
        String t = new Trener().vratiNazivTabele();
        String c = new ClanTeretane().vratiNazivTabele();
        String vz = new Vezba().vratiNazivTabele();

        List<?> tmp = super.getAll(new EvidencijaTreninga(),
            " JOIN " + t + " ON " + e + ".trener = " + t + ".idTrener" +
            " JOIN " + c + " ON " + e + ".clanTeretane = " + c + ".idClanTeretane" +
            " JOIN stavka_evidencije_treninga s ON s.evidencija = " + e + ".idEvidencijaTreninga" +
            " JOIN " + vz + " ON s.vezba = " + vz + ".idVezba" +
            " WHERE " + vz + ".idVezba = " + v.getIdVezba());

        return (List<EvidencijaTreninga>)(List<?>) tmp;
    }
    
    @SuppressWarnings("unchecked")
    public List<EvidencijaTreninga> vratiSve() throws Exception {
        String clanTabela = new ClanTeretane().vratiNazivTabele();
        String evidencijaTabela = new EvidencijaTreninga().vratiNazivTabele();
        String trenerTabela = new Trener().vratiNazivTabele();
        List<?> tmp = getAll(new EvidencijaTreninga(), " JOIN " + trenerTabela +" on " + evidencijaTabela + ".trener = " + trenerTabela + ".idTrener "
                            + "JOIN " + clanTabela + " on " + evidencijaTabela + ".clanTeretane = " + clanTabela + ".idClanTeretane");
        
        return (List<EvidencijaTreninga>)(List<?>) tmp;
    }
}
