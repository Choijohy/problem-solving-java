SELECT
    b.ANIMAL_ID,
    b.NAME
FROM ANIMAL_INS a
RIGHT JOIN ANIMAL_OUTS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE a.ANIMAL_ID IS NULL

ORDER BY b.ANIMAL_ID;


SELECT
    RESULT.ANIMAL_ID
(SELECT
    b.ANIMAL_ID,
    b.NAME
FROM ANIMAL_INS a
RIGHT JOIN ANIMAL_OUTS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE a.ANIMAL_ID IS NULL

UNION

SELECT
    a.ANIMAL_ID,
    a.NAME
FROM ANIMAL_INS a
LEFT JOIN ANIMAL_OUTS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE a.ANIMAL_ID IS NULL
)
RESULT
ORDER BY b.ANIMAL_ID;