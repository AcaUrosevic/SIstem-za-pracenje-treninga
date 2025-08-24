/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ClanTeretane;

/**
 *
 * @author Aca
 */
public class ModelTabeleClanovi extends AbstractTableModel{
    List<ClanTeretane> clanovi;
    String [] kolone = {"Ime", "Prezime", "Email", "PaketUsluga"};
    
    public ModelTabeleClanovi(List<ClanTeretane> clanovi){
        this.clanovi = clanovi;
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
           // case 3: return clan.getPaketUsluga().getNaziv();
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
}
