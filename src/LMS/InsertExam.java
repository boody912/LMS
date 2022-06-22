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
public class InsertExam extends  JPanel implements ActionListener {
    
   
     
    JLabel examIdLabel , stdIdLabel , cNameLabel , tMarksLabel , obtMarksLabel , dateLabel , startTimeLabel , endTimeLabel , examTimeLabel , statusLabel,headLabel ;
    JTextField examId , stdId , cName , tMarks , obtMarks , date , startTime , endTime , examTime , status ;
    JButton send , del,update;
    JButton Pervious = new JButton("Previous");
            
    public InsertExam(){
    this.setLayout(null);
   
    // ... in .. FnameLapel , LnameLabel , addressLapel and departmentLapel
    headLabel = new JLabel("Add Exams");
    examIdLabel = new JLabel("Exam Id");
    stdIdLabel = new JLabel("Student Id");
    cNameLabel = new JLabel("Course Name");
    tMarksLabel = new JLabel("TotalMark"); 
    obtMarksLabel = new JLabel("Class Work");
    dateLabel = new JLabel("Date");
    startTimeLabel = new JLabel("Start Time");
    endTimeLabel = new JLabel("End Time");
    examTimeLabel = new JLabel("Exam Time");
    statusLabel = new JLabel("Status");
    
     headLabel.setBounds(50, 20, 100, 35);
    examIdLabel.setBounds(50, 50, 80, 25);
    stdIdLabel.setBounds(50, 80, 80, 25);
    cNameLabel.setBounds(50, 110, 80, 25);
    tMarksLabel.setBounds(50, 140, 80, 25);
    obtMarksLabel.setBounds(50, 170, 80, 25);
    dateLabel.setBounds(50, 200, 80, 25);
    startTimeLabel.setBounds(50, 230, 80, 25);
    endTimeLabel.setBounds(50, 260, 80, 25);
    examTimeLabel.setBounds(50, 290, 80, 25);
    statusLabel.setBounds(50, 320, 80, 25);
    
    add(headLabel);
    add(examIdLabel);
    add(stdIdLabel);
    add(cNameLabel);
    add(tMarksLabel);
    add(obtMarksLabel);  
    add(dateLabel); 
    add(startTimeLabel); 
    add(endTimeLabel); 
    add(examTimeLabel); 
    add(statusLabel); 
    

    
    // ... in .. Fname , Lname , adress ,  department textfield
    
    
    examId = new JTextField();
    stdId = new JTextField();
    cName = new JTextField();
    tMarks = new JTextField();
    obtMarks = new JTextField();
    date = new JTextField();
    startTime = new JTextField();
    endTime = new JTextField();
    examTime = new JTextField();
    status = new JTextField();
   
    
    examId.setBounds(150, 50, 120, 25);
    stdId.setBounds(150, 80, 120, 25);
    cName.setBounds(150, 110, 120, 25);
    tMarks.setBounds(150, 140, 120, 25);
    obtMarks.setBounds(150, 170, 120, 25);
    date.setBounds(150, 200, 120, 25);
    startTime.setBounds(150, 230, 120, 25);
    endTime.setBounds(150, 260, 120, 25);
    examTime.setBounds(150, 290, 120, 25);
    status.setBounds(150, 320, 120, 25);
    
    add(examId);
    add(stdId);
    add(cName);
    add(tMarks);  
    add(obtMarks);  
    add(date);
    add(startTime);
    add(endTime);
    add(examTime);
    add(status);
    

       
    // .... in ...send data button
    send = new JButton("Submit");
    send.setBackground(Color.LIGHT_GRAY);
    send.setForeground(Color.blue);
    send.setBounds(120, 364, 80, 25);
    add(send);                                 
    send.addActionListener(this);
    
     // .... in ...delete data button
    del = new JButton("Delete");
    del.setBackground(Color.LIGHT_GRAY);
    del.setForeground(Color.blue);
    del.setBounds(220, 364, 80, 25);
    add(del);
    del.addActionListener(this);
    
    
    // .... in ...delete data button
     update = new JButton("modify");
     update.setBackground(Color.LIGHT_GRAY);
     update.setForeground(Color.blue);
     update.setBounds(320, 364, 90, 25);
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
                DataBase.ExamsDataBase.insertExams(Integer.parseInt(examId.getText()) , stdId.getText() , cName.getText() , tMarks.getText() , obtMarks.getText() , date.getText() , startTime.getText() , endTime.getText() , examTime.getText() , status.getText());
                JOptionPane.showMessageDialog(null, "Exam Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
        
         if (e.getSource()==del) {
            try {                                                           
                DataBase.ExamsDataBase.DeleteExams(Integer.parseInt(examId.getText()));
                JOptionPane.showMessageDialog(null, "Exam Has Been Deleted Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
         
         if (e.getSource()==update) {
            try {                                                           
                DataBase.ExamsDataBase.UpdateExams(Integer.parseInt(examId.getText()) , stdId.getText() , cName.getText() , tMarks.getText() , obtMarks.getText() , date.getText() , startTime.getText() , endTime.getText() , examTime.getText() , status.getText());
                JOptionPane.showMessageDialog(null, "Exam Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
        
        
        if (e.getSource()== Pervious) {
            new FirstScreen().showFirstScreen();
            }
    }
    
}
