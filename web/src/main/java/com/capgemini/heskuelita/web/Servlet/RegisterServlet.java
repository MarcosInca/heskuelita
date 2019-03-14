package com.capgemini.heskuelita.web.Servlet;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.IRegisterUser;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDaoJDBC;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;
import com.capgemini.heskuelita.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    ISecurityService studentSecurityServiceecurityService;
    IRegisterUser registerUser;

    public RegisterServlet () {
        super ();
    }


    @Override
    public void init (ServletConfig config) throws ServletException {

        SessionFactory manager = HibernateUtil.getSessionFactory();

        try {
            this.studentSecurityServiceecurityService = new SecurityServiceImpl(new UserDaoJDBC(manager));

        } catch (Exception e) {

            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        User register = new User ();
        register.setUserName(req.getParameter("user"));
        register.setPassword(req.getParameter("pwd"));
        register.setEmail(req.getParameter("email"));

        try {

            this.registerUser.User(register.getUserName(),register.getPassword(),register.getEmail());
            resp.sendRedirect("index.jsp");

        } catch (Exception e){

            e.printStackTrace();
            resp.sendRedirect ("err.jsp");
        }

    }
}
