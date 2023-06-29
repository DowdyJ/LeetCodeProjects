SELECT
    a1.id AS id,
    a1.num + a2.num AS num
FROM 
(SELECT
    requester_id AS id,
    COUNT(*) AS num
FROM RequestAccepted
GROUP BY requester_id) a1
INNER JOIN
(SELECT
    accepter_id AS id,
    COUNT(*) AS num
FROM RequestAccepted
GROUP BY accepter_id) a2
ON a1.id = a2.id
ORDER BY num DESC
LIMIT 1
