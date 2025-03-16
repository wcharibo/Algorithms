-- 코드를 입력하세요
SELECT YEAR(S.SALES_DATE) AS YEAR, MONTH(S.SALES_DATE) AS MONTH, U.GENDER, COUNT(DISTINCT S.USER_ID) AS USERS
FROM ONLINE_SALE AS S
JOIN USER_INFO AS U ON S.USER_ID = U.USER_ID
WHERE U.GENDER IS NOT NULL
GROUP BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE), U.GENDER
ORDER BY YEAR ASC, MONTH ASC, U.GENDER ASC