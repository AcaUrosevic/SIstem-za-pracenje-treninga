/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aca
 */
public class Vezba {
    int idVezba;
    String naziv;
    String opis;
    double skor;
    
    public Vezba() {
    }

    public Vezba(int idVezba, String naziv, String opis, double skor) {
        this.idVezba = idVezba;
        this.naziv = naziv;
        this.opis = opis;
        this.skor = skor;
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

    public double getSkor() {
        return skor;
    }

    public void setSkor(double skor) {
        this.skor = skor;
    }
}
