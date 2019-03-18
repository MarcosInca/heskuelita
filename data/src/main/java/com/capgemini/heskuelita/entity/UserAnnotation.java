package com.capgemini.heskuelita.entity;

import javax.persistence.*;

@Entity (name =  "user")
@Table (name = "users")
public class UserAnnotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    @Column (name="id", nullable=false, unique=true)
    private int id;

    @Column(name="firstname", length=28, nullable=false)
    private String firstname;

    @Column(name="lastname", length=28, nullable=false)
    private String lastname;

    @Column(name="birthday", length=28, nullable=false)
    private String birthday;

    @Column(name="sex", length=28, nullable=false)
    private String sex;

    @Column(name="us_username", length=28, nullable=false)
    private String username;

    @Column(name="us_pw", length=28, nullable=false)
    private String pw;

    @Column(name="us_email", length=28, nullable=false)
    private String email;

    public UserAnnotation() {

        super ();
    }

    public UserAnnotation(String firstname, String lastname, String birthday, String sex, String username, String pw, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.sex = sex;
        this.username = username;
        this.pw = pw;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
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
