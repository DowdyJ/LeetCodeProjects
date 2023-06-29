WITH FriendsByRequest AS (
    SELECT
        requester_id AS id,
        COUNT(*) AS num_requests
    FROM RequestAccepted
    GROUP BY requester_id
),
FriendsByAccept AS (
    SELECT
        accepter_id AS id,
        COUNT(*) AS num_accepts
    FROM RequestAccepted
    GROUP BY accepter_id
),
TotalFriends AS (
    SELECT
        f1.id,
        f1.num_requests,
        COALESCE(f2.num_accepts, 0) AS num_accepts
    FROM FriendsByRequest f1
    LEFT JOIN FriendsByAccept f2 ON f1.id = f2.id
    UNION
    SELECT
        f2.id,
        COALESCE(f1.num_requests, 0) AS num_requests,
        f2.num_accepts
    FROM FriendsByAccept f2
    LEFT JOIN FriendsByRequest f1 ON f2.id = f1.id
)
SELECT
    id,
    num_requests + num_accepts AS num
FROM TotalFriends
ORDER BY num DESC
LIMIT 1

