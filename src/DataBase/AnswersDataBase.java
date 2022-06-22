/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;


import domain.Answers;
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
public class AnswersDataBase {
    public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
    
    public static void insertAnswers(int id ,String question ,String answer ,String correctAns ,String status) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into Answers values(?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, question);
        p.setString(3, answer);
        p.setString(4, correctAns);
        p.setString(5, status);
        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    public static void DeletAnswers(int id) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from Answers where id =?");
        p.setInt(1, id);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
      public static void UpdateAnswer(int id , String question , String answer ,String correctAns ,String status) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update Answers set question =? ," + "answer = ?," + "correctAns = ?," +  "status = ?" + " where id = "+id+" ");
        p.setString(1, question);
        p.setString(2, answer);
        p.setString(3, correctAns);
        p.setString(4, status);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
    
    public static ArrayList<Answers> getDataAnswers(){
    
        ArrayList<Answers> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from Answers");
        ResultSet r  = p.executeQuery();
            while (r.next()) {
               list.add(new Answers(r.getInt("id"),r.getString("question"),r.getString("answer"),r.getString("correctAns"),r.getString("status")));
        }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
}
