-- 코드를 작성해주세요
WITH RECURSIVE CTE AS(
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT E.ID, E.PARENT_ID, C.GENERATION + 1 AS GENERATION
    FROM ECOLI_DATA AS E
    JOIN CTE AS C ON E.PARENT_ID = C.ID
)

SELECT ID
FROM CTE
WHERE GENERATION = 3
ORDER BY ID ASC