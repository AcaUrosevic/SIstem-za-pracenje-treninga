/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.Sertifikat;
import model.Trener;
import model.TrenerSertifikat;

/**
 *
 * @author Aca
 */
public class VratiListuSertifikataTreneraSO extends ApstraktnaGenerickaOperacija{
    List<TrenerSertifikat> sertifikatiTrenera;
    @Override
    protected void preduslovi(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        Trener trener = (Trener)obj;
        sertifikatiTrenera = broker.getAll(new TrenerSertifikat(), 
                                                             " JOIN "+ trener.vratiNazivTabele() + " ON trener = idTrener" +
                                                             " JOIN "+ new Sertifikat().vratiNazivTabele() + " ON sertifikat = idSertifikat" +
                                                             " WHERE trener = "  + trener.getIdTrener());
    }

    public List<TrenerSertifikat> getSertifikatiTrenera() {
        return sertifikatiTrenera;
    }
    
    
}
