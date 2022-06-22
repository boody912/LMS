/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import static DataBase.UserDataBase.connect;
import domain.admin;
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
public class administratorDataBase {
    
    public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
     
    public static void insertAdmin(int id, String name ,String pass) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into administrator (id , name , pass ) values(?,?,?)");
        p.setInt(1, id);
        p.setString(2, name);
        p.setString(3, pass);
        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
     public static void DeleteAdmin (int id) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from administrator where id =?");
        p.setInt(1, id);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
     
     
      public static void UpdateAdmin (int id , String name ,String pass) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update administrator set name =? ," + "pass = ?" + " where id = "+id+" ");
        p.setString(1, name);
        p.setString(2, pass);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
    public static ArrayList<admin> getAdmin(){
    
        ArrayList<admin> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from administrator");
        ResultSet r  = p.executeQuery();
            while (r.next()) {
               list.add(new admin(r.getInt("id"),r.getString("name"),r.getString("pass")));
        }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
    public static int CheckAdmin(String fname, String studPassword) {
        ArrayList<admin> arr = getAdmin();
        int x = 0;  
        int i =0;
      
        do {
            if (arr.get(i).getName().equalsIgnoreCase(fname)){
                if (arr.get(i).getPass().equalsIgnoreCase(studPassword)){
                    x = 1;
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
        
       
     
        return x;
        
    }
        
}
