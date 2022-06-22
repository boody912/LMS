/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;


import static DataBase.CoursesDataBase.connect;
import static DataBase.QuestionDataBase.connect;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.SQLException;
import  java.util.ArrayList;
import  java.sql.ResultSet;
import  domain.user;

public class UserDataBase {
    
    public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
    
    public static void insertUser(String user, String pass, String depart) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into user values(?,?,?)");
        p.setString(1, user);
        p.setString(2, pass);
        p.setString(3, depart);
        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
      public static void DeleteUser(String user) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from user where userName =?");
        p.setString(1, user);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
      
      
      public static void UpdateUsers(String userName, String password, String department) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update Courses set password=? ," + "department = ? " +  " where userName = " +userName+ " ");
        p.setString(1, password);
        p.setString(2, department);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
      
      
      
      
      
    public static ArrayList<user> getDataUser(){
    
        ArrayList<user> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from user");
        ResultSet r  = p.executeQuery();
            while (r.next()) {
               list.add(new user(r.getString("userName"),r.getString("password"),r.getString("department")));
        }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
    public static int CheckUser(String fname , String lname) {
        ArrayList<user> arr = getDataUser();
        int x = 0;  
        int i =0;
      
        do {
            if (arr.get(i).getUserName().equalsIgnoreCase(fname)){
                if (arr.get(i).getPassword().equalsIgnoreCase(lname)){
                     x = 1;
                     break;
                }
                else{
                     x = 2;
                    break;
                }
            }
            else {
                x = 3;             
            }                        
            
            i++;
        } while (i < arr.size());
        
       
     
        return x;
        
    }

}

  
    

        
  
   
 
