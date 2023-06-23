WITH FirstYearProduct AS (
    SELECT
        s.price AS price,
        s.year AS year,
        s.quantity AS quantity,
        p.product_id AS product_id,
        MIN(s.year) OVER(PARTITION BY p.product_id) AS first_year
    FROM Sales s
    INNER JOIN Product p ON p.product_id = s.product_id
)
SELECT
    product_id,
    first_year,
    quantity,
    price
FROM FirstYearProduct
WHERE first_year = year
