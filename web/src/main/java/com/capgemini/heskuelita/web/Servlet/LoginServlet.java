package com.capgemini.heskuelita.web.Servlet;
import com.capgemini.heskuelita.data.impl.UserDaoJDBC;
import com.capgemini.heskuelita.entity.UserAnnotation;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;
import com.capgemini.heskuelita.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet {

    private ISecurityService securityService;

    public LoginServlet () {
        super ();
    }

    @Override
    public void init (ServletConfig config) throws ServletException {

        SessionFactory manager = HibernateUtil.getSessionFactory();

        try {

            this.securityService = new SecurityServiceImpl(new UserDaoJDBC(manager));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserAnnotation user = new UserAnnotation();
        user.setUsername (req.getParameter("user"));
        user.setPw( req.getParameter("pwd"));

        try {
            this.securityService.login(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("home.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("err.jsp");
        }
    }
}
