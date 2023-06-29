WITH MostRatingsGiven AS (
    SELECT 
        u.name
    FROM (SELECT
        user_id,
        COUNT(*) AS movies_rated
    FROM MovieRating
    GROUP BY user_id
    ORDER BY movies_rated DESC) r
    INNER JOIN Users u ON r.user_id = u.user_id
    ORDER BY movies_rated DESC, name ASC
    LIMIT 1
),
MostRatedMovie AS (
    SELECT
        title,
        AVG(rating) AS rating
    FROM (SELECT 
        m.title,
        mr.movie_id,
        mr.rating,
        mr.created_at
    FROM MovieRating mr
    INNER JOIN Movies m ON m.movie_id = mr.movie_id
    WHERE MONTH(created_at) = '02' AND YEAR(created_at) = '2020') uwu
    GROUP BY movie_id
    ORDER BY rating DESC, title ASC
    LIMIT 1
)
SELECT title AS results 
FROM MostRatedMovie
UNION ALL
SELECT name AS results
FROM MostRatingsGiven
