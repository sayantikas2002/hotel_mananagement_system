-- 6 er 3 hoini

SELECT
    reservation_id,
    userId,
    check_in_date,
    check_out_date,
    room_number,
    status
FROM
    reservations
 WHERE check_in_date >= CURDATE() - INTERVAL 10 DAY;    
    
  DELETE FROM UserProfile
WHERE userId IN (SELECT DISTINCT userId FROM reservations WHERE status = 'canceled'); -- 6er 3 part error diche


-- 6 er 4 part done
SELECT
    r.reservation_id,
    r.userId,
    r.check_in_date,
    r.check_out_date,
    r.room_number,
    r.status
    
FROM
    reservations r
JOIN
    UserProfile u ON r.userId = u.userId
WHERE
    r.userId IN (
        SELECT DISTINCT userId
        FROM reservations
        WHERE status = 'approved'
    )
ORDER BY
    r.userId, r.check_in_date DESC;