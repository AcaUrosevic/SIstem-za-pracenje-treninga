/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.DodajEvidencijuForma;
import forme.modeli.ModelTabeleStavke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
import model.Trener;

/**
 *
 * @author Aca
 */
public class DodajEvidencijuController {
    DodajEvidencijuForma forma;
    EvidencijaTreninga evidencijaZaIzmenu;
    List<StavkaEvidencijeTreninga> stavke;

    public DodajEvidencijuController(DodajEvidencijuForma forma, EvidencijaTreninga evidencijaZaIzmenu, List<StavkaEvidencijeTreninga> stavke) {
        this.forma = forma;
        this.evidencijaZaIzmenu = evidencijaZaIzmenu;
        this.stavke = stavke;
        addActionListeners();
    }

    private void addActionListeners() {
        forma.addBtnDodajStavkuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kordinator.getInstance().otvoriFormuDodajStavku();
            }
        });
        
        forma.addBtnDodajEvidencijuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    LocalDate datumTrening = LocalDate.parse(forma.getTxtDatumTreninga().getText());
                    if(datumTrening.isAfter(LocalDate.now())){
                        JOptionPane.showMessageDialog(forma, "Datum ne sme biti u budocnosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Trener trener = (Trener) forma.getCbTreneri().getSelectedItem();
                    ClanTeretane clan = (ClanTeretane) forma.getCbClanoviTeretane().getSelectedItem();
                    double intenzitet = 0;
                    for (StavkaEvidencijeTreninga s : stavke) {
                        intenzitet += s.getBrojPonavljanja() * s.getBrojSerija() * s.getNaporVezbe() * s.getTezina();
                    }
                    if(!stavke.isEmpty())
                        intenzitet = intenzitet/stavke.size();
                    EvidencijaTreninga evidencija = new EvidencijaTreninga(datumTrening, intenzitet, trener, clan);
                    int idEvidencije = Komunikacija.getInstance().kreirajEvidencijuTreninga(evidencija);
                    if(idEvidencije == -1){
                        JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti evidenciju treninga", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(forma, "Sistem je zapamtio evidenciju treninga", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    evidencija.setIdEvidencija(idEvidencije);
                    for (StavkaEvidencijeTreninga stavka : stavke) {
                        stavka.setEvidencijaTreninga(evidencija);
                        boolean uspesno = Komunikacija.getInstance().kreirajStavku(stavka);
                        if(!uspesno){
                            JOptionPane.showMessageDialog(forma, "Greska pri dodavanju stavki evidencije", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                } catch(DateTimeParseException ex){
                    JOptionPane.showMessageDialog(forma, "Datum mora biti u formatu: yyyy-mm-dd", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void otvoriFormu(){
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        pripremiFormu();
        forma.setVisible(true);
    }

    private void pripremiFormu() {
        ucitajTrenere();
        ucitajClanove();
        ucitajTabelu();
    }

    private void ucitajTrenere() {
        List<Trener> treneri = Komunikacija.getInstance().ucitajTrenere();
        if(treneri == null){
        }
        for (Trener trener : treneri) {
            forma.getCbTreneri().addItem(trener);
        }
    }

    private void ucitajClanove() {
        List<ClanTeretane> clanovi = Komunikacija.getInstance().ucitajClanove();
        for (ClanTeretane clanTeretane : clanovi) {
            forma.getCbClanoviTeretane().addItem(clanTeretane);
        }
    }

    private void ucitajTabelu() {
        ModelTabeleStavke mts = new ModelTabeleStavke(stavke);
        forma.getTblStavke().setModel(mts);
    }
   
    public boolean dodajStavku(StavkaEvidencijeTreninga stv){
        if(stavke.contains(stv))
            return false;
        stavke.add(stv);
        ucitajTabelu();
        return true;
    }
    
    
}
