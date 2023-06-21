WITH RankedEmployees AS (
    SELECT 
        e.name AS employee_name,
        e.departmentId AS departmentId,
        e.salary AS salary,
        DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) AS salaryRank
    FROM
        Employee e)
SELECT 
    d.name AS Department,
    employee_name AS Employee,
    salary AS Salary
FROM (RankedEmployees
JOIN Department d
ON d.id = departmentId)
WHERE salaryRank <= 3

