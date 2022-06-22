/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import DataBase.QuestionDataBase;
import LMS.FirstScreen;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ShowExams  extends  JPanel implements ActionListener{
 //   JTable  table;
 //   JScrollPane  sc;
   // String  []header = { "Course Name" , "Total Mark" , "Credit Hours"};  
    JCheckBox q2,q3,q4,q5,q7,q8,q9,q10,q12,q13,q14,q15,q17,q18,q19,q20; 
    String data1 , data2 ,data3 ,data4 ,data5 ,data6,data7,data8,data9,data10,data11,data12,data13,data14,data15,data16,data17,data18,data19,data20 ;
    JLabel q1,q6,q11,q16;
    ArrayList<domain.Questions> arr = DataBase.QuestionDataBase.getDataQuestions(4) ;
    JButton Pervious = new JButton("Previous");
    // JLabel m1,m2,m3,m4,m5,m6;
    int x;

     public  ShowExams(){
        this.setLayout(null);
       
       setVisible(true);
    
       
        showExam();
      
        // ... in .. send and back button
        Pervious.setBackground(Color.orange);
        Pervious.setForeground(Color.black);
        Pervious.setBounds(1100, 500, 150, 25);
        add(Pervious);
        Pervious.addActionListener(this); 
         
 
    }
    public  void showExam(){
         //... initialize
        //System.out.println(QuestionDataBase.getDataQuestions(1)); 
        
        for (int i = 0 ; i < arr.size() ; i++) { 
            arr = DataBase.QuestionDataBase.getDataQuestions(1);
            data1 = String.valueOf(arr.get(i).getQuestion()); 
            q1 = new JLabel(data1);
            q1.setBounds(50, 10, 500, 25);
            add(q1);
            data2 = String.valueOf(arr.get(i).getOpt1()); 
            q2 = new JCheckBox(data2);
            q2.setBounds(50, 50, 125, 25);
            add(q2);
            q2.addActionListener(this);
            
            
            data3 = String.valueOf(arr.get(i).getOpt2()); 
            q3 = new JCheckBox(data3);
            q3.setBounds(175, 50, 125, 25);
            add(q3);
            q3.addActionListener(this);
            
            data4 = String.valueOf(arr.get(i).getOpt3()); 
            q4 = new JCheckBox(data4);
            q4.setBounds(300, 50, 125, 25);
            add(q4);
            q4.addActionListener(this);
            
            data5 = String.valueOf(arr.get(i).getOpt4()); 
            q5 = new JCheckBox(data5);
            q5.setBounds(425, 50, 125, 25);
            add(q5);
            q5.addActionListener(this);
            
        }
        
        
         for (int i = 0 ; i < arr.size() ; i++) { 
            arr = DataBase.QuestionDataBase.getDataQuestions(2);
            data6 = String.valueOf(arr.get(i).getQuestion()); 
            q6 = new JLabel(data6);
            q6.setBounds(50, 100, 1000, 25);
            add(q6);
            
            data7 = String.valueOf(arr.get(i).getOpt1()); 
            q7 = new JCheckBox(data7);
            q7.setBounds(50, 150, 125, 25);
            add(q7);
            q7.addActionListener(this);
            
            data8 = String.valueOf(arr.get(i).getOpt2()); 
            q8 = new JCheckBox(data8);
            q8.setBounds(175, 150, 125, 25);
            add(q8);
            q8.addActionListener(this);
            
            data9 = String.valueOf(arr.get(i).getOpt3()); 
            q9 = new JCheckBox(data9);
            q9.setBounds(300, 150, 125, 25);
            add(q9);
            q9.addActionListener(this);
            
            data10 = String.valueOf(arr.get(i).getOpt4()); 
            q10 = new JCheckBox(data10);
            q10.setBounds(425, 150, 125, 25);
            add(q10);
            q10.addActionListener(this);
        }


          for (int i = 0 ; i < arr.size() ; i++) { 
            arr = DataBase.QuestionDataBase.getDataQuestions(3);
            data11 = String.valueOf(arr.get(i).getQuestion()); 
            q11 = new JLabel(data11);
            q11.setBounds(50, 200, 1000, 25);
            add(q11);
            
            data12 = String.valueOf(arr.get(i).getOpt1()); 
            q12 = new JCheckBox(data12);
            q12.setBounds(50, 250, 125, 25);
            add(q12);
            q12.addActionListener(this);
            
            data13 = String.valueOf(arr.get(i).getOpt2()); 
            q13 = new JCheckBox(data13);
            q13.setBounds(175, 250, 125, 25);
            add(q13);
            q13.addActionListener(this);
            
            data14 = String.valueOf(arr.get(i).getOpt3()); 
            q14 = new JCheckBox(data14);
            q14.setBounds(300, 250, 125, 25);
            add(q14);
            q14.addActionListener(this);
            
            data15 = String.valueOf(arr.get(i).getOpt4()); 
            q15 = new JCheckBox(data15);
            q15.setBounds(425, 250, 125, 25);
            add(q15);
            q15.addActionListener(this);
        }



           for (int i = 0 ; i < arr.size() ; i++) { 
            arr = DataBase.QuestionDataBase.getDataQuestions(4);
            data16 = String.valueOf(arr.get(i).getQuestion()); 
            q16 = new JLabel(data16);
            q16.setBounds(50, 300, 1000, 25);
            add(q16);
            
            data17 = String.valueOf(arr.get(i).getOpt1()); 
            q17 = new JCheckBox(data15);
            q17.setBounds(50, 350, 125, 25);
            add(q17);
            q17.addActionListener(this);
            
            data18 = String.valueOf(arr.get(i).getOpt2()); 
            q18 = new JCheckBox(data18);
            q18.setBounds(175, 350, 125, 25);
            add(q18);
            q18.addActionListener(this);
            
            data19 = String.valueOf(arr.get(i).getOpt3()); 
            q19 = new JCheckBox(data19);
            q19.setBounds(300, 350, 125, 25);
            add(q19);
            q10.addActionListener(this);
            
            data20 = String.valueOf(arr.get(i).getOpt4()); 
            q20 = new JCheckBox(data20);
            q20.setBounds(425, 350, 135, 25);
            add(q20);
            q20.addActionListener(this);
        }
 
}

    @Override
    public void actionPerformed(ActionEvent e) {
       
//        float amount=0;  
//        String msg="";  

        if (e.getSource() == Pervious) {
            
            new FirstScreen().showFirstScreen();
        }
       
        if(e.getSource() == q2){  
          DataBase.QuestionDataBase.CheckAnswers(data2);
          if(x==1){
              System.out.println("right");
          }if(x==2){
              System.out.println("rong");
          }
        }  
        
        
        
//        if(q3.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q4.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q5.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//       
//        if(q7.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q8.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q9.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q10.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//       
//        if(q12.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q13.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q14.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q15.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//       
//        if(q17.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q18.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q19.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        if(q20.isSelected()){  
//            amount+=1;  
//            msg+="Each choice ONE degree";  
//        }  
//        msg+="-----------------\n";  
//        //JOptionPane.showMessageDialog(this,msg+"Total: "+amount);
//    }
}
}
