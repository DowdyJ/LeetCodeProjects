WITH GoodIDs AS (
    SELECT DISTINCT 
        s3.id,
        s3.neighbor1id,
        s4.id AS neighbor2id
    FROM (
        SELECT DISTINCT 
            s1.id AS id,
            s2.id AS neighbor1id
        FROM Stadium s1 
        LEFT JOIN Stadium s2 
        ON s1.id = s2.id - 1 
        WHERE s1.people >= 100 AND s2.people >= 100) s3
    LEFT JOIN Stadium s4
    ON s4.id = s3.id + 2
    WHERE s4.people >= 100
)
SELECT DISTINCT * 
FROM Stadium s
WHERE 
    s.id IN (SELECT id FROM GoodIDs) OR 
    s.id IN (SELECT neighbor1id FROM GoodIDs) OR 
    s.id IN (SELECT neighbor2id FROM GoodIDs)
ORDER BY visit_date ASC;
