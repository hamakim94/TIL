SELECT MCDP_CD as '진료과코드', COUNT(*) as '5월예약건수'
FROM APPOINTMENT
WHERE LEFT(APNT_YMD,7) = '2022-05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, 진료과코드;