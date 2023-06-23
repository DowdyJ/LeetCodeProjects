WITH CategorizedAccounts AS (
    SELECT
        income,
        IF(income < 20000, 'Low Salary', IF(income <= 50000, 'Average Salary', 'High Salary')) AS category
    FROM
        Accounts
)
SELECT * FROM
(SELECT
    category,
    COUNT(*) AS accounts_count
FROM CategorizedAccounts
GROUP BY category
UNION
SELECT
    'Low Salary' AS category,
    0 AS accounts_count
UNION
SELECT
    'Average Salary' AS category,
    0 AS accounts_count
UNION
SELECT
    'High Salary' AS category,
    0 AS accounts_count) t
GROUP BY category
ORDER BY accounts_count