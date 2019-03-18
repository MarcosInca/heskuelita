package com.capgemini.heskuelita.service.impl;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.entity.UserAnnotation;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;

public class SecurityServiceImpl implements ISecurityService {

    private IUserDao userDao;

    public SecurityServiceImpl (IUserDao userDao) {
        super ();
        this.userDao = userDao;
    }

    @Override
    public void login (UserAnnotation user) throws SecurityException {

        try {
            this.userDao.login (user.getUsername(), user.getPw());

        } catch (Exception e) {
            throw new SecurityException(e);
        }
    }

    @Override
    public void register (UserAnnotation user) throws SecurityException {

        try {
            this.userDao.register (user.getFirstName(), user.getLastName(), user.getBirthday(), user.getSex(), user.getUsername(), user.getPw(), user.getEmail());

        } catch (Exception e) {
            throw new SecurityException(e);
        }
    }
}