SELECT actor_id, director_id FROM ActorDirector GROUP BY director_id, actor_id HAVING COUNT(*) >= 3
