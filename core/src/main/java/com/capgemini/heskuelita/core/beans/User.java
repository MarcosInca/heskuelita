package com.capgemini.heskuelita.core.beans;
import lombok.*;

@Data
@NoArgsConstructor
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

}
