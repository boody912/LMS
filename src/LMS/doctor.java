/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author asus
 */

public class doctor extends JFrame  implements ActionListener{
   JTabbedPane tab;
   UpdateDegree d1;
   InsertCourse d2;
   InsertExam d3;
   InsertQuestion d4;
   InsertAnswers d5;
   JButton back;
   imagePanel2 ii  = new imagePanel2();
   
   public doctor()
   {

   }
   public void showDoctorScreen()
   {
     
      d1 = new UpdateDegree();
      d2 = new InsertCourse();
      d3 = new InsertExam();
      d4 = new InsertQuestion();
      d5 = new InsertAnswers();
//      
//      d1.setBackground(Color.cyan);
//      d2.setBackground(Color.cyan);
//      d3.setBackground(Color.cyan);
//      d4.setBackground(Color.cyan);
//      d5.setBackground(Color.cyan);
      
      
      
      
           
      //...in ...main form for project
    
      setTitle("Doctor");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setSize(1366, 620);
      setVisible(true);
      
      //setBackground(Color.cyan);
      //setBackground(Color.cyan);
     
      setVisible(true);
      
      //tab.setBackground(Color.CYAN);
      tab= new JTabbedPane(); 
      tab.addTab("Degree", d1);
      tab.addTab("courses", d2);
      tab.addTab("exams", d3);
      tab.addTab("Question", d4);
      tab.addTab("Answers", d5);
      
      tab.setBackground(Color.cyan);
      add(tab);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}