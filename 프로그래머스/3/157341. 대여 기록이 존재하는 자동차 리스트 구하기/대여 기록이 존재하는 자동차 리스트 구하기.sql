-- 코드를 입력하세요
SELECT C.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS R
LEFT JOIN CAR_RENTAL_COMPANY_CAR AS C ON R.CAR_ID = C.CAR_ID
WHERE MONTH(R.START_DATE) = 10
  AND C.CAR_TYPE = '세단'
GROUP BY C.CAR_ID
ORDER BY C.CAR_ID DESC