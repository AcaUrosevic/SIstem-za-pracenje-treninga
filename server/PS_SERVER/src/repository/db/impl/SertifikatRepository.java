/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.util.List;
import model.Sertifikat;
import model.Trener;
import model.TrenerSertifikat;

/**
 *
 * @author Aca
 */
public class SertifikatRepository extends DbRepositoryGeneric{
    @SuppressWarnings("unchecked")
    public List<TrenerSertifikat> pretraziPoTreneru(Trener trener) throws Exception{
        List<?> tmp = getAll(new TrenerSertifikat(), " JOIN "+ trener.vratiNazivTabele() + " ON trener = idTrener" +
                                                             " JOIN "+ new Sertifikat().vratiNazivTabele() + " ON sertifikat = idSertifikat" +
                                                             " WHERE trener = "  + trener.getIdTrener());
        return(List<TrenerSertifikat>)(List<?>) tmp;
    }
}
