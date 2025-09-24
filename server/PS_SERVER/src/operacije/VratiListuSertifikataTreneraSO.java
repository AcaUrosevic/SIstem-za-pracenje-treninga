/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import model.Sertifikat;
import model.Trener;
import model.TrenerSertifikat;
import repository.db.impl.SertifikatRepository;

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
        SertifikatRepository repo = new SertifikatRepository();
        sertifikatiTrenera = repo.pretraziPoTreneru(trener);
    }

    public List<TrenerSertifikat> getSertifikatiTrenera() {
        return sertifikatiTrenera;
    }
    
    
}
