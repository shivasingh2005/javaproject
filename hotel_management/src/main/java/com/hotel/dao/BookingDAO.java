// package com.hotel.dao;

// import com.hotel.model.Booking;
// import java.sql.Connection;
// import java.sql.PreparedStatement;

public class BookingDAO {
    public void saveBooking(Booking booking) {
        String sql = "INSERT INTO bookings (guest_name, room_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, booking.getGuestName());
            stmt.setInt(2, booking.getRoomId());
            stmt.setString(3, booking.getCheckInDate());
            stmt.setString(4, booking.getCheckOutDate());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
