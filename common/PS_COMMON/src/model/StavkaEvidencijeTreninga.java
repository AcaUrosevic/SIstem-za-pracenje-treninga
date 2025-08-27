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
public class StavkaEvidencijeTreninga implements ApstraktniDomenskiObjekat{
    int rb;
    EvidencijaTreninga evidencijaTreninga;
    int brojPonavljanja;
    int brojSerija;
    double tezina;
    double naporVezbe;
    Vezba vezba;

    public StavkaEvidencijeTreninga() {
    }

    public StavkaEvidencijeTreninga(int rb, EvidencijaTreninga evidencijaTreninga, int brojPonavljanja, int brojSerija, double tezina, double naporVezbe, Vezba vezba) {
        this.rb = rb;
        this.evidencijaTreninga = evidencijaTreninga;
        this.brojPonavljanja = brojPonavljanja;
        this.brojSerija = brojSerija;
        this.tezina = tezina;
        this.naporVezbe = naporVezbe;
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

    public double getNaporVezbe() {
        return naporVezbe;
    }

    public void setNaporVezbe(double naporVezbe) {
        this.naporVezbe = naporVezbe;
    }

    public Vezba getVezba() {
        return vezba;
    }

    public void setVezba(Vezba vezba) {
        this.vezba = vezba;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavka_evidencije_treninga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int rb = rs.getInt("stavka_evidencije_treninga.rb");
            //evidencija
            int brojPonavljanja = rs.getInt("stavka_evidencije_treninga.brojPonavljanja");
            int brojSerija = rs.getInt("stavka_evidencije_treninga.brojSerija");
            double tezina = rs.getDouble("stavka_evidencije_treninga.tezina");
            double naporVezbe = rs.getDouble("stavka_evidencije_treninga.naporVezbe");
            //vezba
            
            StavkaEvidencijeTreninga set = new StavkaEvidencijeTreninga(rb, null, brojPonavljanja, brojSerija, tezina, naporVezbe, null);
            lista.add(set);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "rb, evidencija, brojPonavljanja, brojSerija, tezina, naporVezbe, vezba";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return rb + ", " + evidencijaTreninga.getIdEvidencija() + ", " + brojPonavljanja + ", " + brojSerija 
                + ", " + tezina + ", " + vezba.getNapor() + ", " + vezba.getIdVezba();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavka_evidencije_treninga.rb=" + rb + " and stavka_evidencije_treninga.evidencija=" + evidencijaTreninga.getIdEvidencija();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "rb=" + rb + ", evidencija=" + evidencijaTreninga.getIdEvidencija() + ", brojPonavljanja=" + brojPonavljanja +
                ", brojSerija=" + brojSerija + ", tezina=" + tezina + ", naporVezbe=" + vezba.getNapor() +
                ", vezba=" + vezba.getIdVezba();
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
        final StavkaEvidencijeTreninga other = (StavkaEvidencijeTreninga) obj;
        return this.rb == other.rb;
    }
    
    
    
}
