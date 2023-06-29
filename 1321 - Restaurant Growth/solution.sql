WITH Subtotals AS (
    SELECT 
        visited_on,
        COUNT(*) AS customer_count,
        SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
),
TabulatedResults AS (
  SELECT
  visited_on,
  amount,
  COUNT(*) OVER(ORDER BY visited_on ASC ROWS BETWEEN 6 PRECEDING AND 0 FOLLOWING) AS sum_count,
  SUM(amount) OVER(ORDER BY visited_on ASC ROWS BETWEEN 6 PRECEDING AND 0 FOLLOWING) AS sum_amount 
  FROM Subtotals
)
SELECT
  visited_on,
  sum_amount AS amount,
  ROUND(sum_amount / sum_count, 2) AS average_amount 
FROM TabulatedResults
WHERE sum_count = 7