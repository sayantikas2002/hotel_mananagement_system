-- 4 & 5
-- SQL query to create the 'bills' table   
CREATE TABLE bills (
    bill_id INT PRIMARY KEY AUTO_INCREMENT, 
    reservation_id INT NOT NULL,  
    total_amount DECIMAL(10, 2) NOT NULL,  
    additional_charges DECIMAL(10, 2) DEFAULT 0.00, 
    payment_status VARCHAR(50) NOT NULL, 
    FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id)
);



INSERT INTO bills (reservation_id, total_amount, additional_charges, payment_status)
VALUES
    (1, 150.00, 10.50, 'paid'); 

INSERT INTO bills (reservation_id, total_amount, additional_charges, payment_status)
VALUES
    (2, 250.75, 0.00, 'pending'); 

INSERT INTO bills (reservation_id, total_amount, additional_charges, payment_status)
VALUES
    (3, 80.00, 5.00, 'paid');   

INSERT INTO bills (reservation_id, total_amount, additional_charges, payment_status)
VALUES
    (4, 180.25, 20.00, 'unpaid'); 

INSERT INTO bills (reservation_id, total_amount, additional_charges, payment_status)
VALUES
    (5, 300.00, 0.00, 'paid');   
    
  --   select * from bills;
