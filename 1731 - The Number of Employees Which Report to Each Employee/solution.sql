SELECT
    m.boss_id AS employee_id,
    e.name AS name,
    m.report_count AS reports_count,
    m.average_age AS average_age
FROM (
    SELECT
        reports_to AS boss_id,
        COUNT(*) AS report_count,
        ROUND(AVG(age), 0) AS average_age
    FROM Employees
    GROUP BY reports_to) m, 
    Employees e
WHERE e.employee_id = m.boss_id
ORDER BY e.employee_id