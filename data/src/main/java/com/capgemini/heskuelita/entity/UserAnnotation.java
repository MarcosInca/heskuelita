package com.capgemini.heskuelita.entity;

import javax.persistence.*;

@Entity (name =  "User")
@Table (name = "users")
public class UserAnnotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    @Column (name="users_id", nullable=false, unique=true)
    private int id;

    @Column(name="user_username", length=48, nullable=false)
    private String username;

    @Column(name="pw", length=48, nullable=false)
    private String pw;

    public UserAnnotation() {

        super ();
    }

    public UserAnnotation(String username, String pw) {
        this.username = username;
        this.pw = pw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
