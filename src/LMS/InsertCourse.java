/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

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

public class InsertCourse extends  JPanel implements ActionListener{
    JLabel cNameLabel , tMarksLabel , timeLabel ,headLabel,idlabel ;
    JTextField cName , tMarks  ,  time , id ;
    JButton send;
    JButton del,update;
    JButton Pervious = new JButton("Previous");
    imagePanel ii  = new imagePanel();
   
  
            
    public InsertCourse(){
    this.setLayout(null);
   
    // ... in .. FnameLapel , LnameLabel , addressLapel and departmentLapel
    headLabel = new JLabel("Add courses");
    idlabel = new JLabel("Course id");
    cNameLabel = new JLabel("Course Name");
    tMarksLabel = new JLabel("Total Mark");
    timeLabel = new JLabel("Credit Hours");
    
    headLabel.setBounds(50, 20, 100, 35);
    idlabel.setBounds(50, 50, 80, 25);
    cNameLabel.setBounds(50, 80, 80, 25);
    tMarksLabel.setBounds(50, 110, 80, 25);
    timeLabel.setBounds(50, 140, 80, 25);
    
//    cNameLabel.setBackground(Color.red); 
//    tMarksLabel.setBackground(Color.white); 
//    timeLabel.setBackground(Color.white); 
//    headLabel.setBackground(Color.white);
//    idlabel.setBackground(Color.white);
    
    add(headLabel);
    add(idlabel);
    add(cNameLabel);
    add(tMarksLabel);
    add(timeLabel);
     

    
    // ... in .. Fname , Lname , adress ,  department textfield
    id =  new JTextField();
    cName = new JTextField();
    tMarks = new JTextField();
    time = new JTextField();
    
    id.setBounds(150, 50, 120, 25);
    cName.setBounds(150, 80, 120, 25);
    tMarks.setBounds(150, 110, 120, 25);
    time.setBounds(150, 140, 120, 25);
    
    add(id);
    add(cName);
    add(tMarks);
    add(time);
  
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
                DataBase.CoursesDataBase.insertCourses(Integer.parseInt(id.getText()),cName.getText(),Integer.parseInt(tMarks.getText()), time.getText());
                JOptionPane.showMessageDialog(null, "Course Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
         if (e.getSource()==del) {
            try {
                DataBase.CoursesDataBase.DeleteCourses(Integer.parseInt(id.getText()));
                JOptionPane.showMessageDialog(null, "Course Has Been Deleted Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
          if (e.getSource()==update) {
            try {
                DataBase.CoursesDataBase.UpdateCourses(Integer.parseInt(id.getText()),cName.getText(),Integer.parseInt(tMarks.getText()), time.getText());
                JOptionPane.showMessageDialog(null, "Course Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
        if (e.getSource()== Pervious) {
            new FirstScreen().showFirstScreen();
            }
    }

  
    
    
}
