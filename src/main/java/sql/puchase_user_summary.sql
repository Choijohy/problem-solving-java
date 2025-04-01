# 실수한 부분:
# "회원수" -> 같은 회원에 대한 중복 제거 처리 필요

SELECT
    YEAR(sale.sales_date) AS YEAR,
    MONTH(sale.sales_date) AS MONTH,
    user.GENDER AS GENDER,
    COUNT(DISTINCT user.USER_ID) AS USERS
FROM USER_INFO user
JOIN ONLINE_SALE sale ON user.USER_ID = sale.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR(sale.sales_date),  MONTH(sale.sales_date), user.GENDER
ORDER BY YEAR(sale.sales_date),  MONTH(sale.sales_date), user.GENDER