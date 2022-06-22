/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentView;

import LMS.FirstScreen;
import java.awt.Color;
import java.awt.Component;
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
public class ShowDeg extends  JPanel implements ActionListener {
    
    
    
    
    JTable  table2;
    JTable  table;
    JLabel inf1 , inf2 , inf3 , inf4 , inf5 , inf6 ;
    JScrollPane  sc2;
    JScrollPane  sc;
    String  []header2 = {"id", "pl" , "ds" , "db" , "dc" , "ld" , "hr","sum"};  
    String  []header = { "Fname" , "Lname" , "address" ,  "department" , "studPassword"};  
    String data2 [] [];
    String data [] [];
    ArrayList<domain.degree> arr2 = DataBase.DegreeDataBase.getDatadegree();
    ArrayList<domain.student> arr = DataBase.studentDataBase.getDataStudent();
    JButton Pervious = new JButton("Previous");
    // JLabel m1,m2,m3,m4,m5,m6;
    int x;
    public  ShowDeg(){
        this.setLayout(null);
        ShowTable2();
        showTable();
        // ..... student info
        data = new String[1][6];
        // ... in .. send and back button
        Pervious.setBackground(Color.orange);
        Pervious.setForeground(Color.black);
        Pervious.setBounds(1100, 500, 150, 25);
        add(Pervious);
        Pervious.addActionListener(this); 
         
 
    }
    public  void showTable (){
         //... initialize
        data = new String[arr.size()][5];
        
        for (int i = 0 ; i < arr.size() ; i++) { 
           
            data[i][0] = String.valueOf(arr.get(i).getFname()); 
            data[i][1] = String.valueOf(arr.get(i).getLname()); 
            data[i][2] = String.valueOf(arr.get(i).getAdress()); 
            data[i][3] = String.valueOf(arr.get(i).getDepartment()); 
            data[i][4] = String.valueOf(arr.get(i).getStudPassword()); 
        }
            
        table = new JTable(data , header);
        sc = new JScrollPane(table);
        sc.setBounds(739, 0,607 , 490);
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
    
    public  void ShowTable2 (){  
       //initialize table
       
        data2 = new String[arr2.size()][8];
        for (int i = 0 ; i < arr2.size() ; i++) {   
            
            data2[i][0] = String.valueOf(arr2.get(i).getId()); 
            data2[i][1] = String.valueOf(arr2.get(i).getM1()); 
            data2[i][2] = String.valueOf(arr2.get(i).getM2()); 
            data2[i][3] = String.valueOf(arr2.get(i).getM3()); 
            data2[i][4] = String.valueOf(arr2.get(i).getM4()); 
            data2[i][5] = String.valueOf(arr2.get(i).getM5()); 
            data2[i][6] = String.valueOf(arr2.get(i).getM6()); 
            data2[i][7] = String.valueOf(arr2.get(i).getSum()); 

            
        }
     
       table2 = new JTable(data2 , header2);
       sc2 = new JScrollPane(table2);
       sc2.setBounds(0, 0, 740, 620);
       add(sc2);
       
        
       
        //configuration table2
        ((DefaultTableCellRenderer)table2.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer z= new DefaultTableCellRenderer();
        z.setHorizontalAlignment(JLabel.CENTER);
        table2.getColumnModel().getColumn(0).setCellRenderer(z);
        for(int i=0;i<table2.getColumnCount();i++)
        {
            table2.getColumnModel().getColumn(i).setCellRenderer(z);
        }
        table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        //configuration event table2
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                ttmouseClicked(evt);
            }
        });
    }
    
    private void ttmouseClicked(java.awt.event.MouseEvent evt)
        {
            System.out.println("Selected Row is: -> "+(table2.getSelectedRow()+1));
         
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == Pervious) {
            
            new FirstScreen().showFirstScreen();
        }
    }

   

   
    
}
    

