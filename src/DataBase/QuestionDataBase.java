/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import static DataBase.ExamsDataBase.connect;
import domain.Questions;
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
public class QuestionDataBase {
     public static Connection connect () throws  SQLException{
    
        return  DriverManager.getConnection("jdbc:sqlite:uni.db");
    
    }
    
    public static void insertQuestions(int questionId, String question, String opt1, String opt2, String opt3, String opt4, String correct, String courseName) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("insert into Questions values(?,?,?,?,?,?,?,?)");
        p.setInt(1, questionId);
        p.setString(2, question);
        p.setString(3, opt1);
        p.setString(4, opt2);
        p.setString(5, opt3);
        p.setString(6, opt4);
        p.setString(7, correct);
        p.setString(8, courseName);
        p.execute();
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    public static void DeleteQuestion(int questionId) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("delete from Questions where questionId =?");
        p.setInt(1, questionId);
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
     public static void UpdateQuestion(int questionId, String question, String opt1, String opt2, String opt3, String opt4, String correct, String courseName) throws SQLException{
    try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("update Questions set question =? ," + "opt1 = ?," +  "opt2 = ?," +  "opt3 = ?," +  "opt4 = ?," +  "correct = ?," +  "courseName = ?" + " where questionId = "+questionId+" ");
        p.setString(1, question);
        p.setString(2, opt1);
        p.setString(3, opt2);
        p.setString(4, opt3);
        p.setString(5, opt4);
        p.setString(6, correct);
        p.setString(7, courseName);
       
        p.executeUpdate();
       
     }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    
    
    
    
    public static ArrayList<Questions> getDataQuestions(int questionId){
    
        ArrayList<Questions> list = new ArrayList<>();
        try{
        Connection con = connect();
        PreparedStatement p = con.prepareStatement("select * from Questions where questionId =? ");
        p.setInt(1 , questionId);
        ResultSet r  = p.executeQuery();
            while (r.next()) {
              list.add(new Questions(r.getInt("questionId"),r.getString("question"),r.getString("opt1"),r.getString("opt2"),r.getString("opt3"),r.getString("opt4"),r.getString("correct"),r.getString("courseName")));
              //  this.question =  r.getString("question");
            // list.add(new Questions(r.getString("question")));
            }
        }catch(SQLException ee){
            System.out.println(ee.getMessage());
           
        }
        
     return  list;
    }
    
     public static int CheckAnswers(String ans) {
        ArrayList<Questions> arr = getDataQuestions(4);
        int x = 0;  
     //   int i =0;
       
        
         for (int i = 0; i < arr.size(); i++) {
              if (arr.get(i).getCorrect().equalsIgnoreCase(ans)){
                     x = 1 ;
                     break;
                }
                else{
                     x = 2 ;
                     break;
                }       
          
         }
        
       
     
        return x;
        
    }
    
    
}
