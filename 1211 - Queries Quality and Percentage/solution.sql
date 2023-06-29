WITH AugmentedTable AS (
    SELECT
        query_name,
        rating / position AS quality,
        IF (rating < 3, 1, 0) AS poor_queries
    FROM Queries
)
SELECT
    query_name,
    ROUND(AVG(quality), 2)AS quality,
    ROUND((SUM(poor_queries) / COUNT(*)) * 100, 2) AS poor_query_percentage
FROM AugmentedTable
GROUP BY query_name
ORDER BY query_name