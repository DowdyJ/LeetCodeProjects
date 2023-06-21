WITH BannedClients AS (
    SELECT users_id
    FROM Users
    WHERE banned = 'Yes' AND role = 'client'
),
BannedDrivers AS (
    SELECT users_id
    FROM Users
    WHERE banned = 'Yes' AND role = 'driver'
),
AllTimeRelevantTrips AS (
    SELECT *
    FROM Trips
    WHERE 
        request_at BETWEEN '2013-10-01' AND '2013-10-03' AND 
        client_id NOT IN (SELECT users_id FROM BannedClients) AND 
        driver_id NOT IN (SELECT users_id FROM BannedDrivers) 
),
CancelledTrips AS (
    SELECT 
        request_at,
        COUNT(*) AS cancelled_quantity
    FROM AllTimeRelevantTrips
    WHERE status = 'cancelled_by_driver' OR status = 'cancelled_by_client'
    GROUP BY request_at
),
TotalTrips AS (
    SELECT 
        request_at,
        COUNT(*) AS total_quantity
    FROM AllTimeRelevantTrips
    GROUP BY request_at    
)
SELECT
    t.request_at AS 'Day',
    ROUND((IF(c.cancelled_quantity IS NULL, 0, c.cancelled_quantity) / t.total_quantity), 2) AS 'Cancellation Rate'
FROM TotalTrips t
LEFT JOIN CancelledTrips c
ON c.request_at = t.request_at



