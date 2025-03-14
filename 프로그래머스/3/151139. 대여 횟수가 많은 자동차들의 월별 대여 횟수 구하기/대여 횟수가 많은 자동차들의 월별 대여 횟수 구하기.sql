-- 코드를 입력하세요
WITH CTE AS(
    SELECT *, COUNT(*) OVER(PARTITION BY CAR_ID) AS COUNT
    FROM CAR_RENTAL_COMPANy_RENTAL_HISTORY
    WHERE YEAR(START_DATE) = 2022
      AND MONTH(START_DATE) IN(8,9,10)
)
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CTE
WHERE COUNT >= 5
GROUP BY MONTH(START_DATE), CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC
