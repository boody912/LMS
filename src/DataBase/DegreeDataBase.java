/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

//import static DataBase.studentDataBase.connect;
import static DataBase.QuestionDataBase.connect;
import static DataBase.studentDataBase.connect;
import domain.degree;
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
public class DegreeDataBase {
       
    public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
    
     public static void insertDegree(int id , int m1 , int m2 , int m3 , int m4 , int m5 , int m6 ) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into degree values(?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setInt(2, m1);
        p.setInt(3, m2);
        p.setInt(4, m3);
        p.setInt(5, m4);
        p.setInt(6, m5);
        p.setInt(7, m6);
        p.setInt(8, m1+m2+m3+m4+m5+m6);

        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    public static void DeleteDegree(int id) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from degree where id =?");
        p.setInt(1, id);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
    
     public static void UpdateDegree(int id, int m1, int m2, int m3, int m4, int m5, int m6) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update degree set m1 =? ," + "m2 = ?," +  "m3 = ?," +  "m4 = ?," +  "m5 = ?," +  "m6 = ?" +  " where id = "+id+" ");
        p.setInt(1, m1);
        p.setInt(2, m2);
        p.setInt(3, m3);
        p.setInt(4, m4); 
        p.setInt(5, m5);
        p.setInt(6, m6);    
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
    
     
     public static ArrayList<degree> getDatadegree(){
    
        ArrayList<degree> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from degree");
        ResultSet r  = p.executeQuery();
            while (r.next()) {
               list.add(new degree (r.getInt("id"),r.getInt("m1"),r.getInt("m2"),r.getInt("m3"),r.getInt("m4"),r.getInt("m5"),r.getInt("m6"),r.getInt("sum")));
        }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
}
