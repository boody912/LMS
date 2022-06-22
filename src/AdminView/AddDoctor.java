/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminView;

import LMS.FirstScreen;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */

public class AddDoctor extends  JPanel implements ActionListener {
     
    JLabel  userNameLabel , DocPasswordLabel , DocdeparetmentLabel,headlabel ;
    JTextField  userName , DocPassword ,  Docdeparetment;
    JButton send,del,update;
    JButton Pervious = new JButton("Previous");
    
    public  AddDoctor () {
    this.setLayout(null);
    // ... in .. userNameLabel , DocPasswordLabel and DocdeparetmentLabel 
    headlabel = new JLabel("Add Doctor");
    userNameLabel = new JLabel("user Name");
    DocPasswordLabel = new JLabel("password");
    DocdeparetmentLabel = new JLabel("department"); 
    
    headlabel.setBounds(50, 20, 80, 25);
    userNameLabel.setBounds(50, 50, 80, 25);
    DocPasswordLabel.setBounds(50, 80, 80, 25);
    DocdeparetmentLabel.setBounds(50, 110, 80, 25);
    
     add(headlabel);
    add(userNameLabel);
    add(DocPasswordLabel);
    add(DocdeparetmentLabel);
    

    
    // ... in .. Fname , Lname , adress ,  department textfield
    userName = new JTextField();
    DocPassword = new JTextField();
    Docdeparetment = new JTextField();  
    userName.setBounds(150, 50, 120, 25);
    DocPassword.setBounds(150, 80, 120, 25);
    Docdeparetment.setBounds(150, 110, 120, 25);
    add(userName);
    add(DocPassword);
    add(Docdeparetment);
    


    // .... in ...send data button
    send = new JButton("Submit");
    send.setBackground(Color.LIGHT_GRAY);
    send.setForeground(Color.blue);
    send.setBounds(120, 220, 80, 25);
    add(send);
    send.addActionListener(this);
    
    // .... in ...delete data button
     del = new JButton("Delete");
     del.setBackground(Color.LIGHT_GRAY);
     del.setForeground(Color.blue);
     del.setBounds(220, 220, 80, 25);
     add(del);
     del.addActionListener(this);
     
     // .... in ...delete data button
     update = new JButton("modify");
     update.setBackground(Color.LIGHT_GRAY); 
     update.setForeground(Color.blue);
     update.setBounds(320, 220, 90, 25);
     add(update);
     update.addActionListener(this);
     
     
    
   // ... in .. send and back button
    Pervious.setBackground(Color.orange);
    Pervious.setForeground(Color.black);
    Pervious.setBounds(860, 490, 150, 25);
    add(Pervious);
    Pervious.addActionListener(this);   
    
  

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==send) {
            try {
                DataBase.UserDataBase.insertUser(userName.getText(), DocPassword.getText(), Docdeparetment.getText());
                JOptionPane.showMessageDialog(null, "Doctor Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
       
         if (e.getSource()==del) {
            try {
                DataBase.UserDataBase.DeleteUser(userName.getText());
                JOptionPane.showMessageDialog(null, "Doctor Has Been Deleted Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
         
          if (e.getSource()==update) {
            try {
                DataBase.UserDataBase.UpdateUsers(userName.getText(), DocPassword.getText(), Docdeparetment.getText());
                JOptionPane.showMessageDialog(null, "Admin Has Been modified Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
          }
        
        
        if (e.getSource()== Pervious) {
            new FirstScreen().showFirstScreen();
            }
    
    }   
}
