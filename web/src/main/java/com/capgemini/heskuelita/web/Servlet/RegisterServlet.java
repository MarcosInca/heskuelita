package com.capgemini.heskuelita.web.Servlet;

import com.capgemini.heskuelita.data.impl.UserDaoJDBC;
import com.capgemini.heskuelita.entity.UserAnnotation;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;
import com.capgemini.heskuelita.util.HibernateUtil;
import org.hibernate.SessionFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private ISecurityService securityService;

    public RegisterServlet () {
        super ();
    }

    @Override
    public void init (ServletConfig config) throws ServletException {

        SessionFactory manager = HibernateUtil.getSessionFactory();

        try {
            this.securityService = new SecurityServiceImpl(new UserDaoJDBC(manager));

        } catch (Exception e) {

            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserAnnotation register = new UserAnnotation ();
        register.setUsername(req.getParameter("user"));
        register.setPw(req.getParameter("pwd"));
        register.setEmail(req.getParameter("email"));

        try {

            this.securityService.register(register);
            HttpSession session = req.getSession();
            session.setAttribute("user", register);
            resp.sendRedirect("index.jsp");

        } catch (Exception e){

            e.printStackTrace();
            resp.sendRedirect ("err.jsp");
        }

    }
}
