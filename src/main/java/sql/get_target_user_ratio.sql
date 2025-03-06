# 2021년 가입자 ID
# 2021년 가입자의 총 명수 -> 158명
# 구매이력에서 2021년 가입자의 명수와 비율(2021년 총 가입자 대비 구매자의 비율) -> 년/월별 통계 (전체 111개 구매)
# 레벨5: https://school.programmers.co.kr/learn/courses/30/lessons/131534

WITH target_users AS(
  SELECT USER_ID FROM USER_INFO WHERE JOINED BETWEEN '2021-01-01' AND '2021-12-31'
),
target_users_count AS(
  SELECT COUNT(*) AS TOTAL FROM target_users
),
all_sales_months AS(
  SELECT
        YEAR(o.SALES_DATE) AS Y,
        MONTH(o.SALES_DATE) AS M
  FROM ONLINE_SALE o
  GROUP BY YEAR(o.SALES_DATE), MONTH(o.SALES_DATE)
),
all_purchase_count AS(
  SELECT
    YEAR(o.SALES_DATE) Y,
    MONTH(o.SALES_DATE) M,
    COUNT(DISTINCT o.USER_ID) AS PURCHASED_USERS
  FROM ONLINE_SALE o
  JOIN target_users ON o.USER_ID in (target_users.USER_ID)
  GROUP BY YEAR(o.SALES_DATE), MONTH(o.SALES_DATE)
)
SELECT
    s.Y AS YEAR,
    s.M AS MONTH,
    p.PURCHASED_USERS,
    ROUND(COALESCE(PURCHASED_USERS,0) * 1.0/tc.TOTAL,1) AS PURCHASED_RATIO
FROM all_sales_months s
LEFT JOIN all_purchase_count p ON s.Y = p.Y AND s.M = p.M
CROSS JOIN target_users_count tc
ORDER BY s.Y, s.M;


# 비교
SELECT YEAR(SALES_DATE) YEAR,
       MONTH(SALES_DATE) MONTH,
       COUNT(DISTINCT S.USER_ID) AS PURCHASED_USERS,
       ROUND(COUNT(DISTINCT S.USER_ID) / (SELECT COUNT(USER_ID)
                                        FROM USER_INFO
                                        WHERE JOINED LIKE '2021%'), 1) AS PUCHASED_RATIO
FROM ONLINE_SALE S
JOIN USER_INFO I
    ON S.USER_ID = I.USER_ID
WHERE I.JOINED LIKE '2021%'
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONT