-- 11

UPDATE bills
SET payment_status = 'Completed' -- e.g., 'Paid', 'Completed', 'Settled'
WHERE reservation_id IN (
    SELECT 
    reservation_id
    FROM reservations
    WHERE reservation_id = 'bill_id' -- Replace with the actual Customer ID
);

-- UPDATE bills
-- SET payment_status = 'Completed'
-- WHERE payment_status = 'paid';




SELECT
    b.bill_id,
    b.reservation_id,
    b.total_amount,
    b.additional_charges,
    b.payment_status,
    r.customer_id -- Displaying customer_id from reservations for verification
FROM
    bills b
JOIN
    reservations r ON b.reservation_id = r.reservation_id
WHERE
    r.customer_id = '[Your_Customer_ID_Here]'; -- Replace with the same Customer ID used in the UPDATE query