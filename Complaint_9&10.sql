-- 9

CREATE TABLE Complaint (
    complaint_id VARCHAR(50) PRIMARY KEY,
    userId VARCHAR(50) NOT NULL,
    customer_contact_no VARCHAR(20),
    room_number VARCHAR(10),
    complaint_type VARCHAR(100) NOT NULL,
    complaint_details TEXT,
    feedback VARCHAR(50),
    reported_at DATETIME NOT NULL,
    complaint_status VARCHAR(20) DEFAULT 'Open'
);

-- 10

ALTER TABLE Reservations
ADD COLUMN Upcoming_bookings_date DATE;  