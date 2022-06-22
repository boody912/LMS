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
public class InsertQuestion  extends  JPanel implements ActionListener {
   
    JLabel questionIdLabel , questionLabel , opt1Label , opt2Label , opt3Label , opt4Label , correctLabel , courseNameLabel ,headlabel ;
    JTextField questionId , question , opt1 , opt2 , opt3 , opt4 , correct , courseName ;
    JButton send,del,update;
    JButton Pervious = new JButton("Previous");
            
    public InsertQuestion(){
    this.setLayout(null);
   
    // ... in .. FnameLapel , LnameLabel , addressLapel and departmentLapel
    headlabel = new JLabel("Add Question");
    questionIdLabel = new JLabel("question Id");
    questionLabel = new JLabel("Question");
    opt1Label = new JLabel("Option 1 ");
    opt2Label = new JLabel("Option 2");
    opt3Label = new JLabel("Option 3");
    opt4Label = new JLabel("Option 4");
    correctLabel = new JLabel("Correct Opt");
    courseNameLabel = new JLabel("Course Name");
    
    headlabel.setBounds(50, 20, 100, 35);
    questionIdLabel.setBounds(50, 50, 80, 25);
    questionLabel.setBounds(50, 80, 80, 25);
    opt1Label.setBounds(50, 110, 80, 25);
    opt2Label.setBounds(50, 140, 80, 25);
    opt3Label.setBounds(50, 170, 80, 25);
    opt4Label.setBounds(50, 200, 80, 25);
    correctLabel.setBounds(50, 230, 80, 25);
    courseNameLabel.setBounds(50, 260, 80, 25);
    
    add(headlabel);
    add(questionIdLabel);
    add(questionLabel);
    add(opt1Label);
    add(opt2Label);
    add(opt3Label);
    add(opt4Label);
    add(correctLabel);
    add(courseNameLabel);
    
     

    
    // ... in .. Fname , Lname , adress ,  department textfield
    questionId = new JTextField();
    question = new JTextField();
    opt1 = new JTextField();
    opt2 = new JTextField();
    opt3 = new JTextField();
    opt4 = new JTextField();
    correct = new JTextField();
    courseName = new JTextField();
    
    questionId.setBounds(150, 50, 120, 25);
    question.setBounds(150, 80, 120, 25);
    opt1.setBounds(150, 110, 120, 25);
    opt2.setBounds(150, 140, 120, 25);
    opt3.setBounds(150, 170, 120, 25);
    opt4.setBounds(150, 200, 120, 25);
    correct.setBounds(150, 230, 120, 25);
    courseName.setBounds(150, 260, 120, 25);
       
    add(questionId);
    add(question);
    add(opt1);
    add(opt2);
    add(opt3);
    add(opt4);
    add(correct);
    add(courseName);
    

       
    // .... in ...send data button
    send = new JButton("Submit");
    send.setBackground(Color.LIGHT_GRAY);
    send.setForeground(Color.blue);
    send.setBounds(120, 300, 80, 25);            
    add(send);
    send.addActionListener(this);
    
    // .... in ...delete data button
     del = new JButton("Delete");
     del.setBackground(Color.LIGHT_GRAY);
     del.setForeground(Color.blue);
     del.setBounds(220, 300, 80, 25);
     add(del);
     del.addActionListener(this);
     
     
     // .... in ...delete data button
     update = new JButton("modify");
     update.setBackground(Color.LIGHT_GRAY);
     update.setForeground(Color.blue);
     update.setBounds(320, 300, 90, 25);
     add(update);
     update.addActionListener(this);
    
    
    
   // ... in .. send and back button
        Pervious.setBackground(Color.orange);
        Pervious.setForeground(Color.black);
        Pervious.setBounds(860, 490, 150, 25);
        add(Pervious);
        Pervious.addActionListener(this);   
        
        ////
        
        
    
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==send) {
            try {
                DataBase.QuestionDataBase.insertQuestions(Integer.parseInt(questionId.getText()), question.getText(),opt1.getText(),opt2.getText(),opt3.getText(),opt4.getText(),correct.getText(),courseName.getText());
                JOptionPane.showMessageDialog(null, "Course Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
        
        
        if (e.getSource()==del) {
            try {
                DataBase.QuestionDataBase.DeleteQuestion(Integer.parseInt(questionId.getText()));
                JOptionPane.showMessageDialog(null, "Course Has Been Deleted Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
        
        
         if (e.getSource()==update) {
            try {
                DataBase.QuestionDataBase.UpdateQuestion(Integer.parseInt(questionId.getText()), question.getText(),opt1.getText(),opt2.getText(),opt3.getText(),opt4.getText(),correct.getText(),courseName.getText());
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
    

