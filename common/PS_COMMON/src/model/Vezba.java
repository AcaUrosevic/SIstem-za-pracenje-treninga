/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aca
 */
public class Vezba implements ApstraktniDomenskiObjekat{
    int idVezba;
    String naziv;
    String opis;
    double napor;
    
    public Vezba() {
    }

    public Vezba(int idVezba, String naziv, String opis, double napor) {
        this.idVezba = idVezba;
        this.naziv = naziv;
        this.opis = opis;
        this.napor = napor;
    }

    public int getIdVezba() {
        return idVezba;
    }

    public void setIdVezba(int idVezba) {
        this.idVezba = idVezba;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getNapor() {
        return napor;
    }

    public void setSkor(double napor) {
        this.napor = napor;
    }

    @Override
    public String vratiNazivTabele() {
        return "vezba";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("vezba.idVezba");
            String naziv = rs.getString("vezba.naziv");
            String opis = rs.getString("vezba.opis");
            double napor = rs.getDouble("vezba.napor");
            
            Vezba v = new Vezba(id, naziv, opis, napor);
            lista.add(v);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, opis, napor";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" + opis + "', " + napor;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "vezba.idVezba=" + idVezba;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', opis='" + opis + "', napor=" + napor;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
