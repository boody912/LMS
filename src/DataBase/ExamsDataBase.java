/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import static DataBase.AnswersDataBase.connect;
import static DataBase.DegreeDataBase.connect;
import static DataBase.UserDataBase.getDataUser;
import domain.Exams;
import domain.user;
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
public class ExamsDataBase {
     public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
    
    public static void insertExams(int examId, String stdId,String cName, String tMarks, String obtMarks, String date, String startTime, String endTime, String examTime, String status) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into Exams values(?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, examId);
        p.setString(2, stdId);
        p.setString(3, cName);
        p.setString(4, tMarks);
        p.setString(5, obtMarks);
        p.setString(6, date);
        p.setString(7, startTime);
        p.setString(8, endTime);
        p.setString(9, examTime);
        p.setString(10, status);
        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    public static void DeleteExams(int examId) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from Exams where examId =?");
        p.setInt(1, examId);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
     public static void UpdateExams(int examId, String stdId , String cName, String tMarks, String obtMarks, String date, String startTime, String endTime, String examTime, String status) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update Exams set stdId =? ," + "cName = ?," +  "tMarks = ?," +  "obtMarks = ?," +  "date = ?," +  "startTime = ?," +  "endTime = ?," +  "examTime = ?," +  "status = ?" + " where examId = "+examId+" ");
        p.setString(1, stdId);
        p.setString(2, cName);
        p.setString(3, tMarks);
        p.setString(4, obtMarks);
        p.setString(5, date);
        p.setString(6, startTime);
        p.setString(7, endTime);
        p.setString(8, examTime);
        p.setString(9, status);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    public static ArrayList<Exams> getDataExams(){
    
        ArrayList<Exams> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from Exams");
        ResultSet r  = p.executeQuery();
            while (r.next()) {
               list.add(new Exams(r.getInt("examId"),r.getString("stdId"),r.getString("cName"),r.getString("tMarks"),r.getString("obtMarks"),r.getString("date"),r.getString("startTime"),r.getString("endTime"),r.getString("examTime"),r.getString("status")));
        }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
    
    
}
