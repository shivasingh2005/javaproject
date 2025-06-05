package com.hotel.controller;

import com.hotel.dao.UserDAO;
import com.hotel.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle GET event: show login page
        logger.info("GET request received - displaying login page");
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        logger.info("POST request received - processing login");

        // Read input parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Event processing: validate user credentials
        try {
            UserDAO dao = new UserDAO();
            User user = dao.validateUser(username, password);

            if (user != null) {
                // Successful login event
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                logger.info("User '" + username + "' logged in successfully");
                response.sendRedirect("views/dashboard.jsp");
            } else {
                // Failed login event
                logger.warning("Failed login attempt for username: " + username);
                request.setAttribute("error", "Invalid login");
                request.getRequestDispatcher("views/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            logger.severe("Exception during login process: " + e.getMessage());
            // Optional: forward to error page or show message
            request.setAttribute("error", "An error occurred during login. Please try again.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
