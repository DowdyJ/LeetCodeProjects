WITH RequestSummary AS (
    SELECT
        user_id,
        COUNT(*) AS total_requests,
        COUNT(IF(action = 'confirmed', 1, NULL)) AS confirmed_requests 
    FROM Confirmations
    GROUP BY user_id
)
SELECT
    s.user_id,
    IF(r.confirmed_requests IS NOT NULL, 
        ROUND(r.confirmed_requests / r.total_requests, 2), 
        0) AS confirmation_rate
FROM Signups s
LEFT JOIN RequestSummary r
ON s.user_id = r.user_id
