-- reservations.sql 2&3
CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    check_in_date DATE,
    check_out_date DATE,
    room_number VARCHAR(50),
    status VARCHAR(20) CHECK (status IN ('approved', 'canceled')),
    FOREIGN KEY (UserID) REFERENCES userProfile(UserID)
);



INSERT INTO reservations (userId, check_in_date, check_out_date, room_number, status)
VALUES
    (1, '2025-07-10', '2025-07-15', '101A', 'approved');
   
 
INSERT INTO reservations (userId, check_in_date, check_out_date, room_number, status)
VALUES
    (2, '2025-08-01', '2025-08-05', '203B', 'approved');

INSERT INTO reservations (userId, check_in_date, check_out_date, room_number, status)
VALUES
    (3, '2025-09-20', '2025-09-22', '305C', 'canceled');

INSERT INTO reservations (userId, check_in_date, check_out_date, room_number, status)
VALUES
    (4, '2025-10-05', '2025-10-10', '101A', 'approved');

INSERT INTO reservations (userId, check_in_date, check_out_date, room_number, status)
VALUES
    (5, '2025-11-15', '2025-11-20', '401D', 'approved');
    
   -- select * from reservations;  
 
