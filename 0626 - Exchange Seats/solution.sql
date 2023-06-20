SELECT 
    IF(MOD(id, 2) = 0, 
        id - 1, 
        IF(id + 1 > (SELECT COUNT(*) FROM Seat), id, id + 1)
        ) as id,
    student
FROM Seat
ORDER BY id ASC;
