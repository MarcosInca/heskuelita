package com.capgemini.heskuelita.core.beans;
import lombok.*;

@Data
public class User {

    private String userName;
    private String password;
    private String email;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName (){
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword (){
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail (){
        return this.email;
    }

}
