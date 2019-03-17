package com.capgemini.heskuelita.data.impl;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.entity.UserAnnotation;
import com.capgemini.heskuelita.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserDaoJDBC implements IUserDao {

    private static SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger (UserDaoJDBC.class);

    public UserDaoJDBC (SessionFactory sessionFactory) {

        super();
        this.sessionFactory = sessionFactory;
    }

    public static void setup () {

        sessionFactory = HibernateUtil.getSessionFactory ();
    }

    public static void destroy () {

        sessionFactory.close ();
    }

    @Override
    public UserAnnotation login (String userName, String password) {

        Session session = null;
        final String filter1 = userName;
        final String filter2 = password;
        UserAnnotation userL = null;

        try {
            session = sessionFactory.openSession ();
            Criterion criterion1 = Restrictions.like("user", filter1);
            Criterion criterion2 = Restrictions.like("pwd", filter2);
            LogicalExpression andExp = Restrictions.and (criterion1, criterion2);
            List<UserAnnotation> list = (List<UserAnnotation>) session.createCriteria (UserAnnotation.class).add(andExp).list();

            if ( !list.isEmpty() )  {
                for (UserAnnotation e : list){
                    userL = new UserAnnotation();
                    userL.setUsername(e.getUsername());
                }
            }

        } catch (Exception e) {

            String m = String.format ("Problems executing login %s", e.getMessage ());
            logger.error (m);

        } finally { session.close(); }
        return userL;
    }

    @Override
    public void register (String userName, String password, String email) {

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession ();
            tx = session.beginTransaction ();

          UserAnnotation us = new UserAnnotation(userName,password, email);

            session.save(us);

            tx.commit ();

        } catch (Exception ex) {

            tx.rollback ();

        } finally { session.close (); }
    }
}

