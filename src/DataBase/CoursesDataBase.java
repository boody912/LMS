/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import static DataBase.AnswersDataBase.connect;
import domain.Courses;
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
public class CoursesDataBase {
     public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
    
    public static void insertCourses(int id , String cName, int tMarks, String time) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into Courses values(?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, cName);
        p.setInt(3, tMarks);
        p.setString(4, time);
   
        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    public static void DeleteCourses(int id) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from Courses where id =?");
        p.setInt(1, id);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
     public static void UpdateCourses(int id , String cName, int tMarks, String time) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update Courses set cName=? ," + "tMarks = ? ," +  "time = ?" +  " where id = " +id+ " ");
        p.setString(1, cName);
        p.setInt(2, tMarks);
        p.setString(3, time);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
    
    public static ArrayList<Courses> getDataCourses(){
    
        ArrayList<Courses> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from Courses");
        ResultSet r  = p.executeQuery();
            while (r.next()) {
               list.add(new Courses(r.getInt("id"), r.getString("cName") , r.getInt("tMarks") ,r.getString("time")));
        }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
}
