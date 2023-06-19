SELECT s.name AS name 
FROM SalesPerson s 
WHERE s.sales_id NOT IN (
  SELECT o.sales_id AS sales_id 
  FROM Orders o 
  WHERE com_id IN (
    SELECT c.com_id 
    FROM Company c 
    WHERE name = 'RED'
    )
  )

