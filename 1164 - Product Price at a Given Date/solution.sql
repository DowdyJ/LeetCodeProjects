WITH AugmentedProducts AS (
    SELECT 
        product_id,
        new_price,
        MAX(change_date) OVER(PARTITION BY product_id) AS most_recent_change
    FROM Products
    WHERE change_date <= '2019-08-16'
),
RecentlyChangedProducts AS (
    SELECT
        p.product_id AS product_id,
        p.new_price AS price
    FROM Products p
    INNER JOIN AugmentedProducts a ON a.product_id = p.product_id
    WHERE p.change_date = a.most_recent_change
),
UnchangedProducts AS (
    SELECT 
        product_id,
        10 AS price
    FROM Products
    WHERE product_id NOT IN (SELECT product_id FROM RecentlyChangedProducts)
)
SELECT * 
FROM RecentlyChangedProducts 
UNION 
SELECT * 
FROM UnchangedProducts
