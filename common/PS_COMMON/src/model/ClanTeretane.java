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
public class ClanTeretane implements ApstraktniDomenskiObjekat{
    int idClanTeretane;
    String ime;
    String prezime;
    String email;
    PaketUsluga paketUsluga;

    public ClanTeretane() {
    }

    public ClanTeretane(int idClanTeretane, String ime, String prezime, String email, PaketUsluga paketUsluga) {
        this.idClanTeretane = idClanTeretane;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.paketUsluga = paketUsluga;
    }

    public ClanTeretane(String ime, String prezime, String email, PaketUsluga paket) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.paketUsluga = paket;
    }

    public int getIdClanTeretane() {
        return idClanTeretane;
    }

    public void setIdClanTeretane(int idClanTeretane) {
        this.idClanTeretane = idClanTeretane;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PaketUsluga getPaketUsluga() {
        return paketUsluga;
    }

    public void setPaketUsluga(PaketUsluga paketUsluga) {
        this.paketUsluga = paketUsluga;
    }

    @Override
    public String vratiNazivTabele() {
        return "clan_teretane";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("clan_teretane.idClanTeretane");
            String ime = rs.getString("clan_teretane.ime");
            String prezime = rs.getString("clan_teretane.prezime");
            String email = rs.getString("clan_teretane.email");
            
            ClanTeretane ct = new ClanTeretane(id, ime, prezime, email, null);
            lista.add(ct);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, prezime, email, paketUsluga";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + prezime + "', '" + email + "', " + paketUsluga.getIdPaketUsluga();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "clan_teretane.idClanTeretane=" + idClanTeretane;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', email='" + email + "', paketUsluga=" + paketUsluga.getIdPaketUsluga();
    }
    
    
}
