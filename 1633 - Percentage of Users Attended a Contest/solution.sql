SELECT 
    totals.contest_id as contest_id, 
    ROUND(((totals.attendance / (SELECT COUNT(*) FROM Users)) * 100), 2) as percentage
FROM (
    SELECT 
        contest_id, 
        COUNT(contest_id) AS 'attendance'
    FROM Register 
    GROUP BY contest_id) AS totals
ORDER BY percentage DESC, contest_id ASC;
