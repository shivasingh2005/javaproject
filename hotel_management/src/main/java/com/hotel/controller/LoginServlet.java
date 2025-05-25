package com.hotel.controller;

import com.hotel.dao.UserDAO;
import com.hotel.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.validateUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("views/dashboard.jsp");
        } else {
            request.setAttribute("error", "Invalid login");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
