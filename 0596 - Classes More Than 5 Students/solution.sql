SELECT class FROM (SELECT class, COUNT(class) AS ccount FROM Courses GROUP BY class) AS CourseCount WHERE CourseCount.ccount >= 5;
