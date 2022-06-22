/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentView;

import LMS.FirstScreen;
import java.awt.Color;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pc
 */
public class ShowCourses extends  JPanel implements ActionListener {
    
    
    
    
    JTable  table;
    JScrollPane  sc;
    String  []header = { "Course Name" , "Total Mark" , "Credit Hours"};  
    String data [] [];
    ArrayList<domain.Courses> arr = DataBase.CoursesDataBase.getDataCourses();
    JButton Pervious = new JButton("Previous");
    // JLabel m1,m2,m3,m4,m5,m6;
    int x;
    public  ShowCourses(){
        this.setLayout(null);
       
        showTable();
      
        // ... in .. send and back button
        Pervious.setBackground(Color.orange);
        Pervious.setForeground(Color.black);
        Pervious.setBounds(1100, 500, 150, 25);
        add(Pervious);
        Pervious.addActionListener(this); 
         
 
    }
    public  void showTable (){
         //... initialize
        data = new String[arr.size()][3];
        
        for (int i = 0 ; i < arr.size() ; i++) { 
           
            data[i][0] = String.valueOf(arr.get(i).getcName()); 
            data[i][1] = String.valueOf(arr.get(i).gettMarks()); 
            data[i][2] = String.valueOf(arr.get(i).getTime()); 
         
        }
            
        table = new JTable(data , header);
        sc = new JScrollPane(table);
        sc.setBounds(0,0,1000, 490);
        add(sc);
        
        //configuration table1
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v= new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for(int i=0;i<table.getColumnCount();i++)
        {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        //configuration event table1
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                ttmouseClicked(evt);
            }
        });
        
    
    }
    
    
    
    private void ttmouseClicked(java.awt.event.MouseEvent evt)
        {
            System.out.println("Selected Row is: -> "+(table.getSelectedRow()+1));
         
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == Pervious) {
           
            new FirstScreen().showFirstScreen();
        }
    }

   

   
    
}
    

