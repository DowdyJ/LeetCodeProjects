WITH BadSales AS (
  SELECT * 
  FROM Sales 
  WHERE sale_date 
  NOT BETWEEN '2019-01-01' AND '2019-03-31'
)
SELECT DISTINCT p.product_id, p.product_name
FROM Product p
LEFT JOIN Sales s
ON p.product_id = s.product_id
WHERE p.product_id NOT IN (
  SELECT product_id 
  FROM BadSales
) AND p.product_id IN (
  SELECT product_id FROM Sales
)
