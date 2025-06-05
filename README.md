Hotel Reservation Management System - Detailed Documentation
 FEATURES (Detailed Explanation)
 1. Customer Registration and Login- New users can register with their name, contact details, username, and password.- Users can log in with their credentials, which are verified against the MySQL database.
 2. Room Booking (Single, Double, Suite)- Allows users to view and book rooms categorized by type.- Displays real-time availability.- Booking details include duration and total cost.
 3. View and Cancel Bookings- Displays current and past reservations.- Option to cancel a booking, which updates room availability.
 4. Admin Panel for Room Management- Admin users can add/remove rooms and change room prices.- Allows management of room availability.
 5. Real-time Room Availability Check- Prevents double booking by updating room status immediately after a booking is made.
 6. Database Connectivity with MySQL (JDBC)- All data operations (add, update, delete) are done via JDBC.
- Ensures smooth interaction between Java app and MySQL database.
 7. Input Validation and Error Handling- Ensures required fields are filled and inputs are in correct format.- Exceptions are caught and handled gracefully.
 8. User-friendly GUI with Swing- GUI forms for login, booking, registration, and admin panel.- Built using Java Swing for a desktop application experience.
 PROJECT STRUCTURE (Detailed Explanation)
 HotelReservationSystem/
 |- src/
 |  |- model/         - Data models like Customer.java, Room.java, Booking.java
 |  |- view/          - Swing GUI forms like LoginForm.java, BookingForm.java
 |  |- controller/    - Event handlers, UI logic
 |  |- dao/           - Database Access Object classes like CustomerDAO.java
 |  |- Main.java      - Entry point of the application
 |- db/
 |  |- hotel_schema.sql  - SQL file to create required database tables
 |- README.md
 src/model/- Defines data structure classes.- Used to store and transfer data between components.
src/view/- Contains all the Java Swing GUI files.- Manages user interaction and visual elements.
 src/controller/- Manages business logic and event handling.- Listens to actions like button clicks and updates the model or view accordingly.
 src/dao/- Handles communication with MySQL using JDBC.- Each DAO class is dedicated to a table in the database.
 db/hotel_schema.sql- SQL script to create 'customers', 'rooms', and 'bookings' tables.- Should be executed in MySQL before running the Java application.
 README.md- Project documentation containing setup instructions, features, and structure.
 End of Document
