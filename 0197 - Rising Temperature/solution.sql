SELECT w1.id AS Id FROM Weather w1, Weather w2 WHERE w1.recordDate > w2.recordDate AND w1.recordDate = ADDDATE(w2.recordDate, INTERVAL 1 DAY) AND w1.temperature > w2.temperature;
