/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentView;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author pc
 */
public class StudentView extends  JFrame{
   JTabbedPane tab;
   
   ShowDeg v1;;
   ShowCourses v2;
   ShowExamsTable v3;
   ShowExams v4;
   
   public StudentView()
   {
        
   }
   public void showStudentScreen()
   {
       
       v1 = new ShowDeg();
       v2 = new ShowCourses();
       v3 = new ShowExamsTable();
       v4 = new ShowExams();
               
               
      //...in ...main form for project
      setTitle("student");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setSize(1366, 620);
      setVisible(true);
      tab= new JTabbedPane(); 
    
     
      tab.addTab("show Degree", v1);
      tab.addTab("show Courses", v2);
      tab.addTab("show Exams Table", v3);
      tab.addTab("show Exams", v4);

    
   
      add(tab);
      
     
   }
    
}
