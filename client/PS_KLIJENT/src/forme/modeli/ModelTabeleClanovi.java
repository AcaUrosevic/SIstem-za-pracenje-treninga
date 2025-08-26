/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.ClanTeretane;
import model.PaketUsluga;

/**
 *
 * @author Aca
 */
public class ModelTabeleClanovi extends AbstractTableModel{
    List<ClanTeretane> clanovi;
    List<ClanTeretane> fullClanovi;
    String [] kolone = {"Ime", "Prezime", "Email", "PaketUsluga"};
    
    public ModelTabeleClanovi(List<ClanTeretane> clanovi){
        this.clanovi = clanovi;
        this.fullClanovi = clanovi;
    }
    
    @Override
    public int getRowCount() {
        return clanovi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClanTeretane clan = clanovi.get(rowIndex);
        switch (columnIndex) {
            case 0: return clan.getIme();
            case 1: return clan.getPrezime();
            case 2: return clan.getEmail();
            case 3: return clan.getPaketUsluga().getNaziv();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<ClanTeretane> getClanovi() {
        return clanovi;
    }
    
    public void removeAt(int modelRow) {
        clanovi.remove(modelRow);
        fireTableRowsDeleted(modelRow, modelRow);
    }

    public void petrazi(String ime, String prezime, PaketUsluga paket) {
        List<ClanTeretane> filtrirani = fullClanovi.stream()
                .filter(p -> ime == null || ime.isEmpty() || p.getIme().toLowerCase().contains(ime.toLowerCase()))
                .filter(p -> prezime == null || prezime.isEmpty() || p.getPrezime().toLowerCase().contains(prezime.toLowerCase()))
                .filter(p ->paket == null || paket.equals(p.getPaketUsluga()) )
                .collect(Collectors.toList());
        this.clanovi = filtrirani;
        fireTableDataChanged();
    }
}
