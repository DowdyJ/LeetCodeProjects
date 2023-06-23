WITH NulledNums AS (
  SELECT IF(
    LEAD(num) OVER(ORDER BY id) = LAG(num) OVER(ORDER BY id) AND 
    LAG(num) OVER(ORDER BY id) = num, 
    num, 
    null) AS ConsecutiveNums 
  FROM Logs
)

SELECT DISTINCT ConsecutiveNums 
FROM NulledNums
WHERE ConsecutiveNums IS NOT NULL;

