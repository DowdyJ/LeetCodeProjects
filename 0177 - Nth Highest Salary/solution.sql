CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT IF (
        COUNT(DISTINCT(salary)) < N, 
        NULL, (
        SELECT TopN.salary
        FROM (
            SELECT salary 
            FROM Employee e 
            GROUP BY e.salary
            ORDER BY e.salary 
            DESC LIMIT N
            ) AS TopN 
        ORDER BY TopN.salary ASC LIMIT 1)
        ) AS SecondHighestSalary FROM Employee
  );
END