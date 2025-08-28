/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import model.TrenerSertifikat;

/**
 *
 * @author Aca
 */
public class UbaciSertifikatSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object obj) throws Exception {
        TrenerSertifikat ts = (TrenerSertifikat)obj;
        Exception exception = new Exception();
        if(ts.getSertifikat().getNaziv() == null || ts.getSertifikat().getTip() == null)
            throw exception;
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        TrenerSertifikat ts = (TrenerSertifikat)obj;
        int idSertifikat = broker.addAndReturnId(ts.getSertifikat());
        ts.getSertifikat().setIdSertifikat(idSertifikat);
        broker.add(ts);
    }
    
}
