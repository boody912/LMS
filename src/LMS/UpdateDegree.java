/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;


import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pc
 */
public  class UpdateDegree extends  JPanel implements ActionListener{
    
    JTable table;
    JScrollPane sc;
    String data [] [];
    ArrayList<domain.student> arr = DataBase.studentDataBase.getDataStudent();
    String  []header = {"id","fname","lname"};       
    JLabel m1,m2,m3,m4,m5,m6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton addDegree ,del ,update ;
    JButton Pervious = new JButton("Previous");
    int x;
    public UpdateDegree (){
        this.setLayout(null);
       
        ShowTable();
         // ... in .. send and back button
        Pervious.setBackground(Color.orange);
        Pervious.setForeground(Color.black);
        Pervious.setBounds(1100, 500, 150, 25);
        add(Pervious);
        Pervious.addActionListener(this); 
   
        
            
   
    }
    
    public  void ShowTable (){
    //initialize table
        data = new String[arr.size()][3];
        
        for (int i = 0 ; i < arr.size() ; i++) {       
            data[i][0] = "" + arr.get(i).getId();
            data[i][1] = arr.get(i).getFname();
            data[i][2] = arr.get(i).getLname();        
        }
        table = new JTable(data , header);
//        table.setBackground(Color.cyan);
        sc = new JScrollPane(table);
        sc.setBounds(0, 0, 1060, 620);
    
        add(sc);
        //intialize UpdateDegree label, button and textfield
        m1=new JLabel ("PL");
        m2=new JLabel ("DS");
        m3=new JLabel ("DC");
        m4=new JLabel ("LD");
        m5=new JLabel ("HR");
        m6=new JLabel ("DB");
        m1.setBounds(1070, 20, 80, 25);
        m2.setBounds(1070, 50, 80, 25);
        m3.setBounds(1070, 80, 80, 25);
        m4.setBounds(1070, 110, 80, 25);
        m5.setBounds(1070, 140, 80, 25);
        m6.setBounds(1070, 170, 80, 25);
        add(m1);add(m2);add(m3);add(m4);add(m5);add(m6);
        //
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t1.setBounds(1120, 20, 80, 25);
        t2.setBounds(1120, 50, 80, 25);
        t3.setBounds(1120, 80, 80, 25);
        t4.setBounds(1120, 110, 80, 25);
        t5.setBounds(1120, 140, 80, 25);
        t6.setBounds(1120, 170, 80, 25);
        add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);
        addDegree=new JButton("Insert Degree");
        addDegree.setBounds(1100, 220, 130, 20);
        addDegree.setBackground(Color.LIGHT_GRAY);
        addDegree.setForeground(Color.blue);
        add(addDegree);
        addDegree.addActionListener(this);
        
         // .... in ...delete data button
         del = new JButton("Delete");
         del.setBackground(Color.LIGHT_GRAY);
         del.setForeground(Color.blue);
         del.setBounds(1100, 260, 130, 20);
         add(del);
         del.addActionListener(this);
         
        // .... in ...update data button
        update = new JButton("modify");
        update.setBackground(Color.LIGHT_GRAY);
        update.setForeground(Color.blue);
        update.setBounds(1100, 300, 130, 20);
        add(update);
        update.addActionListener(this);
          
        //configuration table
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
        
        //configuration event table
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
        if (e.getSource() == addDegree){
        try {
            DataBase.DegreeDataBase.insertDegree((table.getSelectedRow()+1), Integer.parseInt(t1.getText()) ,Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
            JOptionPane.showMessageDialog(null, "degree Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        
        if (e.getSource() == del){
        try {
            DataBase.DegreeDataBase.DeleteDegree((table.getSelectedRow()+1));
            JOptionPane.showMessageDialog(null, "degree Has Been deleted Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
         
        if (e.getSource() == update){
        try {
            DataBase.DegreeDataBase.UpdateDegree((table.getSelectedRow()+1), Integer.parseInt(t1.getText()) ,Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
            JOptionPane.showMessageDialog(null, "degree Has Been added Successfully.", "Attention", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
         
        if (e.getSource() == Pervious) {
            
            new FirstScreen().showFirstScreen();
        }
    }
        
        
    }

    
    

