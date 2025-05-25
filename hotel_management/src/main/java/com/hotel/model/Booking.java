// package com.hotel.model;

public class Booking {
    private int bookingId;
    private String guestName;
    private int roomId;
    private String checkInDate;
    private String checkOutDate;

    public Booking(String guestName, int roomId, String checkInDate, String checkOutDate) {
        this.guestName = guestName;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters and Setters
}
