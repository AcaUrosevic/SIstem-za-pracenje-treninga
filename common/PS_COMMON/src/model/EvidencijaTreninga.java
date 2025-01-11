/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Aca
 */
public class EvidencijaTreninga {
    int idEvidencija;
    LocalDate datumPocetka;
    LocalDate datumZavrsetka;
    double intenzitet;
    Trener trener;
    ClanTeretane clanTeretane;

    public EvidencijaTreninga() {
    }

    public EvidencijaTreninga(int idEvidencija, LocalDate datumPocetka, LocalDate datumZavrsetka, double intenzitet, Trener trener, ClanTeretane clanTeretane) {
        this.idEvidencija = idEvidencija;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.intenzitet = intenzitet;
        this.trener = trener;
        this.clanTeretane = clanTeretane;
    }

    public int getIdEvidencija() {
        return idEvidencija;
    }

    public void setIdEvidencija(int idEvidencija) {
        this.idEvidencija = idEvidencija;
    }

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public LocalDate getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(LocalDate datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public double getIntenzitet() {
        return intenzitet;
    }

    public void setIntenzitet(double intenzitet) {
        this.intenzitet = intenzitet;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public ClanTeretane getClanTeretane() {
        return clanTeretane;
    }

    public void setClanTeretane(ClanTeretane clanTeretane) {
        this.clanTeretane = clanTeretane;
    }
    
    
}
