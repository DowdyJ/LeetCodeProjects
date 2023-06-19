SELECT IF (
  COUNT(DISTINCT(salary)) < 2, 
  NULL, (
    SELECT TopN.salary
    FROM (
      SELECT salary 
      FROM Employee e 
      GROUP BY e.salary
      ORDER BY e.salary 
      DESC LIMIT 2
      ) AS TopN 
    ORDER BY TopN.salary ASC LIMIT 1)
  ) AS SecondHighestSalary FROM Employee;