WITH owo AS (
  SELECT 
    player_id,
    MIN(event_date) AS first_date
  FROM Activity
  GROUP BY player_id
),
uwu AS (
  SELECT COUNT(DISTINCT a1.player_id) as count
  FROM Activity a1
  INNER JOIN Activity a2 ON a1.player_id = a2.player_id
  INNER JOIN owo o ON o.player_id = a1.player_id
  WHERE
    a1.player_id = a2.player_id AND 
    DATE_ADD(a1.event_date, INTERVAL 1 DAY) = a2.event_date AND
    o.first_date = a1.event_date
)
SELECT ROUND(uwu.count / COUNT(DISTINCT a.player_id), 2) as fraction
FROM Activity a, uwu
