/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import static DataBase.DegreeDataBase.connect;
import static DataBase.administratorDataBase.connect;
import domain.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */

public class studentDataBase {
    
    int curId = 0;
    
    public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
     
    public static void insertStudent(String Fname ,String Lname ,String adress ,String  department , int studPassword) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into student (Fname , Lname , address ,  department , studPassword) values(?,?,?,?,?)");
        p.setString(1, Fname);
        p.setString(2, Lname);
        p.setString(3, adress);
        p.setString(4, department);
        p.setInt(5, studPassword);
        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
    
     public static void DeleteStudent (String fname) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from student where fname =?");
        p.setString(1, fname);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
     
      public static void UpdateDegree(int id, String Fname, String Lname, String adress, String department , String studPassword) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update degree set Fname =? ," + "Lname = ?," +  "adress = ?," +  "department = ?," +  "studPassword = ?" +  " where id = "+id+" ");
        p.setString(1, Fname);
        p.setString(2, Lname);
        p.setString(3, adress);
        p.setString(4, department);
        p.setString(5, studPassword);
  
        
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
     
     
     
    
    public static ArrayList<student> getDataStudent(){
    
        ArrayList<student> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from student");
        ResultSet r  = p.executeQuery();
            while (r.next()) {
               list.add(new student(r.getInt("id"),r.getString("fname"),r.getString("lname"),r.getString("address"),r.getString("department"),r.getString("studPassword")));
        }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
    public static int CheckStudent(String fname, String studPassword) {
        ArrayList<student> arr = getDataStudent();
        int x = 0;  
        int i =0;
        int y =0;
        int ar[] = new int[2];
        
        
      
        do {
            if (arr.get(i).getFname().equalsIgnoreCase(fname)){
                if (arr.get(i).getStudPassword().equalsIgnoreCase(studPassword)){
                    x = 1;
                    y = arr.get(i).getId();
                    System.out.println("id is :" + y);
                    ar[0]= x;
                    ar[1] =  y;
                    break;
                }
                else{
                    x = 2;
                    break;
                }
            }
            else {
                x =3;             
            }                        
            
            i++;
        } while (i < arr.size());
        
       
     
    return x ;
      
    
        
    }
        
}
