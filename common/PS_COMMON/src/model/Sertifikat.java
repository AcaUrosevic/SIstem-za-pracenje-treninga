/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aca
 */
public class Sertifikat implements ApstraktniDomenskiObjekat{
    int idSertifikat;
    String naziv;
    String tip;

    public Sertifikat() {
    }
    
    public Sertifikat(String naziv, String tip) {
        this.naziv = naziv;
        this.tip = tip;
    }

    public Sertifikat(int idSertifikat, String naziv, String tip) {
        this.idSertifikat = idSertifikat;
        this.naziv = naziv;
        this.tip = tip;
    }

    public int getIdSertifikat() {
        return idSertifikat;
    }

    public void setIdSertifikat(int idSertifikat) {
        this.idSertifikat = idSertifikat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String vratiNazivTabele() {
        return "sertifikat";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("sertifikat.idSertifikat");
            String naziv = rs.getString("sertifikat.naziv");
            String tip = rs.getString("sertifikat.tip");
            
            Sertifikat s = new Sertifikat(id, naziv, tip);
            lista.add(s);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, tip";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" + tip + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sertifikat.idSertifikat=" + idSertifikat;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', tip='" + tip + "'";
    }
    
    
}
