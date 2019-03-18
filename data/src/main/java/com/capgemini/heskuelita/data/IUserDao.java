package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.entity.UserAnnotation;

public interface IUserDao {

    UserAnnotation login (String userName, String password);
    void register (String firstname, String lastname, String birthday, String sex, String username, String pw, String email);
}