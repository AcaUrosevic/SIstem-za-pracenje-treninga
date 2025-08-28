/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import model.ClanTeretane;

/**
 *
 * @author Aca
 */
public class PromeniClanaTeretaneSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object obj) throws Exception {
        ClanTeretane ct = (ClanTeretane) obj;
        Exception e = new Exception();
        String ime = ct.getIme();
        String prezime = ct.getPrezime();
        String email = ct.getEmail();
        if(ime == null || prezime == null || email == null || ime.isEmpty() || prezime.isEmpty() ||email.isEmpty())
            throw e;
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        broker.edit((ClanTeretane) obj);
    }
    
}
