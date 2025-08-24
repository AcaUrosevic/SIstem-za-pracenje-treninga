/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Trener;

/**
 *
 * @author Aca
 */
public class LoginController {
    
    final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = lf.getTxtUsername().getText().trim();
                String password = String.valueOf(lf.getPassPassword().getPassword());
                
                Komunikacija.getInstance().konekcija();
                Trener trener = Komunikacija.getInstance().login(username, password);
                
                if(trener == null){
                    JOptionPane.showMessageDialog(lf, "NEUSPESNO PRIJAVLJIVANJE", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(lf, "USPESNO PRIJAVLJIVANJE", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                lf.dispose();
            }
        });
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
}
