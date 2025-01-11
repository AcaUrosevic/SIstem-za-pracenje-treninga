/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aca
 */
public class ClanTeretane {
    int idClanTeretane;
    String ime;
    String prezime;
    String email;
    StarosnaGrupa starosnaGrupa;

    public ClanTeretane() {
    }

    public ClanTeretane(int idClanTeretane, String ime, String prezime, String email, StarosnaGrupa starosnaGrupa) {
        this.idClanTeretane = idClanTeretane;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.starosnaGrupa = starosnaGrupa;
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

    public StarosnaGrupa getStarosnaGrupa() {
        return starosnaGrupa;
    }

    public void setStarosnaGrupa(StarosnaGrupa starosnaGrupa) {
        this.starosnaGrupa = starosnaGrupa;
    }
    
    
}
