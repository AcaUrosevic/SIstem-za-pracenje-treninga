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
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.EvidencijaTreninga;
import model.StavkaEvidencijeTreninga;

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
                stavke = Komunikacija.getInstance().vratiStavkeEvidencije(evidencija);
                if(stavke == null){
                    JOptionPane.showMessageDialog(forma, "Sistem ne moze da vrati stavke evidencije treninga", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                osveziTabeluStavki(stavke);
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
                Kordinator.getInstance().otvoriFormuIzmenaEvidencije(evidencija, stavke);
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
    
    
    
}
