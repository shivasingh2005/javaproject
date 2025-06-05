package com.hotel.controller;

import com.hotel.dao.BookingDAO;
import com.hotel.model.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BookingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set request encoding in case of special characters in input
        request.setCharacterEncoding("UTF-8");
        
        String guestName = request.getParameter("guestName");
        String roomIdStr = request.getParameter("roomId");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");

        // Basic validation of parameters
        if (guestName == null || guestName.trim().isEmpty() ||
            roomIdStr == null || roomIdStr.trim().isEmpty() ||
            checkIn == null || checkIn.trim().isEmpty() ||
            checkOut == null || checkOut.trim().isEmpty()) {
            
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("/html/error.jsp").forward(request, response);
            return;
        }

        int roomId;
        try {
            roomId = Integer.parseInt(roomIdStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid room ID format.");
            request.getRequestDispatcher("/html/error.jsp").forward(request, response);
            return;
        }

        // Additional validation could be done here: 
        // e.g., validate date formats, check that checkOut > checkIn, etc.

        try {
            Booking booking = new Booking(guestName, roomId, checkIn, checkOut);
            BookingDAO dao = new BookingDAO();
            boolean success = dao.saveBooking(booking);
            
            if (success) {
                // Redirect to home page or confirmation page after successful booking
                response.sendRedirect("html/index.html");
            } else {
                // Handle failure in saving booking
                request.setAttribute("errorMessage", "Failed to save booking. Please try again.");
                request.getRequestDispatcher("/html/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Log the exception (could use a logging framework)
            e.printStackTrace();
            
            // Forward to error page with message
            request.setAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            request.getRequestDispatcher("/html/error.jsp").forward(request, response);
        }
    }
}
