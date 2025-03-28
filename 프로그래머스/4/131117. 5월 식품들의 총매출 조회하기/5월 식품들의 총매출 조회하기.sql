-- 코드를 입력하세요
SELECT O.PRODUCT_ID, P.PRODUCT_NAME, SUM(O.AMOUNT) * MAX(P.PRICE) AS TOTAL_SALES
FROM FOOD_ORDER O
LEFT JOIN FOOD_PRODUCT AS P ON O.PRODUCT_ID = P.PRODUCT_ID
WHERE MONTH(O.PRODUCE_DATE) = 5 AND YEAR(O.PRODUCE_DATE) = 2022
GROUP BY O.PRODUCT_ID

ORDER BY TOTAL_SALES DESC, O.PRODUCT_ID ASC