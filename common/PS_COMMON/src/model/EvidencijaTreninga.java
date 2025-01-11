/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aca
 */
public class EvidencijaTreninga implements ApstraktniDomenskiObjekat{
    int idEvidencija;
    LocalDate datumPocetka;
    LocalDate datumZavrsetka;
    double intenzitet;
    Trener trener;
    ClanTeretane clanTeretane;
    List<StavkaEvidencijeTreninga> stavke;

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

    @Override
    public String vratiNazivTabele() {
        return "evidencija_treninga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("evidencija_treninga.idEvidencijaTreninga");
            LocalDate datumPocetka = rs.getDate("evidencija_treninga.datumPocetka").toLocalDate();
            LocalDate datumZavrsetka = rs.getDate("evidencija_treninga.datumZavrsetka").toLocalDate();
            double intenzitet = rs.getDouble("evidencija_treninga.intenzitet");
            //trener
            //clanTeretane
            
            EvidencijaTreninga et = new EvidencijaTreninga(id, datumPocetka, datumZavrsetka, intenzitet, null, null);
            lista.add(et);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumPocetka, datumZavrsetka, intenzitet, trener, clanTeretane";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + datumPocetka + "', '" + datumZavrsetka + "', "
                + intenzitet + ", " + trener.getIdTrener() + ", " + clanTeretane.getIdClanTeretane();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "evidencija_treninga.idEvidencijaTreninga=" + idEvidencija;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumPocetka='" + datumPocetka + "', datumZavrsetka='" + datumZavrsetka + 
                "', intenzitet=" + intenzitet + ", trener=" + trener.getIdTrener() + ", clanTeretane=" + clanTeretane.getIdClanTeretane();
    }
    
    
}
