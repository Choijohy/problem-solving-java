SELECT
    parent.ID,
    COUNT(child.ID) AS CHILD_COUNT
FROM ECOLI_DATA parent
LEFT JOIN ECOLI_DATA child ON child.PARENT_ID = parent.ID
GROUP BY parent.ID;