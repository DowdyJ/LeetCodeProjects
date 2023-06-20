SELECT customer_id, COUNT(customer_id) AS count_no_trans
FROM Visits
WHERE visit_id
NOT IN (
  SELECT v.visit_id AS visit_id 
  FROM Visits v
  RIGHT JOIN Transactions t 
  ON v.visit_id = t.visit_id
  )
GROUP BY customer_id;

