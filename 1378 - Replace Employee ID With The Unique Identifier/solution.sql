SELECT
    eu.unique_id AS unique_id,
    e.name AS name
FROM EmployeeUNI eu
RIGHT JOIN Employees e
ON e.id = eu.id