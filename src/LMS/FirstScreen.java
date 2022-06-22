/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import AdminView.admin;
import StudentView.StudentView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import DataBase.UserDataBase;

/**
 *
 * @author pc
 */
public class FirstScreen extends JFrame implements  ActionListener{
    JLabel user,pass,note1,note2;
    JTextField userName;
    JPasswordField password;
    JButton signIn ;
   // String[] data; 
   imagePanel ii  = new imagePanel();
  
    public FirstScreen(){
        
    }
    public void showFirstScreen (){      
        // ... in .. user and password label
        user = new JLabel ("user name");
        pass = new JLabel ("password");
        user.setBounds(150, 140, 200, 40);
        pass.setBounds(150, 200, 200, 40);
        ii.add(user);
        ii.add(pass);
        
        // ... in .. user and password taxtfield
        userName = new JTextField();
        password = new JPasswordField();
        userName.setBounds(250, 140, 200, 40);
        password.setBounds(250, 200, 200, 40);
        ii.add(userName);
        ii.add(password);
        
        // ... in .. signin and signup button
        signIn = new JButton("sign in");
        signIn.setBounds(150, 290, 100, 30);
        ii.add(signIn);
        signIn.addActionListener(this);
       

        

        //...in ...main form for project
        setTitle("uni staff");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1366, 620);
        setVisible(true);
        add(ii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== signIn) {
           
        int  i =   DataBase.UserDataBase.CheckUser(userName.getText(), password.getText());
        switch (i) {
                case 1:
                   this.dispose();
                   new doctor().showDoctorScreen();
                   break;
                case 2:
                JOptionPane.showMessageDialog(null, "password is wrong, try again", "error", JOptionPane.INFORMATION_MESSAGE);
                   break;               
           }
         
//         int ar[] = new int[2];
//        ar[0]= j;
//        ar[1] =y;
         int j =   DataBase.studentDataBase.CheckStudent(userName.getText(), password.getText());
         
        
         switch (j) {
                case 1:
                   this.dispose();
                   new StudentView().showStudentScreen();
                   break;
                case 2:
                JOptionPane.showMessageDialog(null, "password is wrong, try again", "error", JOptionPane.INFORMATION_MESSAGE);
                   break;           
               
           }
         
         int  k =   DataBase.administratorDataBase.CheckAdmin(userName.getText(), password.getText());
         switch (k) {
                case 1:
                   this.dispose();
                   new admin().showAdminScreen();
                   break;
                case 2:
                JOptionPane.showMessageDialog(null, "password is wrong, try again", "error", JOptionPane.INFORMATION_MESSAGE);
                   break;           
               
           }
        
           if (i == 3 && j == 3 && k == 3) {
               JOptionPane.showMessageDialog(null, "user is not found", "error", JOptionPane.INFORMATION_MESSAGE);
           }
           
           
           
                 
                     
       }
      
       
       }
    
}
    

