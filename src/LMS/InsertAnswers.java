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
 * @author asus
 */
public class InsertAnswers extends  JPanel implements ActionListener{
    JLabel idlabel,questionLabel, answerLabel, correctAnsLabel, statusLabel,headlabel;
    JTextField id,question, answer, correctAns, status;
    JButton send,del,update;
    JButton Pervious = new JButton("Previous");
            
    public InsertAnswers(){
    this.setLayout(null);
   
    // ... in .. FnameLapel , LnameLabel , addressLapel and departmentLapel
    headlabel = new JLabel("Add Answers");
    idlabel = new JLabel("Answers id");
    questionLabel = new JLabel("Question");
    answerLabel = new JLabel("Answer");
    correctAnsLabel = new JLabel("Correct Answer");
    statusLabel = new JLabel("Status");
    
   
    headlabel.setBounds(50, 20, 100, 35);
    idlabel.setBounds(50, 50, 100, 35);
    questionLabel.setBounds(50, 80, 80, 25);
    answerLabel.setBounds(50, 110, 110, 25);
    correctAnsLabel.setBounds(50, 140, 80, 25);
    statusLabel.setBounds(50, 170, 80, 25);
    
    add(idlabel);
    add(headlabel);
    add(questionLabel);
    add(answerLabel);
    add(correctAnsLabel);
    add(statusLabel);
     

    
    // ... in .. Fname , Lname , adress ,  department textfield
    id = new JTextField();
    question = new JTextField();
    answer = new JTextField();
    correctAns = new JTextField();
    status = new JTextField();
    
    id.setBounds(150, 50, 120, 25);
    question.setBounds(150, 80, 120, 25);
    answer.setBounds(150, 110, 120, 25);
    correctAns.setBounds(150, 140, 120, 25);
    status.setBounds(150, 170, 120, 25);
    
    add(id);
    add(question);
    add(answer);
    add(correctAns);
    add(status);
    

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
                DataBase.AnswersDataBase.insertAnswers(Integer.parseInt(id.getText()),question.getText(), answer.getText(), correctAns.getText(), status.getText());
                JOptionPane.showMessageDialog(null, "Answer has been added successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
         if (e.getSource()==del) {
            try {
                DataBase.AnswersDataBase.DeletAnswers(Integer.parseInt(id.getText()));
                JOptionPane.showMessageDialog(null, "Answer has been Deleted successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
     
          if (e.getSource()==update) {
            try {
                DataBase.AnswersDataBase.UpdateAnswer(Integer.parseInt(id.getText()),question.getText(), answer.getText(), correctAns.getText(), status.getText());
                JOptionPane.showMessageDialog(null, "Answer has been added successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());           
            }
            
            
        }
          
        if (e.getSource()== Pervious) {
            new FirstScreen().showFirstScreen();
            }
    }
}