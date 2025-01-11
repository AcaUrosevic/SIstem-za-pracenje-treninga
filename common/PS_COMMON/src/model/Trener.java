/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aca
 */
public class Trener {
    int idTrener;
    String ime;
    String prezime;
    String email;
    String korisnickoIme;
    String sifra;
    
    public Trener() {
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
        return "Trener{" + "ime=" + ime + ", prezime=" + prezime + ", email=" + email + '}';
    }
    
    
    
    
}
