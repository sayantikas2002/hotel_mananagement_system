-- 7

-- user_table.sql
CREATE TABLE UserTable (
    CustomerId INT PRIMARY KEY,
    FullName VARCHAR(255) NOT NULL,
    BookingDate DATE,
    check_in_date DATE,
    check_out_date DATE,
    PackageID VARCHAR(50),
    total_amount DECIMAL(10, 2)  -- sum korte hote pare total amount and additional charges from bills table
);

-- insert_data.sql
INSERT INTO UserTable (CustomerId,FullName, BookingDate,check_in_date,check_out_date, PackageID,total_amount) VALUES
(1, 'Alice Johnson', '2025-01-10', '2025-02-01', '2025-02-05', 'PKG001', 1200.50),
(2, 'Bob Williams', '2025-03-15', '2025-04-01', '2025-04-03', 'PKG002', 750.00),
(3, 'Charlie Brown', '2025-05-20', '2025-06-10', '2025-06-15', 'PKG003', 2500.75),
(4, 'Diana Miller', '2025-07-01', '2025-08-05', '2025-08-10', 'PKG001', 1300.00),
(5, 'Eva Davis', '2025-09-05', '2025-10-01', '2025-10-04', 'PKG002', 800.25);

INSERT INTO UserTable (CustomerId,FullName, BookingDate,check_in_date,check_out_date, PackageID,total_amount) VALUES
(6, 'Sayantika Saha', '2025-01-10', '2025-02-01', '2025-02-05', 'PKG001', 1200.50);



SELECT
    U.CustomerId,
    U.FullName,
    U.BookingDate,
    u.Check_In_Date,
    u.Check_Out_Date,
    u.PackageId,
    u.total_amount
FROM
    UserTable AS U
-- JOIN
--     reservations AS B ON U.CustomerId = B.CustomerId
WHERE
    U.FullName LIKE '%a' -- Finds names ending with 'a' (case-insensitive depending on DB collation)
ORDER BY
    U.FullName DESC; -- Sorts by CustomerName in descending order