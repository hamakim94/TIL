-- 코드를 입력하세요
SELECT * FROM
    (SELECT LEFT(sales_date,10)as sales_date, product_id, user_id, sales_amount
    FROM ONLINE_SALE
    WHERE LEFT(sales_date, 7) = '2022-03'
    UNION
    SELECT LEFT(sales_date, 10) as sales_date, product_id, NULL as user_id, sales_amount
    FROM OFFLINE_SALE
    WHERE LEFT(sales_date, 7) = '2022-03')
ORDER BY sales_date ASC, product_id ASC, user_id ASC;