-- 코드를 입력하세요
WITH CTE AS(
    SELECT *, RANK() OVER(PARTITION BY CATEGORY ORDER BY PRICE DESC) AS RK
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
)

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM CTE
WHERE RK = 1
ORDER BY PRICE DESC