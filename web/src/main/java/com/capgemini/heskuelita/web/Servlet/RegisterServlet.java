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

}
