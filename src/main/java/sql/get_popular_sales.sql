WITH FILTERED_CAR AS (SELECT
    CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN '2022-08-01' and '2022-10-31'
GROUP BY CAR_ID
HAVING COUNT(*) >= 5
)
SELECT
    MONTH(START_DATE) AS MONTH,
    a.CAR_ID,
    COUNT(*) AS RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY a
JOIN FILTERED_CAR b ON a.CAR_ID = b.CAR_ID
WHERE START_DATE BETWEEN '2022-08-01' and '2022-10-31'
GROUP BY MONTH, CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC;