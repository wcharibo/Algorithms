-- 코드를 작성해주세요
SELECT SUM(G.SCORE) AS SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM HR_EMPLOYEES AS E
JOIN HR_GRADE AS G ON G.EMP_NO = E.EMP_NO
GROUP BY G.EMP_NO
ORDER BY SCORE DESC LIMIT 1