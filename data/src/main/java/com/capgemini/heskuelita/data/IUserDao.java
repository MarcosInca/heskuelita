package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.entity.UserAnnotation;

public interface IUserDao {

    UserAnnotation login (String userName, String password);


}
