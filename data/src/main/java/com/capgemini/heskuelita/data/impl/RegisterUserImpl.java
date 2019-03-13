package com.capgemini.heskuelita.data.impl;

import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IRegisterUser;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterUserImpl implements IRegisterUser {

    private Connection conn;


    public RegisterUserImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void User(String username, String pw, String email) {

        try {

            PreparedStatement pstm = this.conn.prepareStatement("INSERT INTO users VALUES (?, ?, ?, default)");

            pstm.setString(1, username);
            pstm.setString(2, pw);
            pstm.setString(3, email);
            pstm.executeUpdate();

        } catch (Exception e) {
            throw new DataException("Error no se introduce");
        }
    }
}
