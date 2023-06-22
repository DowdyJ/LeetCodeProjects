SELECT
    employee_id,
    IF(MOD(employee_id,2) = 0, 0, IF(LEFT(name, 1) = 'M', 0, salary)) AS bonus
FROM Employees
ORDER BY employee_id ASC;