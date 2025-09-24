/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.PrikazEvidencijaForma;
import forme.modeli.ModelTabeleEvidencije;
import forme.modeli.ModelTabeleStavke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.ClanTeretane;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;
import model.Trener;
import model.Vezba;

/**
 *
 * @author Aca
 */
public class PrikazEvidencijaController {
    PrikazEvidencijaForma forma;
    List<StavkaEvidencijeTreninga> stavke;

    public PrikazEvidencijaController(PrikazEvidencijaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    private void addActionListeners() {
        forma.addTblEvidencijeClickListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow= forma.getTblEvidencije().rowAtPoint(e.getPoint());
                if (selectedRow < 0) return;
                ModelTabeleEvidencije mte =(ModelTabeleEvidencije) forma.getTblEvidencije().getModel();
                EvidencijaTreninga evidencija = mte.getEvidencije().get(selectedRow);
                stavke = evidencija.getStavke();
                if(evidencija.getStavke() == null){
                    JOptionPane.showMessageDialog(forma, "Sistem ne moze da vrati stavke evidencije treninga", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                osveziTabeluStavki(evidencija.getStavke());
            } 
        });
        
        forma.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = forma.getTblEvidencije().getSelectedRow();
                if(selectedRow == -1){
                    JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje evidenciju treninga", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModelTabeleEvidencije mte =(ModelTabeleEvidencije) forma.getTblEvidencije().getModel();
                EvidencijaTreninga evidencija = mte.getEvidencije().get(selectedRow);
                System.out.println(evidencija.getTrener().getIme() + " " + evidencija.getTrener().getPrezime());
                JOptionPane.showMessageDialog(forma,"Sistem je nasao evidenciju treninga","USPEH",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                Kordinator.getInstance().otvoriFormuIzmenaEvidencije(evidencija, stavke);
                
            }
        });
    
        forma.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate datum = null;
                String t = forma.getTxtDatumTreninga().getText().trim();
                if (!t.isEmpty()) {
                    try { datum = java.time.LocalDate.parse(t); }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(forma,"Datum: yyyy-MM-dd","GRESKA",javax.swing.JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Trener trener = (Trener) forma.getCbTrener().getSelectedItem();
                ClanTeretane clan = (ClanTeretane) forma.getCbClan().getSelectedItem();
                Vezba vezba = (Vezba) forma.getCbVezba().getSelectedItem();

                if (vezba == null) {
                    ucitajTabeluEvidencija();
                    ModelTabeleEvidencije mte = (ModelTabeleEvidencije) forma.getTblEvidencije().getModel();
                    mte.pretrazi(datum, clan, trener);
                    if(!mte.getEvidencije().isEmpty())
                        JOptionPane.showMessageDialog(forma,"Sistem je nasao evidencije treninga po zadatim kriterijumima","USPEH",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(forma,"Sistem ne moze da nadje evidencije treninga po zadatim kriterijumima","GRESKA",javax.swing.JOptionPane.ERROR_MESSAGE);
                    osveziTabeluStavki(new java.util.ArrayList<>());
                    return;
                }

                List<EvidencijaTreninga> lista = Komunikacija.getInstance().pretraziEvidencijePoVezbi(vezba);
                if (lista == null) {
                    JOptionPane.showMessageDialog(forma,"Sistem ne moze da vrati evidencije","GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModelTabeleEvidencije m = new ModelTabeleEvidencije(lista);
                forma.getTblEvidencije().setModel(m);
                m.pretrazi(datum, clan, trener);
                if(!m.getEvidencije().isEmpty())
                        JOptionPane.showMessageDialog(forma,"Sistem je nasao evidencije treninga po zadatim kriterijumima","USPEH",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                else
                        JOptionPane.showMessageDialog(forma,"Sistem ne moze da nadje evidencije treninga po zadatim kriterijumima","GRESKA",javax.swing.JOptionPane.ERROR_MESSAGE);   
                osveziTabeluStavki(new ArrayList<>());
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    private void pripremiFormu() {
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ucitajTabeluEvidencija();
        ucitajCbTreneri();
        ucitajCbClanovi();
        ucitajCbVezbe();
        osveziTabeluStavki(new ArrayList<>());
    }

    public void ucitajTabeluEvidencija() {
        List<EvidencijaTreninga> evidencije = Komunikacija.getInstance().vratiListuEvidencija();
        ModelTabeleEvidencije mte = new ModelTabeleEvidencije(evidencije);
        forma.getTblEvidencije().setModel(mte);
    }

    public void osveziTabeluStavki(List<StavkaEvidencijeTreninga> stavke) {
        ModelTabeleStavke mts = new ModelTabeleStavke(stavke);
        forma.getTblStavke().setModel(mts);
    }

    private void ucitajCbTreneri() {
        List<Trener> treneri = Komunikacija.getInstance().ucitajTrenere();
        forma.getCbTrener().addItem(null);
        for (Trener trener : treneri) {
            forma.getCbTrener().addItem(trener);
        }
    }

    private void ucitajCbClanovi() {
        List<ClanTeretane> clanovi = Komunikacija.getInstance().ucitajClanove();
        forma.getCbClan().addItem(null);
        for (ClanTeretane clanTeretane : clanovi) {
            forma.getCbClan().addItem(clanTeretane);
        }
    }

    private void ucitajCbVezbe() {
        List<Vezba> vezbe = Komunikacija.getInstance().vratiListuVezbi();
        forma.getCbVezba().addItem(null);
        for (Vezba vezba : vezbe) {
            forma.getCbVezba().addItem(vezba);
        }
    }
    
    
    
}
