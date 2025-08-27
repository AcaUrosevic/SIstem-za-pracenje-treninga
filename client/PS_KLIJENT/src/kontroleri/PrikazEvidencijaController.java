/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.PrikazEvidencijaForma;
import forme.modeli.ModelTabeleEvidencije;
import java.util.List;
import komunikacija.Komunikacija;
import model.EvidencijaTreninga;

/**
 *
 * @author Aca
 */
public class PrikazEvidencijaController {
    PrikazEvidencijaForma forma;

    public PrikazEvidencijaController(PrikazEvidencijaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    private void addActionListeners() {
        
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    private void pripremiFormu() {
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ucitajTabeluEvidencija();
    }

    private void ucitajTabeluEvidencija() {
        List<EvidencijaTreninga> evidencije = Komunikacija.getInstance().vratiListuEvidencija();
        ModelTabeleEvidencije mte = new ModelTabeleEvidencije(evidencije);
        forma.getTblEvidencije().setModel(mte);
    }
    
    
    
}
