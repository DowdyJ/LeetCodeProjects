WITH GoodEmployees AS (
  SELECT s.employee_id
  FROM Salaries s
  INNER JOIN Employees e
  ON s.employee_id = e.employee_id
)
SELECT employee_id 
FROM Salaries
WHERE employee_id NOT IN (SELECT employee_id FROM GoodEmployees)
UNION
SELECT employee_id 
FROM Employees
WHERE employee_id NOT IN (SELECT employee_id FROM GoodEmployees)
ORDER BY employee_id ASC