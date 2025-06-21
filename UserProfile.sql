-- UserProfile.sql -1

CREATE DATABASE HMS;
USE HMS;

CREATE TABLE UserProfile (
    UserID INT PRIMARY KEY, -- Assuming INT for UserID as it's common for primary keys
    FullName VARCHAR(30),
    Email VARCHAR(50),
    MobileNumber VARCHAR(20), -- Assuming a reasonable length for mobile numbers
    Password VARCHAR(30)
);

-- users.sql

INSERT INTO UserProfile (UserID, FullName, Email, MobileNumber, Password) VALUES
(1, 'Alice Smith', 'alice.smith@example.com', '9876543210', 'passwordA1'),
(2, 'Bob Johnson', 'bob.j@example.com', '8765432109', 'securePwdB2'),
(3, 'Charlie Brown', 'charlie.b@example.com', '7654321098', 'myPassC3'),
(4, 'Diana Prince', 'diana.p@example.com', '6543210987', 'wonderD4'),
(5, 'Eve Adams', 'eve.a@example.com', '5432109876', 'secretE5');

-- select * from Userprofile;