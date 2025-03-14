# 틀린 지점 - 날짜 구하기
# 단순히 START_DATE > '2022-11-30' OR END_DATE < '2022-11-01'으로 대여가능 차를 선택하면 안됨 -> A차가 2개의 대여 이력을 가질 수 있고,
# 만약 첫번째 이력은 위의 조건에 포함되지 않으나, 두번째 이력은 위의 조건에 포함(=11월 대여이력이 있는) 차 일 경우, A는 결과에 포함되면 안됨에도 포함되는 문제가 생김.
# 단순히   WHERE START_DATE  BETWEEN '2022-11-01' AND '2022-11-30 OR END_DATE'  BETWEEN ' 2022-11-01' AND '2022-11-30'로 제외할 차를 구해도 안됨.
#  -> 2022-01-01 ~ 2023-01-01 이런 이력은 못 잡아냄
# TRUNCATE()


WITH EXCLUDED_CARS AS (
    SELECT DISTINCT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    # WHERE START_DATE  BETWEEN '2022-11-01' AND '2022-11-30'
    # OR END_DATE  BETWEEN '2022-11-01' AND '2022-11-30'
    WHERE NOT (
        END_DATE < '2022-11-01'
        OR START_DATE > '2022-11-30'
    )
),
# 11월 중 대여 이력이 존해하는 CAR_ID 추출 -> EXCLUDED_CARS
# 1) SUV 혹은 세단 2) EXCLUDED_CARS에 속하지 않는 자동차 3) 할인율 타입은 30일 이상
SELECTED_CARS AS (
SELECT
    car.CAR_ID,
    car.CAR_TYPE,
    TRUNCATE((car.DAILY_FEE  * (1 - (plan.DISCOUNT_RATE * 0.01)) * 30), -1)  AS FEE
FROM CAR_RENTAL_COMPANY_CAR car
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN plan
ON car.CAR_TYPE = plan.CAR_TYPE
WHERE car.CAR_TYPE IN ("세단","SUV")
AND car.CAR_ID NOT IN ((SELECT CAR_ID FROM EXCLUDED_CARS))
AND plan.DURATION_TYPE = "30일 이상"
)
SELECT
    *
FROM SELECTED_CARS car
WHERE FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC


