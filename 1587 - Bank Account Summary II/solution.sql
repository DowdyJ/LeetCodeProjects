SELECT u.name, b.balance 
FROM (
  SELECT account, SUM(amount) AS balance 
  FROM Transactions 
  GROUP BY account 
  HAVING SUM(amount) > 10000
  ) AS b 
LEFT JOIN Users AS u ON u.account = b.account
