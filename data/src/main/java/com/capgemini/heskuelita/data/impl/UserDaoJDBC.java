package com.capgemini.heskuelita.data.impl;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.entity.UserAnnotation;
import com.capgemini.heskuelita.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoJDBC implements IUserDao {

    private static SessionFactory sessionFactory;

    private Connection conn;

    public UserDaoJDBC (SessionFactory sessionFactory) {

        super();
        this.sessionFactory = sessionFactory;
    }

    public static void setup () {

        sessionFactory = HibernateUtil.getSessionFactory ();
    }

    @Override
    public UserAnnotation login (String userName, String password) {

        Session session = null;
        UserAnnotation us;

        try {
            session = sessionFactory.openSession ();
            Statement stm = this.conn.createStatement();
            ResultSet resultSet = stm.executeQuery ("SELECT * from users WHERE us_username='" + userName + "' AND us_pw='" + password + "'");

            while (resultSet.next()) {
                us = new UserAnnotation ();
                us.setUsername (userName);
                break;
            }

        } catch (Exception e) {
            throw new DataException(e);
        }
        return null;
    }
}
