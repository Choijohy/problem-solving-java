with cte as(
    select category, max(price) as max_price
    from food_product
    group by category
)
select
 p.category AS CATEGORY,
 c.max_price as MAX_PRICE,
 p.product_name AS PRODUCT_NAME
from cte c
join food_product p
on p.category = c.category
and p.price = c.max_price
where p.category in ('과자','국','김치','식용유')
order by MAX_PRICE desc;


with cte as(
    select category, max(price) as max_price
    from food_product
    where category in ('과자','국','김치','식용유')
    group by category
)
select
 p.category AS CATEGORY,
 c.max_price as MAX_PRICE,
 p.product_name AS PRODUCT_NAME
from cte c
join food_product p
on p.category = c.category
and p.price = c.max_price
order by MAX_PRICE desc;