WITH PossibleGeoLocations AS (
  SELECT * 
  FROM Insurance 
  GROUP BY lat, lon 
  HAVING COUNT(*) = 1 
  ORDER BY lat, lon 
  DESC
),
Duplicate2015_tiv AS (
  SELECT tiv_2015
  FROM Insurance
  GROUP BY tiv_2015
  HAVING COUNT(tiv_2015) > 1
)
SELECT ROUND(SUM(tiv_2016),2) AS tiv_2016
FROM PossibleGeoLocations p
RIGHT JOIN Duplicate2015_tiv d
ON p.tiv_2015 = d.tiv_2015
