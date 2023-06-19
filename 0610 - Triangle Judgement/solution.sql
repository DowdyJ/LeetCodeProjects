SELECT *, IF ((x + y + z) > (2 * GREATEST(x, y, z)), 'Yes', 'No') AS triangle FROM Triangle;
