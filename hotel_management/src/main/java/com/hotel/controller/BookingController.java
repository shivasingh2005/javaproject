package com.hotel.controller;

import com.hotel.dao.BookingDAO;
import com.hotel.model.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BookingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");

        Booking booking = new Booking(guestName, roomId, checkIn, checkOut);
        BookingDAO dao = new BookingDAO();
        dao.saveBooking(booking);

        response.sendRedirect("html/index.html");
    }
}
