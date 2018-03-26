/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpanel;

import javax.swing.WindowConstants;

/**
 *
 * @author charyth
 */
public class Loginpanel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     MainLogin ml = new MainLogin();
     ml.setVisible(true);
    // ml.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ml.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
