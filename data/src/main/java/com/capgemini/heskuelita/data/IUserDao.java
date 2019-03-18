package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.entity.UserAnnotation;

public interface IUserDao {

    UserAnnotation login (String userName, String password);
    void register (String firstName, String lastName, String birthday, String sex, String us_username, String us_pw, String us_email);
}
