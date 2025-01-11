/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aca
 */
public class StavkaEvidencijeTreninga {
    int rb;
    EvidencijaTreninga evidencijaTreninga;
    int brojPonavljanja;
    int brojSerija;
    double tezina;
    double skorVezbe;
    Vezba vezba;

    public StavkaEvidencijeTreninga() {
    }

    public StavkaEvidencijeTreninga(int rb, EvidencijaTreninga evidencijaTreninga, int brojPonavljanja, int brojSerija, double tezina, double skorVezbe, Vezba vezba) {
        this.rb = rb;
        this.evidencijaTreninga = evidencijaTreninga;
        this.brojPonavljanja = brojPonavljanja;
        this.brojSerija = brojSerija;
        this.tezina = tezina;
        this.skorVezbe = skorVezbe;
        this.vezba = vezba;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public EvidencijaTreninga getEvidencijaTreninga() {
        return evidencijaTreninga;
    }

    public void setEvidencijaTreninga(EvidencijaTreninga evidencijaTreninga) {
        this.evidencijaTreninga = evidencijaTreninga;
    }

    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    public int getBrojSerija() {
        return brojSerija;
    }

    public void setBrojSerija(int brojSerija) {
        this.brojSerija = brojSerija;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public double getSkorVezbe() {
        return skorVezbe;
    }

    public void setSkorVezbe(double skorVezbe) {
        this.skorVezbe = skorVezbe;
    }

    public Vezba getVezba() {
        return vezba;
    }

    public void setVezba(Vezba vezba) {
        this.vezba = vezba;
    }
    
    
}
