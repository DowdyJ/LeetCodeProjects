-- Solution 1
SELECT name AS Employee FROM Employee e WHERE (SELECT e2.salary FROM Employee e2 WHERE e.managerId = e2.id) < e.salary;

-- Solution 2
SELECT e1.name AS Employee FROM Employee e1, Employee e2 WHERE e1.managerId = e2.id AND e1.salary > e2.salary;