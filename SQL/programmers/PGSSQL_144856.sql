-- 코드를 입력하세요
SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * BS.SALES) AS TOTAL_SALES
FROM BOOK B
INNER JOIN AUTHOR A
ON B.author_id = A.author_id
INNER JOIN BOOK_SALES BS
on B.BOOK_ID = BS.BOOK_ID
WHERE LEFT(BS.SALES_DATE, 7) = '2022-01'
GROUP BY B.AUTHOR_ID, B.CATEGORY
ORDER BY B.AUTHOR_ID , B.CATEGORY DESC;
