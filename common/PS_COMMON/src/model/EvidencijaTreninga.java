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
    LocalDate datumTreninga;
    double intenzitet;
    Trener trener;
    ClanTeretane clanTeretane;
    List<StavkaEvidencijeTreninga> stavke;

    public EvidencijaTreninga() {
    }
    
     public EvidencijaTreninga(LocalDate datumTreninga, double intenzitet, Trener trener, ClanTeretane clanTeretane) {
        this.datumTreninga = datumTreninga;
        this.intenzitet = intenzitet;
        this.trener = trener;
        this.clanTeretane = clanTeretane;
    }

    public EvidencijaTreninga(int idEvidencija, LocalDate datumTreninga, double intenzitet, Trener trener, ClanTeretane clanTeretane) {
        this.idEvidencija = idEvidencija;
        this.datumTreninga = datumTreninga;
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

    public LocalDate getDatumTreninga() {
        return datumTreninga;
    }

    public void setDatumTreninga(LocalDate datumTreninga) {
        this.datumTreninga = datumTreninga;
    }

    public List<StavkaEvidencijeTreninga> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaEvidencijeTreninga> stavke) {
        this.stavke = stavke;
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
            LocalDate datumTreninga = rs.getDate("evidencija_treninga.datumTreninga").toLocalDate();
            double intenzitet = rs.getDouble("evidencija_treninga.intenzitet");
            //trener
            int idTrener = rs.getInt("trener.idTrener");
            String imeTrener = rs.getString("trener.ime");
            String prezimeTrener = rs.getString("trener.prezime");
            String emailTrener = rs.getString("trener.email");
            Trener trener = new Trener(idTrener, imeTrener, prezimeTrener, emailTrener);
            //clanTeretane
            int idClan = rs.getInt("clan_teretane.idClanTeretane");
            String imeClan = rs.getString("clan_teretane.ime");
            String prezimeClan = rs.getString("clan_teretane.prezime");
            String emailClan = rs.getString("clan_teretane.email");
            /*int idPaketUsluga = rs.getInt("paket_usluga.idPaketUsluga");
            LocalDate datumUplate = rs.getDate("paket_usluga.datumUplate").toLocalDate();
            int trajanje = rs.getInt("paket_usluga.trajanje");
            double cena = rs.getDouble("paket_usluga.cena");
            String naziv = rs.getString("paket_usluga.naziv");
            String opis = rs.getString("paket_usluga.opis");
            PaketUsluga pu = new PaketUsluga(idPaketUsluga, datumUplate, trajanje, cena, naziv, opis);*/
            ClanTeretane clan = new ClanTeretane(idClan, imeClan, prezimeClan, emailClan, null);
            
            EvidencijaTreninga et = new EvidencijaTreninga(id, datumTreninga, intenzitet, trener, clan);
            lista.add(et);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumTreninga, intenzitet, trener, clanTeretane";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + datumTreninga + "', " +  intenzitet + ", " + trener.getIdTrener() + ", " + clanTeretane.getIdClanTeretane();
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
        return "datumTreninga='" + datumTreninga + "', intenzitet=" +  intenzitet + ", trener=" + trener.getIdTrener() + ", clanTeretane=" + clanTeretane.getIdClanTeretane();
    }


    
    
}
