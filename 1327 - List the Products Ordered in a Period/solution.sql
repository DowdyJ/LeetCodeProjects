WITH FebOrders AS (
    SELECT *
    FROM Orders
    WHERE  MONTH(order_date) = '02' AND YEAR(order_date) = '2020'
)
SELECT
    p.product_name AS product_name,
    SUM(f.unit) AS unit
FROM FebOrders f
LEFT JOIN Products p
ON p.product_id = f.product_id
GROUP BY f.product_id
HAVING unit >= 100
