/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;


import repository.Repository;
import repository.db.DbRepository;
import repository.db.impl.DbRepositoryGeneric;

/**
 *
 * @author Aca
 */
public abstract class ApstraktnaGenerickaOperacija {
    protected final Repository broker;
    
    public ApstraktnaGenerickaOperacija(){
        this.broker = new DbRepositoryGeneric();
    }
    
    public final void izvrsi(Object obj, String kljuc) throws Exception{
        try {
            preduslovi(obj);
            zapocniTransakciju();
            izvrsiOperaciju(obj, kljuc);
            potvrdiTransakciju();
        } catch (Exception ex) {
            ponistiTransakciju();
            throw ex;
        } finally{
            ugasiKonekciju();
        }
    }

    protected abstract void preduslovi(Object obj) throws Exception;
    
    protected abstract void izvrsiOperaciju(Object obj, String kljuc) throws Exception;

    private void zapocniTransakciju() throws Exception {
        ((DbRepository) broker).connect();
    }

    private void potvrdiTransakciju() throws Exception {
        ((DbRepository) broker).commit();
    }
    
    private void ponistiTransakciju() throws Exception {
        ((DbRepository) broker).rollback();
    }
    
    private void ugasiKonekciju() throws Exception{
        ((DbRepository) broker).disconnect();
    }
}
