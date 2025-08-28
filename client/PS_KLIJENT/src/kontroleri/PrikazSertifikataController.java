/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.PrikazSertifikataForma;
import forme.modeli.ModelTabeleSertifikati;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.Sertifikat;
import model.TrenerSertifikat;

/**
 *
 * @author Aca
 */
public class PrikazSertifikataController {
    PrikazSertifikataForma forma;

    public PrikazSertifikataController(PrikazSertifikataForma forma) {
        this.forma = forma;
        addActionListeners();
    }
    
    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    private void pripremiFormu() {
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ucitajTabeluSertifikata();
    }

    private void addActionListeners() {
        forma.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kordinator.getInstance().otvoriFOrmuDodajSertifikat();
            }
        });
    }

    public void ucitajTabeluSertifikata() {
        List<TrenerSertifikat> sertifikati = Komunikacija.getInstance().ucitajSertifikate();
        ModelTabeleSertifikati mts = new ModelTabeleSertifikati(sertifikati);
        forma.getTblSertifikati().setModel(mts);
    }
}
