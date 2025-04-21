
WITH cte AS(
    SELECT
        emp.EMP_NO,
        AVG(grade.SCORE) AS SCORE
    FROM HR_EMPLOYEES emp
    JOIN HR_GRADE grade ON emp.EMP_NO = grade.EMP_NO
    GROUP BY EMP_NO
)
SELECT
    cte.EMP_NO,
    emp.EMP_NAME,
    CASE
        WHEN cte.SCORE >= 96 THEN "S"
        WHEN cte.SCORE >= 90 THEN "A"
        WHEN cte.SCORE >= 80 THEN "B"
        ELSE "C"
    END AS GRADE,
    CASE
        WHEN cte.SCORE >= 96 THEN emp.SAL * 0.2
        WHEN cte.SCORE >= 90 THEN emp.SAL * 0.15
        WHEN cte.SCORE >= 80 THEN emp.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM cte
JOIN HR_EMPLOYEES emp ON cte.EMP_NO = emp.EMP_NO
ORDER BY cte.EMP_NO;