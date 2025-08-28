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
                try {
                    LocalDate datumTrening = LocalDate.parse(forma.getTxtDatumTreninga().getText());
                    if (datumTrening.isAfter(LocalDate.now())) {
                        JOptionPane.showMessageDialog(forma, "Datum ne sme biti u buducnosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Trener trener = (Trener) forma.getCbTreneri().getSelectedItem();
                    ClanTeretane clan = (ClanTeretane) forma.getCbClanoviTeretane().getSelectedItem();

                    double intenzitet = 0;
                    for (StavkaEvidencijeTreninga s : stavke) {
                        intenzitet += s.getBrojPonavljanja() * s.getBrojSerija() * s.getNaporVezbe() * s.getTezina();
                    }
                    if (!stavke.isEmpty()) intenzitet = intenzitet / stavke.size();

                    EvidencijaTreninga evidencija = new EvidencijaTreninga(datumTrening, intenzitet, trener, clan);
                    evidencija.setStavke(stavke);
                    int id = Komunikacija.getInstance().kreirajEvidencijuTreninga(evidencija);
                    if (id == -1) {
                        JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti evidenciju treninga", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    evidencija.setIdEvidencija(id);
                    JOptionPane.showMessageDialog(forma, "Sistem je zapamtio evidenciju", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    forma.dispose();

                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira evidenciju treninga", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
        forma.addBtnObrsiStavkuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = forma.getTblStavke().getSelectedRow();
                if(selectedRow == -1){
                    JOptionPane.showMessageDialog(forma, "Niste izabrali stavku", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModelTabeleStavke mts = (ModelTabeleStavke) forma.getTblStavke().getModel();
                mts.removeAt(selectedRow);
            }
        });
        
        forma.addBtnIzmeniEvidencijuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDate datumTrening = LocalDate.parse(forma.getTxtDatumTreninga().getText());
                    if (datumTrening.isAfter(LocalDate.now())) {
                        JOptionPane.showMessageDialog(forma, "Datum ne sme biti u buducnosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Trener trener = (Trener) forma.getCbTreneri().getSelectedItem();
                    ClanTeretane clan = (ClanTeretane) forma.getCbClanoviTeretane().getSelectedItem();

                    double intenzitet = 0;
                    for (StavkaEvidencijeTreninga s : stavke) {
                        intenzitet += s.getBrojPonavljanja() * s.getBrojSerija() * s.getNaporVezbe() * s.getTezina();
                    }
                    if (!stavke.isEmpty()) intenzitet = intenzitet / stavke.size();

                    evidencijaZaIzmenu.setDatumTreninga(datumTrening);
                    evidencijaZaIzmenu.setTrener(trener);
                    evidencijaZaIzmenu.setClanTeretane(clan);
                    evidencijaZaIzmenu.setIntenzitet(intenzitet);
                    evidencijaZaIzmenu.setStavke(stavke);

                    boolean ok = Komunikacija.getInstance().izmeniEvidenciju(evidencijaZaIzmenu);
                    if (!ok) {
                        JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti evidenciju treninga", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    JOptionPane.showMessageDialog(forma, "Sistem je zapamtio evidenciju treninga", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    Kordinator.getInstance().osveziTabeluEvidencija();
                    Kordinator.getInstance().osveziTabeluStavkiPrikaz();
                    forma.dispose();
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(forma, "Datum mora biti u formatu: yyyy-mm-dd", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void otvoriFormu(){
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        pripremiFormu();
        forma.getBtnIzmeni().setVisible(false);
        forma.setVisible(true);
    }

    private void pripremiFormu() {
        ucitajTrenere();
        ucitajClanove();
        ucitajTabelu();
    }

    private void ucitajTrenere() {
        List<Trener> treneri = Komunikacija.getInstance().ucitajTrenere();
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
        stavke.add(stv);
        ucitajTabelu();
        return true;
    }

    public void otvoriFormuIzmena() {
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        pripremiFormuIzmena();
        forma.getBtnDodaj().setVisible(false);
        forma.setVisible(true);
    }

    private void pripremiFormuIzmena() {
        pripremiFormu();
        forma.getCbTreneri().setSelectedItem(evidencijaZaIzmenu.getTrener());
        forma.getCbClanoviTeretane().setSelectedItem(evidencijaZaIzmenu.getClanTeretane());
        forma.getTxtDatumTreninga().setText(evidencijaZaIzmenu.getDatumTreninga().toString());
    }
    
    
}
