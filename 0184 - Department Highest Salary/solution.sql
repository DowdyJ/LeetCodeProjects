SELECT
    d.name AS department,
    e.name AS employee,
    e.salary AS salary
FROM Employee e
LEFT JOIN Department d
ON d.id = e.departmentId
WHERE (d.name, e.salary) IN (
    SELECT d2.name AS departmentName, MAX(salary)
    FROM Employee e2
    LEFT JOIN Department d2
    ON d2.id = e2.departmentId
    GROUP BY d2.name
);

-- Alternate method

SELECT
    department,
    employee,
    salary
FROM (
    SELECT
        e.salary AS salary,
        d.name AS department,
        e.name AS employee,
        MAX(e.salary) OVER(PARTITION BY d.name) AS maxSalary
    FROM Employee e
    LEFT JOIN Department d
    ON d.id = e.departmentId
) m
WHERE 
    salary = maxSalary;
