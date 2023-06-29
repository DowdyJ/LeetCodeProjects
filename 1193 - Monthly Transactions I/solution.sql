
WITH MonthlyTransactions AS (
    SELECT
        DATE_FORMAT(trans_date, '%Y-%m') AS date_month,
        id,
        country,
        state,
        amount
    FROM Transactions
)
SELECT
    date_month AS month,
    country,
    COUNT(*) AS trans_count,
    COUNT(IF(state = 'approved', amount, NULL)) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(IF(state = 'approved', amount, NULL)) AS approved_total_amount
FROM MonthlyTransactions
GROUP BY country, date_month
