package com.capgemini.heskuelita.entity;

import javax.persistence.*;

@Entity (name =  "user")
@Table (name = "users")
public class UserAnnotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    @Column (name="us_id", nullable=false, unique=true)
    private int id;

    @Column(name="us_username", length=28, nullable=false)
    private String username;

    @Column(name="us_pw", length=28, nullable=false)
    private String pw;

    @Column(name="us_email", length=28, nullable=false)
    private String email;

    public UserAnnotation() {

        super ();
    }

    public UserAnnotation(String us_username, String us_pw, String us_email) {
        this.username = us_username;
        this.pw = us_pw;
        this.email = us_email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
