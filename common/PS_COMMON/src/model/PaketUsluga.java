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
public class PaketUsluga implements ApstraktniDomenskiObjekat{
    int idPaketUsluga;
    int trajanje;
    double cena;
    String naziv;
    String opis;

    public PaketUsluga() {
    }

    public PaketUsluga(int idPaketUsluga, int trajanje, double cena, String naziv, String opis) {
        this.idPaketUsluga = idPaketUsluga;
        this.trajanje = trajanje;
        this.cena = cena;
        this.naziv = naziv;
        this.opis = opis;
    }

    

    public int getIdPaketUsluga() {
        return idPaketUsluga;
    }

    public void setIdPaketUsluga(int idPaketUsluga) {
        this.idPaketUsluga = idPaketUsluga;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
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
    
    
    

    @Override
    public String vratiNazivTabele() {
        return "paket_usluga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("paket_usluga.idPaketUsluga");
            int trajanje = rs.getInt("paket_usluga.trajanje");
            double cena = rs.getDouble("paket_usluga.cena");
            String naziv = rs.getString("paket_usluga.naziv");
            String opis = rs.getString("paket_usluga.opis");
            
            PaketUsluga pu = new PaketUsluga(id, trajanje, cena, naziv, opis);
            lista.add(pu);
        }
        
        return lista;
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
        final PaketUsluga other = (PaketUsluga) obj;
        return this.idPaketUsluga == other.idPaketUsluga;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumUplate, trajanje, cena, naziv, opis";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "" + trajanje + ", " + cena + ", " + naziv + ", " + opis;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "paket_usluga.idPaketUsluga="+idPaketUsluga;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "trajanje" + trajanje + ", cena=" + cena + ", naziv=" + naziv + ", opis=" + opis;
    }
    
    
    
}
