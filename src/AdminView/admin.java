/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminView;

import AdminView.AddStudent;
import AdminView.AddDoctor;
import AdminView.AddAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JFrame;

/**
 *
 * @author asus
 */

public class admin extends JFrame implements ActionListener {
    JTabbedPane tab;
    AddStudent a1;
    AddDoctor a2;
    AddAdmin a3  ;

   public admin()
   {

   }
   public void showAdminScreen()
   {
      a2 = new AddDoctor();
      a1 = new AddStudent();
      a3 = new AddAdmin();
      //...in ...main form for project
      setTitle("Admin");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setSize(1366, 620);
      setVisible(true);
      
      tab= new JTabbedPane(); 
      tab.addTab("add student", a1);
      tab.addTab("add doctor", a2);
      tab.add("add admin", a3);
      add(tab);
      
     
     
   }
   @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}