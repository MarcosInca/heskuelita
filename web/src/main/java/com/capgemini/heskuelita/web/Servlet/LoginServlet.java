package com.capgemini.heskuelita.web.Servlet;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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

        ServletContext contet
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User ();
        user.setUserName (req.getParameter("user"));
        user.setPassword (req.getParameter("pwd"));

        try {
            this.securityService.login (user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("home.jsp");

        } catch (Exception e) {
            resp.sendRedirect("err.jsp");
        }
    }
}
