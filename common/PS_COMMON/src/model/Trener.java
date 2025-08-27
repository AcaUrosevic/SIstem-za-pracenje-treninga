/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aca
 */
public class Trener implements ApstraktniDomenskiObjekat{
    int idTrener;
    String ime;
    String prezime;
    String email;
    String korisnickoIme;
    String sifra;
    
    public Trener() {
    }

    public Trener(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }
    
    public Trener(int idTrener, String ime, String prezime, String email) {
        this.idTrener = idTrener;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }
    
    public Trener(int idTrener, String ime, String prezime, String email, String korisnickoIme, String sifra) {
        this.idTrener = idTrener;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public int getIdTrener() {
        return idTrener;
    }

    public void setIdTrener(int idTrener) {
        this.idTrener = idTrener;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "trener";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("trener.idTrener");
            String ime = rs.getString("trener.ime");
            String prezime = rs.getString("trener.prezime");
            String korisnickoIme = rs.getString("trener.korisnickoIme");
            String email = rs.getString("trener.email");
            String sifra = rs.getString("trener.sifra");
            
            Trener t = new Trener(id, ime, prezime, email, korisnickoIme, sifra);
            lista.add(t);
        }
        
        return lista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trener other = (Trener) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }
    
    

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, prezime, email, korisnickoIme, sifra";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + prezime + "', '" + email + "', '" + korisnickoIme + "', '" + sifra + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "trener.idTrener=" + idTrener;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', email='" + email + "', korisnickoIme'" + korisnickoIme + "', sifra='" + sifra + "'";
    }
    
    
    
    
}
