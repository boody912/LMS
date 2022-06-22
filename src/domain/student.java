/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import DataBase.studentDataBase;


/**
 *
 * @author pc
 */
public class student {
    private  int id  ;
    private  String Fname , Lname , adress ,  department ,studPassword ;
    public void setStudPassword(String studPassword) {
        this.studPassword = studPassword;
    }

    public String getStudPassword() {
        return studPassword;
    }

    public student(int id, String Fname, String Lname, String adress, String department , String studPassword) {
        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.adress = adress;
        this.department = department;
        this.studPassword = studPassword ;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getAdress() {
        return adress;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}
