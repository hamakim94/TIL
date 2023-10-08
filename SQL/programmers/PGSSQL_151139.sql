SELECT MONTH(START_DATE) as MONTH, CAR_ID , COUNT(*) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE MONTH(START_DATE) BETWEEN 8 AND 10
    AND YEAR(START_DATE) = 2022
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5
) AND MONTH(START_DATE) BETWEEN 8 AND 10
AND YEAR(START_DATE) = 2022
GROUP BY MONTH(START_DATE), CAR_ID
HAVING(COUNT(CAR_ID) > 0)
ORDER BY MONTH, CAR_ID DESC;