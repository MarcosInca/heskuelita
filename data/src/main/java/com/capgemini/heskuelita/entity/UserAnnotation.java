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

    @Column(name="firstName", length=28, nullable=false)
    private String firstName;

    @Column(name="lastName", length=28, nullable=false)
    private String lastName;

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

    public UserAnnotation(String firstName, String lastName, String birthday, String sex, String us_username, String us_pw, String us_email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.username = us_username;
        this.pw = us_pw;
        this.email = us_email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
