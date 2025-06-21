package ilpProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// --- Utility Class for Input ---
class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static long getLong(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid long number.");
            }
        }
    }

    public static double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
    }
}

// --- User Profile (US001) ---
class UserProfile {
    private static int nextUserId = 1001; // Auto-generate User ID
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String contactNumber;
    private String role; // "customer" or "admin"

    public UserProfile(String userName, String password, String email, String contactNumber, String role) {
        this.userId = nextUserId++;
        this.userName = userName;
        setPassword(password); // Use setter for password validation
        this.email = email;
        this.contactNumber = contactNumber;
        this.role = role;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        if (password.length() <= 50) {
            this.password = password;
        } else {
            System.out.println("Password exceeds maximum length of 50 characters. Truncating.");
            this.password = password.substring(0, 50);
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User ID: " + userId +
               ", Name: " + userName +
               ", Email: " + email +
               ", Contact: " + contactNumber +
               ", Role: " + role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}

// --- Reservation (US004) ---
class Reservation {
    private static int nextReservationId = 10001; // Auto-generate Reservation ID
    private int reservationId;
    private int userId; // Link to the user who made the reservation
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomPreference; // Single/Double
    private String guestName;
    private long guestContact;
    private double billAmount; // For checkout billing

    public Reservation(int userId, LocalDate checkInDate, LocalDate checkOutDate, String roomPreference, String guestName, long guestContact) {
        this.reservationId = nextReservationId++;
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomPreference = roomPreference;
        this.guestName = guestName;
        this.guestContact = guestContact;
        this.billAmount = 0.0; // Initialize, will be calculated at checkout
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getRoomPreference() {
        return roomPreference;
    }

    public String getGuestName() {
        return guestName;
    }

    public long getGuestContact() {
        return guestContact;
    }

    public double getBillAmount() {
        return billAmount;
    }

    // Setters
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setRoomPreference(String roomPreference) {
        this.roomPreference = roomPreference;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setGuestContact(long guestContact) {
        this.guestContact = guestContact;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Reservation ID: " + reservationId +
               ", User ID: " + userId +
               ", Guest Name: " + guestName +
               ", Check-in: " + checkInDate.format(formatter) +
               ", Check-out: " + checkOutDate.format(formatter) +
               ", Room Type: " + roomPreference;
    }
}

// --- Booking (US011 - Admin Service) ---
class Booking {
    private static int nextBookingId = 20001; // Auto-generate Booking ID
    private int bookingId;
    private int userId; // User who initiated the booking (could be customer or admin for a customer)
    private String roomTypeSelection;
    private double price;
    // Add other booking details as needed

    public Booking(int userId, String roomTypeSelection, double price) {
        this.bookingId = nextBookingId++;
        this.userId = userId;
        this.roomTypeSelection = roomTypeSelection;
        this.price = price;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public String getRoomTypeSelection() {
        return roomTypeSelection;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setRoomTypeSelection(String roomTypeSelection) {
        this.roomTypeSelection = roomTypeSelection;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
               ", User ID: " + userId +
               ", Room Type: " + roomTypeSelection +
               ", Price: $" + String.format("%.2f", price);
    }
}

// --- Complaint (US006) ---
class Complaint {
    private static int nextComplaintId = 30001;
    private int complaintId;
    private String userName;
    private String contactNumber;
    private String roomNumber;
    private String typeOfComplaint;
    private int feedbackRating; // Rating out of 5

    public Complaint(String userName, String contactNumber, String roomNumber, String typeOfComplaint, int feedbackRating) {
        this.complaintId = nextComplaintId++;
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.roomNumber = roomNumber;
        this.typeOfComplaint = typeOfComplaint;
        this.feedbackRating = feedbackRating;
    }

    // Getters
    public int getComplaintId() {
        return complaintId;
    }

    public String getUserName() {
        return userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getTypeOfComplaint() {
        return typeOfComplaint;
    }

    public int getFeedbackRating() {
        return feedbackRating;
    }

    @Override
    public String toString() {
        return "Complaint ID: " + complaintId +
               ", User: " + userName +
               ", Contact: " + contactNumber +
               ", Room: " + roomNumber +
               ", Type: " + typeOfComplaint +
               ", Rating: " + feedbackRating + "/5";
    }
}


// --- Hotel Management System Core Logic ---
public class HotelManagementSystem {
    private ArrayList<UserProfile> userProfiles = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>(); // For admin-managed bookings (US011)
    private ArrayList<Complaint> complaints = new ArrayList<>(); // For customer complaints (US006)

    // --- User Management (US001) ---

    public void registerUser(String userName, String password, String email, String contactNumber, String role) {
        UserProfile newUser = new UserProfile(userName, password, email, contactNumber, role);
        userProfiles.add(newUser);
        System.out.println("User Registration is successful. User ID: " + newUser.getUserId());
    }

    public void updateUserDetails(int userId, String newEmail) {
        boolean found = false;
        for (UserProfile user : userProfiles) {
            if (user.getUserId() == userId) {
                user.setEmail(newEmail);
                found = true;
                System.out.println("User details are updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    public void deleteUser(int userId) {
        Iterator<UserProfile> iterator = userProfiles.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            UserProfile user = iterator.next();
            if (user.getUserId() == userId) {
                iterator.remove();
                found = true;
                System.out.println("User details are deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    public void selectAllUsers() {
        if (userProfiles.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }
        System.out.println("\n--- All Registered Users ---");
        for (UserProfile user : userProfiles) {
            System.out.println(user);
        }
        System.out.println("----------------------------");
    }

    // --- Login (US002, US003) ---

    public UserProfile login(int userId, String password) {
        for (UserProfile user : userProfiles) {
            if (user.getUserId() == userId && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Invalid User ID or Password.");
        return null;
    }

    // --- Reservation Management (US004) ---

    public void addReservation(int userId, String checkInDateStr, String checkOutDateStr, String roomPreference, String guestName, long guestContact) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate checkInDate = LocalDate.parse(checkInDateStr, formatter);
            LocalDate checkOutDate = LocalDate.parse(checkOutDateStr, formatter);

            if (checkOutDate.isBefore(checkInDate)) {
                System.out.println("Check-out date cannot be before check-in date. Reservation failed.");
                return;
            }

            Reservation newReservation = new Reservation(userId, checkInDate, checkOutDate, roomPreference, guestName, guestContact);
            reservations.add(newReservation);
            System.out.println("Reservation Successful. Reservation ID: " + newReservation.getReservationId());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use DD-MM-YYYY.");
        }
    }

    public void updateReservationDetails(int reservationId, String newGuestName) {
        boolean found = false;
        for (Reservation res : reservations) {
            if (res.getReservationId() == reservationId) {
                res.setGuestName(newGuestName);
                found = true;
                System.out.println("Reservation details are updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Reservation with ID " + reservationId + " not found.");
        }
    }

    public void deleteReservation(int reservationId) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Reservation res = iterator.next();
            if (res.getReservationId() == reservationId) {
                iterator.remove();
                found = true;
                System.out.println("Reservation details are deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Reservation with ID " + reservationId + " not found.");
        }
    }

    // --- Booking History (US005 - Customer) ---
    public void viewCustomerBookingHistory(int userId) {
        System.out.println("\n--- Your Booking History ---");
        boolean found = false;
        for (Reservation res : reservations) {
            if (res.getUserId() == userId) {
                // In a real system, you'd calculate a bill amount here or store it.
                // For simplicity, let's just display reservation details and a dummy bill.
                System.out.println(res + ", Bill Amount: $" + String.format("%.2f", res.getBillAmount()));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No booking history found for your account.");
        }
        System.out.println("----------------------------");
    }

    // --- Complaint (US006) ---
    public void registerComplaint(String userName, String contactNumber, String roomNumber, String typeOfComplaint, int feedbackRating) {
        if (feedbackRating < 1 || feedbackRating > 5) {
            System.out.println("Feedback rating must be between 1 and 5.");
            return;
        }
        Complaint newComplaint = new Complaint(userName, contactNumber, roomNumber, typeOfComplaint, feedbackRating);
        complaints.add(newComplaint);
        System.out.println("Successfully registered Complaint. Complaint ID: " + newComplaint.getComplaintId());
    }

    // --- Contact Support (US007) ---
    public void displayContactSupportDetails() {
        System.out.println("\n--- Contact Support ---");
        System.out.println("Contact Number: +91 98765 43210");
        System.out.println("Email: support@hotelxyz.com");
        System.out.println("Address: 123 Hotel Street, New Town, Kolkata, India");
        System.out.println("-----------------------");
    }

    // --- Room Status (US008) ---
    // This requires a Room class and a list of rooms, which I'll omit for brevity.
    // However, here's a placeholder for the method.
    public void displayRoomAvailabilityCustomer() {
        System.out.println("\n--- Room Availability (Customer View) ---");
        System.out.println("Room Type: 1BHK, Available: Yes, Price Range: $100-150/night");
        System.out.println("Room Type: 2BHK, Available: No, Price Range: $180-250/night");
        System.out.println("Room Type: 3BHK, Available: Yes, Price Range: $300-400/night");
        System.out.println("Date Availability: Please inquire for specific dates.");
        System.out.println("Place: Our hotel is located in the heart of the city.");
        System.out.println("------------------------------------------");
    }

    public void updateRoomStatusAdmin(String roomNumber, String status, String dateAvailability) {
        // In a real system, you'd find the room by roomNumber and update its status.
        // For now, it's a placeholder.
        System.out.println("Admin: Room " + roomNumber + " status updated to " + status + " for " + dateAvailability);
    }

    // --- Checkout Billing (US009 - Customer) ---
    public void viewCheckoutBillCustomer(int userId) {
        // This is a simplified example. In a real system, you'd fetch the active reservation
        // for the user and calculate the bill based on stay duration and services.
        System.out.println("\n--- Checkout Bill ---");
        Reservation currentReservation = null;
        for(Reservation res : reservations) {
            // Assuming the first reservation found for the user is the one they are checking out from.
            // In a real system, you'd need to identify the active reservation more precisely.
            if (res.getUserId() == userId && res.getBillAmount() == 0.0) { // Assuming 0.0 means not yet billed
                currentReservation = res;
                break;
            }
        }

        if (currentReservation != null) {
            double roomCharges = 0;
            long numberOfNights = java.time.temporal.ChronoUnit.DAYS.between(currentReservation.getCheckInDate(), currentReservation.getCheckOutDate());
            if (currentReservation.getRoomPreference().equalsIgnoreCase("Single")) {
                roomCharges = numberOfNights * 100; // Example rate
            } else if (currentReservation.getRoomPreference().equalsIgnoreCase("Double")) {
                roomCharges = numberOfNights * 150; // Example rate
            }

            double additionalServices = 50.0; // Example for additional services
            double totalBill = roomCharges + additionalServices;
            currentReservation.setBillAmount(totalBill); // Update bill amount in reservation

            System.out.println("Reservation ID: " + currentReservation.getReservationId());
            System.out.println("Room Charges: $" + String.format("%.2f", roomCharges));
            System.out.println("Additional Services: $" + String.format("%.2f", additionalServices));
            System.out.println("Total Bill: $" + String.format("%.2f", totalBill));
            System.out.println("\nPayment Options:");
            System.out.println("1. Pay Bill");
            System.out.println("2. Cancel");
        } else {
            System.out.println("No active bill found for your user ID or already paid.");
        }
        System.out.println("---------------------");
    }

    // --- Payment (US010) ---
    public void processPayment(int userId, String cardHolderName, String cardNumber, String cvv, String expiryDate) {
        // Simulate payment processing
        // In a real application, you'd integrate with a payment gateway.
        System.out.println("\n--- Payment Processing ---");
        Reservation currentReservation = null;
        for(Reservation res : reservations) {
            if (res.getUserId() == userId && res.getBillAmount() > 0) { // Find a reservation with an outstanding bill
                currentReservation = res;
                break;
            }
        }

        if (currentReservation != null) {
            System.out.println("Payment successful for Reservation ID: " + currentReservation.getReservationId());
            System.out.println("\n--- INVOICE ---");
            System.out.println("Reservation ID: " + currentReservation.getReservationId());
            System.out.println("Guest Name: " + currentReservation.getGuestName());
            System.out.println("Check-in Date: " + currentReservation.getCheckInDate());
            System.out.println("Check-out Date: " + currentReservation.getCheckOutDate());
            System.out.println("Room Type: " + currentReservation.getRoomPreference());
            System.out.println("Total Amount Paid: $" + String.format("%.2f", currentReservation.getBillAmount()));
            System.out.println("Payment Method: Card (xxxx xxxx xxxx " + cardNumber.substring(cardNumber.length() - 4) + ")");
            System.out.println("-----------------");
            currentReservation.setBillAmount(0.0); // Mark as paid
        } else {
            System.out.println("No outstanding bill found for payment.");
        }
    }


    // --- Admin: Booking Hotel Services (US011) ---

    public void createBookingService(int userId, String roomTypeSelection, double price) {
        Booking newBooking = new Booking(userId, roomTypeSelection, price);
        bookings.add(newBooking);
        System.out.println("Successfully registered Booking. Booking ID: " + newBooking.getBookingId());
    }

    public void updateBookingService(int bookingId, String newRoomTypeSelection) {
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                booking.setRoomTypeSelection(newRoomTypeSelection);
                found = true;
                System.out.println("Booking details are updated.");
                break;
            }
        }
        if (!found) {
            System.out.println("Booking with ID " + bookingId + " not found.");
        }
    }

    public void deleteBookingService(int bookingId) {
        Iterator<Booking> iterator = bookings.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getBookingId() == bookingId) {
                iterator.remove();
                found = true;
                System.out.println("Booking details are deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Booking with ID " + bookingId + " not found.");
        }
    }

    // --- Admin: View Complaints (US012) ---
    public void viewActiveComplaints() {
        System.out.println("\n--- Active Complaints ---");
        if (complaints.isEmpty()) {
            System.out.println("No active complaints.");
            return;
        }
        int activeCount = complaints.size();
        System.out.println("Count: " + activeCount);
        for (Complaint complaint : complaints) {
            System.out.println(complaint);
        }
        System.out.println("-------------------------");
    }

    // --- Admin: Booking History (US013) ---
    public void viewAllCustomerBookingDetails() {
        System.out.println("\n--- All Customer Booking Details ---");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation res : reservations) {
            UserProfile user = findUserById(res.getUserId());
            if (user != null) {
                System.out.println("Customer ID: " + user.getUserId() +
                                   ", Customer Name: " + user.getUserName() +
                                   ", Mobile Number: " + user.getContactNumber() +
                                   ", Email: " + user.getEmail());
                System.out.println("  " + res);
            } else {
                System.out.println("Reservation ID: " + res.getReservationId() + " (User not found)");
            }
        }
        System.out.println("------------------------------------");
    }

    // Helper method to find user by ID
    private UserProfile findUserById(int userId) {
        for (UserProfile user : userProfiles) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    // --- Admin: Booking History by User ID (US014) ---
    public void viewBookingHistoryByUserId(int userId) {
        System.out.println("\n--- Booking History for User ID: " + userId + " ---");
        boolean found = false;
        for (Reservation res : reservations) {
            if (res.getUserId() == userId) {
                System.out.println(res);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No booking history found for User ID: " + userId);
        }
        System.out.println("----------------------------------------");
    }

    // --- Admin: Checkout Billing Invoice (US015) ---
    public void generateInvoiceAdmin(int userId) {
        System.out.println("\n--- Generating Invoice for User ID: " + userId + " ---");
        Reservation userReservation = null;
        for (Reservation res : reservations) {
            // Assuming we're looking for an active reservation for this user to generate an invoice.
            // In a real system, you might have a "checked-out" status for reservations.
            if (res.getUserId() == userId && res.getBillAmount() > 0) { // Assuming a bill exists and is not yet paid
                userReservation = res;
                break;
            }
        }

        if (userReservation != null) {
            UserProfile user = findUserById(userId);
            if (user != null) {
                System.out.println("Reservation ID: " + userReservation.getReservationId());
                System.out.println("User Details: " + user.getUserName() + " (" + user.getEmail() + ")");
                System.out.println("Room Charges: $" + String.format("%.2f", userReservation.getBillAmount() * 0.8)); // Example breakdown
                System.out.println("Additional Service Charges: $" + String.format("%.2f", userReservation.getBillAmount() * 0.2)); // Example breakdown
                System.out.println("Total Bill: $" + String.format("%.2f", userReservation.getBillAmount()));
                System.out.println("\nInvoice generated successfully. Option to finalize and print.");
            } else {
                System.out.println("User not found for ID: " + userId);
            }
        } else {
            System.out.println("No outstanding bill or active reservation found for User ID: " + userId);
        }
        System.out.println("---------------------------------------------");
    }

    // --- Main Application Loop and Menu ---
    public static void main(String[] args) {
        HotelManagementSystem hms = new HotelManagementSystem();

        // Add some initial data for testing
        hms.registerUser("Alice Smith", "password123", "alice@example.com", "9876543210", "customer");
        hms.registerUser("Bob Johnson", "adminpass", "bob@example.com", "9988776655", "admin");
        hms.addReservation(1001, "01-07-2025", "05-07-2025", "Double", "Alice Smith", 9876543210L);
        hms.addReservation(1001, "10-08-2025", "12-08-2025", "Single", "Alice Smith", 9876543210L);
        hms.createBookingService(1002, "Luxury Suite", 500.00); // Admin booking
        hms.registerComplaint("Alice Smith", "9876543210", "201", "Noisy guests.", 3);


        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. User Management");
            System.out.println("2. Login");
            System.out.println("0. Exit");

            int choice = InputHandler.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    hms.userManagementMenu();
                    break;
                case 2:
                    UserProfile loggedInUser = hms.loginMenu();
                    if (loggedInUser != null) {
                        if (loggedInUser.getRole().equals("customer")) {
                            hms.customerMenu(loggedInUser.getUserId());
                        } else if (loggedInUser.getRole().equals("admin")) {
                            hms.adminMenu(loggedInUser.getUserId());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting Hotel Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void userManagementMenu() {
        while (true) {
            System.out.println("\n--- User Management ---");
            System.out.println("1. Register New User");
            System.out.println("2. Update User Details (Email)");
            System.out.println("3. Delete User");
            System.out.println("4. View All Users");
            System.out.println("0. Back to Main Menu");

            int choice = InputHandler.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    String userName = InputHandler.getString("Enter User Name: ");
                    String password = InputHandler.getString("Enter Password (max 50 chars): ");
                    String email = InputHandler.getString("Enter Email: ");
                    String contact = InputHandler.getString("Enter Contact Number: ");
                    String role = InputHandler.getString("Enter Role (customer/admin): ").toLowerCase();
                    if (!role.equals("customer") && !role.equals("admin")) {
                        System.out.println("Invalid role. Must be 'customer' or 'admin'.");
                        break;
                    }
                    registerUser(userName, password, email, contact, role);
                    break;
                case 2:
                    int userIdToUpdate = InputHandler.getInt("Enter User ID to update: ");
                    String newEmail = InputHandler.getString("Enter new Email Address: ");
                    updateUserDetails(userIdToUpdate, newEmail);
                    break;
                case 3:
                    int userIdToDelete = InputHandler.getInt("Enter User ID to delete: ");
                    deleteUser(userIdToDelete);
                    break;
                case 4:
                    selectAllUsers();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private UserProfile loginMenu() {
        int userId = InputHandler.getInt("Enter User ID: ");
        String password = InputHandler.getString("Enter Password: ");
        return login(userId, password);
    }

    private void customerMenu(int userId) {
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Reservation");
            System.out.println("2. Booking History");
            System.out.println("3. Room Status");
            System.out.println("4. Check-out Billing");
            System.out.println("5. Complaint");
            System.out.println("6. Contact Support");
            System.out.println("0. Logout");

            int choice = InputHandler.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    reservationMenu(userId);
                    break;
                case 2:
                    viewCustomerBookingHistory(userId);
                    break;
                case 3:
                    displayRoomAvailabilityCustomer();
                    break;
                case 4:
                    checkoutBillingCustomerMenu(userId);
                    break;
                case 5:
                    String cUserName = InputHandler.getString("Enter your Name: ");
                    String cContact = InputHandler.getString("Enter your Contact Number: ");
                    String cRoomNumber = InputHandler.getString("Enter Room Number: ");
                    System.out.println("Type of Complaint (Poor housekeeping, Noisy guests, Uncomfortable beds, Slow service, Lack of amenities, Unfriendly staff): ");
                    String cType = InputHandler.getString("Enter Type of Complaint: ");
                    int cRating = InputHandler.getInt("Enter Feedback Rating (1-5): ");
                    registerComplaint(cUserName, cContact, cRoomNumber, cType, cRating);
                    break;
                case 6:
                    displayContactSupportDetails();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void reservationMenu(int userId) {
        while (true) {
            System.out.println("\n--- Reservation Menu ---");
            System.out.println("1. Add New Reservation");
            System.out.println("2. Update Reservation Details (Guest Name)");
            System.out.println("3. Delete Reservation");
            System.out.println("0. Back to Customer Menu");

            int choice = InputHandler.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    String checkIn = InputHandler.getString("Enter Check-in Date (DD-MM-YYYY): ");
                    String checkOut = InputHandler.getString("Enter Check-out Date (DD-MM-YYYY): ");
                    String roomPref = InputHandler.getString("Enter Room Preference (Single/Double): ");
                    String guestName = InputHandler.getString("Enter Guest Name: ");
                    long guestContact = InputHandler.getLong("Enter Guest Contact: ");
                    addReservation(userId, checkIn, checkOut, roomPref, guestName, guestContact);
                    break;
                case 2:
                    int resIdUpdate = InputHandler.getInt("Enter Reservation ID to update: ");
                    String newGuestName = InputHandler.getString("Enter new Guest Name: ");
                    updateReservationDetails(resIdUpdate, newGuestName);
                    break;
                case 3:
                    int resIdDelete = InputHandler.getInt("Enter Reservation ID to delete: ");
                    deleteReservation(resIdDelete);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkoutBillingCustomerMenu(int userId) {
        while (true) {
            viewCheckoutBillCustomer(userId);
            int choice = InputHandler.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    String cardHolderName = InputHandler.getString("Enter Card Holder Name: ");
                    String cardNumber = InputHandler.getString("Enter Card Number: ");
                    String cvv = InputHandler.getString("Enter CVV: ");
                    String expiryDate = InputHandler.getString("Enter Expiry Date (MM/YY): ");
                    processPayment(userId, cardHolderName, cardNumber, cvv, expiryDate);
                    return; // Payment completed, go back
                case 2:
                    System.out.println("Bill payment cancelled.");
                    return; // Go back to customer menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void adminMenu(int adminUserId) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Booking Hotel Services");
            System.out.println("2. View All Booking History");
            System.out.println("3. View Booking History by User ID");
            System.out.println("4. Room Status Management");
            System.out.println("5. Check-out Billing Invoice");
            System.out.println("6. View Complaints");
            System.out.println("0. Logout");

            int choice = InputHandler.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    adminBookingServiceMenu(adminUserId);
                    break;
                case 2:
                    viewAllCustomerBookingDetails();
                    break;
                case 3:
                    int userIdToViewHistory = InputHandler.getInt("Enter User ID to view booking history: ");
                    viewBookingHistoryByUserId(userIdToViewHistory);
                    break;
                case 4:
                    // Room status management for admin (update vacant/occupied)
                    String roomNum = InputHandler.getString("Enter Room Number to update: ");
                    String status = InputHandler.getString("Enter new Status (Vacant/Occupied): ");
                    String dateAvail = InputHandler.getString("Enter Date Availability: ");
                    updateRoomStatusAdmin(roomNum, status, dateAvail);
                    break;
                case 5:
                    int userIdForInvoice = InputHandler.getInt("Enter User ID to generate invoice for: ");
                    generateInvoiceAdmin(userIdForInvoice);
                    break;
                case 6:
                    viewActiveComplaints();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void adminBookingServiceMenu(int adminUserId) {
        while (true) {
            System.out.println("\n--- Admin: Booking Service Menu ---");
            System.out.println("1. Create Booking Service");
            System.out.println("2. Update Booking Service (Room Type)");
            System.out.println("3. Delete Booking Service");
            System.out.println("0. Back to Admin Menu");

            int choice = InputHandler.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int customerIdForBooking = InputHandler.getInt("Enter Customer User ID for this booking: ");
                    String roomType = InputHandler.getString("Enter Room Type Selection (e.g., Standard, Deluxe, Suite): ");
                    double price = InputHandler.getDouble("Enter Price: ");
                    createBookingService(customerIdForBooking, roomType, price);
                    break;
                case 2:
                    int bookingIdToUpdate = InputHandler.getInt("Enter Booking ID to update: ");
                    String newRoomType = InputHandler.getString("Enter new Room Type Selection: ");
                    updateBookingService(bookingIdToUpdate, newRoomType);
                    break;
                case 3:
                    int bookingIdToDelete = InputHandler.getInt("Enter Booking ID to delete: ");
                    deleteBookingService(bookingIdToDelete);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
