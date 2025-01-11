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
public class StarosnaGrupa implements ApstraktniDomenskiObjekat{
    int idStarosnaGrupa;
    String naziv;
    int rasponOd;
    int rasponDo;

    public StarosnaGrupa() {
    }

    public StarosnaGrupa(int idStarosnaGrupa, String naziv, int rasponOd, int rasponDo) {
        this.idStarosnaGrupa = idStarosnaGrupa;
        this.naziv = naziv;
        this.rasponOd = rasponOd;
        this.rasponDo = rasponDo;
    }

    public int getIdStarosnaGrupa() {
        return idStarosnaGrupa;
    }

    public void setIdStarosnaGrupa(int idStarosnaGrupa) {
        this.idStarosnaGrupa = idStarosnaGrupa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getRasponOd() {
        return rasponOd;
    }

    public void setRasponOd(int rasponOd) {
        this.rasponOd = rasponOd;
    }

    public int getRasponDo() {
        return rasponDo;
    }

    public void setRasponDo(int rasponDo) {
        this.rasponDo = rasponDo;
    }

    @Override
    public String vratiNazivTabele() {
        return "starosna_grupa";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("starosna_grupa.idStarosnaGrupa");
            String naziv = rs.getString("starosnaGrupa.naziv");
            int rasponOd = rs.getInt("starosnaGrupa.rasponOd");
            int rasponDo = rs.getInt("starosnaGrupa.rasponDo");
            
            StarosnaGrupa sg = new StarosnaGrupa(id, naziv, rasponOd, rasponDo);
            lista.add(sg);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, rasponOd, rasponDo";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', " + rasponOd + ", " + rasponDo;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "starosna_grupa.idStarosnaGrupa=" + idStarosnaGrupa;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', rasponOd=" + rasponOd + ", rasponDo=" + rasponDo;
    }
    
    
}
