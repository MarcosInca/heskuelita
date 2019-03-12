package com.capgemini.heskuelita.web.Servlet;


import com.capgemini.heskuelita.data.db.DBConnectionManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {



    @Override
    public void init (ServletConfig config) throws ServletException {

        ServletContext context = config.getServletContext();

        DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");

        try {

            this.securityService = new StudentSecurityServiceImpl(new StudentDaoJDBC(manager.getConnection()));
        } catch (Exception e) {

            throw new ServletException(e);
        }
    }

}
