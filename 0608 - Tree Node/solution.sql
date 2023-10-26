WITH Root AS (
    SELECT id, 'Root' AS type
    FROM Tree
    WHERE p_id IS NULL
),
Leaf AS (
    SELECT id, 'Leaf' AS type
    FROM Tree
    WHERE id NOT IN (SELECT p_id FROM Tree WHERE p_id IS NOT NULL) 
    AND id NOT IN (SELECT id FROM Root)
),
_Inner AS (
    SELECT id, 'Inner' AS type
    FROM Tree t
    WHERE NOT EXISTS (SELECT 1 FROM Leaf l WHERE l.id = t.id)
    AND NOT EXISTS (SELECT 1 FROM Root r WHERE r.id = t.id)
)
SELECT * FROM Root 
UNION 
SELECT * FROM Leaf 
UNION 
SELECT * FROM _Inner
