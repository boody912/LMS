/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 *
 * @author pc
 */
public class imagePanel2 extends JPanel {
    private ImageIcon b ; 
    
    public imagePanel2(){
     this.setLayout(null);
    }

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
//        i = new ImageIcon(getClass().getResource("..\\image\\project-management-career-path.png")); 
//        i.paintIcon(this, g, 0, 0);
        b = new ImageIcon(getClass().getResource("..\\image\\background.jpg")); 
        b.paintIcon(this, g, 0, 0);
        
    }
    
    
}
