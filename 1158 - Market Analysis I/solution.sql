SELECT 
  u1.user_id AS buyer_id, 
  u1.join_date AS join_date, 
  IFNULL(orders_in_2019 , 0) AS orders_in_2019
FROM (
  SELECT 
    u.user_id, 
    u.join_date,
    COUNT(*) AS orders_in_2019 
  FROM Users u 
  LEFT JOIN Orders o 
  ON u.user_id = o.buyer_id
  WHERE YEAR(order_date) = '2019'
  GROUP BY u.user_id) uwu
RIGHT JOIN Users u1
ON u1.user_id = uwu.user_id;

