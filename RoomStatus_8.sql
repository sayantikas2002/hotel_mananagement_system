-- 8

CREATE TABLE RoomStatus (
    CustomerID BIGINT PRIMARY KEY,
    FullName VARCHAR(50),
    status_Room VARCHAR(20) CHECK (status_Room IN ('vacant', 'occupied')),
    -- Status VARCHAR(10),  status VARCHAR(20) CHECK (status IN ('approved', 'canceled')),
    DateAvailability DATE,
    RoomType VARCHAR(20),
    Price DECIMAL(10, 2)
);

INSERT INTO RoomStatus (CustomerID, FullName, Status_Room, DateAvailability, RoomType, Price) VALUES
(1234567890123, 'Alice Smith', 'Occupied', '2025-06-21', 'suite', 250.00),
(2345678901234, 'Bob Johnson', 'Vacant', '2025-06-22', 'single room', 100.00),
(3456789012345, 'Charlie Brown', 'Occupied', '2025-06-23', 'double room', 180.00),
(4567890123456, 'Diana Prince', 'Vacant', '2025-06-24', 'suite', 275.00),
(5678901234567, 'Eve Adams', 'Occupied', '2025-06-25', 'single room', 110.00);