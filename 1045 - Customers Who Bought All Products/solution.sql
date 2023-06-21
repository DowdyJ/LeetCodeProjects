WITH UniquePurchases AS (
    SELECT DISTINCT customer_id, product_key 
    FROM Customer
),
CustomerSums AS (
    SELECT
        customer_id,
        SUM(product_key) OVER (PARTITION BY customer_id) AS customerSum
    FROM UniquePurchases
),
ProductSum AS (
    SELECT SUM(product_key) as productSum
    FROM Product
)
SELECT DISTINCT customer_id
FROM CustomerSums c
WHERE c.customerSum = (SELECT productSum FROM ProductSum);

