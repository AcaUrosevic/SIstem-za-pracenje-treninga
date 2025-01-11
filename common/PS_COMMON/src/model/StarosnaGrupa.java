/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aca
 */
public class StarosnaGrupa {
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
    
    
}
