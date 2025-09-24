/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.util.List;
import model.ClanTeretane;
import model.PaketUsluga;

/**
 *
 * @author Aca
 */
public class ClanTeretaneRepository extends DbRepositoryGeneric{
    @SuppressWarnings("unchecked")
    public List<ClanTeretane> vratiSve() throws Exception{
        String paketTabela = new PaketUsluga().vratiNazivTabele();
        String clanTabela = new ClanTeretane().vratiNazivTabele();
        List<?> tmp = getAll(new ClanTeretane(), " JOIN " + paketTabela + " on " + clanTabela + ".paketUsluga = " + paketTabela + ".idPaketUsluga");
        
        return (List<ClanTeretane>)(List<?>) tmp;
    }
}
