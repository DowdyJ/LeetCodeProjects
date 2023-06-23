WITH StudentsWithExamCount AS (
    SELECT
        student_id,
        subject_name,
        COUNT(subject_name) AS attended_exams
    FROM
        Examinations
    GROUP BY
        student_id, subject_name
),
StudentsWithSubjects AS (
    SELECT
        st.student_id AS student_id,
        st.student_name AS student_name,
        su.subject_name AS subject_name
    FROM Students st
    CROSS JOIN Subjects su
)
SELECT
    sws.student_id AS student_id,
    sws.student_name AS student_name,
    sws.subject_name AS subject_name,
    IF(swec.attended_exams IS NULL, 0 , swec.attended_exams) AS attended_exams
FROM StudentsWithSubjects sws
LEFT JOIN StudentsWithExamCount swec
ON 
    swec.student_id = sws.student_id AND 
    swec.subject_name = sws.subject_name
ORDER BY student_id, subject_name