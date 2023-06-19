SELECT s2.score, eggy.r AS 'rank' FROM Scores s2 LEFT JOIN (
  SELECT 
    s1.score AS score, 
    @rank := @rank + 1 AS r
  FROM 
    (SELECT s.score FROM Scores s GROUP BY s.score ORDER BY s.score DESC) s1, 
    (SELECT @rank := 0) vars
  ) eggy ON eggy.score = s2.score ORDER BY eggy.r ASC;