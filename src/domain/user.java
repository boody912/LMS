/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author pc
 */
public class user {
    String userName ,  password , department;

    public user(String userName, String password, String department) {
        this.userName = userName;
        this.password = password;
        this.department = department;
    }
    // getter .....
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }
    
    // setter .....

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
}
