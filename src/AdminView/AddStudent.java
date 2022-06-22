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
public class AddStudent extends  JPanel implements ActionListener{
    
    JLabel FnameLabel , LnameLabel , addressLabel , departmentLabel, password , userNameLabel , DocPasswordLabel , DocdeparetmentLabel,headlabel ;
    JTextField Fname , Lname , address ,  department  , studPassword , userName , DocPassword,  Docdeparetment;
    JButton send,del,update;
    JButton Pervious = new JButton("Previous");
            
    public AddStudent(){
    this.setLayout(null);
   
    // ... in .. FnameLapel , LnameLabel , addressLapel and departmentLapel
     headlabel = new JLabel("Add Student");
    FnameLabel = new JLabel("First Name");
    LnameLabel = new JLabel("Last Name");
    addressLabel = new JLabel("Address");
    departmentLabel = new JLabel("Department"); 
    password = new JLabel("Password");
    
    headlabel.setBounds(50, 20, 80, 25);
    FnameLabel.setBounds(50, 50, 80, 25);
    LnameLabel.setBounds(50, 80, 80, 25);
    addressLabel.setBounds(50, 110, 80, 25);
    departmentLabel.setBounds(50, 140, 80, 25);
    password.setBounds(50, 170, 80, 25);
    
    add(headlabel);
    add(FnameLabel);
    add(LnameLabel);
    add(addressLabel);
    add(departmentLabel);
    add(password);  

    
    // ... in .. Fname , Lname , adress ,  department textfield
    Fname = new JTextField();
    Lname = new JTextField();
    address = new JTextField();
    department = new JTextField();
    studPassword = new JTextField();
    Fname.setBounds(150, 50, 120, 25);
    Lname.setBounds(150, 80, 120, 25);
    address.setBounds(150, 110, 120, 25);
    department.setBounds(150, 140, 120, 25);
    studPassword.setBounds(150, 170, 120, 25);
    add(Fname);
    add(Lname);
    add(address);
    add(department);  
    add(studPassword);  

       
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
                DataBase.studentDataBase.insertStudent(Fname.getText(), Lname.getText(), address.getText(), department.getText(), Integer.parseInt(studPassword.getText()));
                JOptionPane.showMessageDialog(null, "Student Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
        
        
         if (e.getSource()==del) {
            try {
                DataBase.studentDataBase.DeleteStudent(Fname.getText());
                JOptionPane.showMessageDialog(null, "Student Has Been Deleted Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
         
         
        
        
        
        if (e.getSource()== Pervious) {
            new FirstScreen().showFirstScreen();
            }
    }
    
    
}
