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
public class TrenerSertifikat implements ApstraktniDomenskiObjekat{
    Trener trener;
    Sertifikat sertifikat;
    LocalDate datumIzdavanja;

    public TrenerSertifikat() {
    }

    public TrenerSertifikat(Trener trener, Sertifikat sertifikat, LocalDate datumIzdavanja) {
        this.trener = trener;
        this.sertifikat = sertifikat;
        this.datumIzdavanja = datumIzdavanja;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Sertifikat getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(Sertifikat sertifikat) {
        this.sertifikat = sertifikat;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    @Override
    public String vratiNazivTabele() {
        return "trener_sertifikat";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            //trener
            int idTrener = rs.getInt("trener.idTrener");
            String ime = rs.getString("trener.ime");
            String prezime = rs.getString("trener.prezime");
            String korisnickoIme = rs.getString("trener.korisnickoIme");
            String email = rs.getString("trener.email");
            String sifra = rs.getString("trener.sifra");
            Trener t = new Trener(idTrener, ime, prezime, email, korisnickoIme, sifra);
            //sertifikat
            int idSertifikat = rs.getInt("sertifikat.idSertifikat");
            String naziv = rs.getString("sertifikat.naziv");
            String tip = rs.getString("sertifikat.tip");
            
            Sertifikat s = new Sertifikat(idSertifikat, naziv, tip);
            LocalDate datumIzdavanja = rs.getDate("trener_sertifikat.datumIzdavanja").toLocalDate();
            
            TrenerSertifikat ts = new TrenerSertifikat(t, s, datumIzdavanja);
            lista.add(ts);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "trener, sertifikat, datumIzdavanja";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return trener.getIdTrener() + ", " + sertifikat.getIdSertifikat() + ", '" + datumIzdavanja + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "trener_sertifikat.trener=" + trener.getIdTrener() + " and trener_sertifikat.sertifikat=" + sertifikat.getIdSertifikat();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "trener=" + trener.getIdTrener() + ", sertifikat=" + sertifikat.getIdSertifikat() +
                ", datumIzdavanja'" + datumIzdavanja + "'";
    }
    
    
}
