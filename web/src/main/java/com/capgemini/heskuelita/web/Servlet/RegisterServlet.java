package com.capgemini.heskuelita.web.Servlet;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.PreparedStatement;
import javax.servlet.http.*;

@WebServlet ("/register")
public class RegisterServlet extends HttpServlet {

    public RegisterServlet () {
        super ();
    }

    @Override
    public void init (ServletConfig config){

        ServletContext context = config.getServletContext();

        DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        User user = new User ();

        this.insertTable("user",
                user.setUserName (req.getParameter("username")),
                user.setPassword (req.getParameter("pwd")),
                user.setPassword (req.getParameter("email")));

        resp.sendRedirect("index.jsp");

    }

    public void insertTable (String username, String pwd, String email) {


        PreparedStatement pstm = manager.getConnection ().prepareStatement ("INSERT INTO users VALUES (?, ?, ?)");

        pstm.setString (1, username);
        pstm.setString (2, pwd);
        pstm.setString (3, email);

        pstm.executeUpdate ();
    }
}
