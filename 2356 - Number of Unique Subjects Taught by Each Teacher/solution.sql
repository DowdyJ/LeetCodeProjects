SELECT DISTINCT teacher_id, COUNT(DISTINCT subject_id) OVER(PARTITION BY teacher_id) AS cnt FROM Teacher;
